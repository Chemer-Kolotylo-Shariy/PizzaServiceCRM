package com.pizza.project.dao.impl;

import com.pizza.project.dao.AddressDao;
import com.pizza.project.dao.ClientAddressDao;
import com.pizza.project.dao.ClientDao;
import com.pizza.project.dao.impl.sql.ClientAddressSQL;
import com.pizza.project.model.ClientAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientAddressDaoImpl implements ClientAddressDao {
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private ClientAddressExtractor clientAddressExtractor;

    @Autowired
    public ClientAddressDaoImpl(DataSource dataSource, ClientDao clientDao, AddressDao addressDao) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(ClientAddressSQL.PARAM_TABLE);
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        clientAddressExtractor = new ClientAddressExtractor(clientDao, addressDao);
    }

    @Override
    public List<ClientAddress> getAll() {
        return jdbcTemplate.query(ClientAddressSQL.QUERY_GET_ALL, clientAddressExtractor);
    }

    @Override
    public Long removeByClientId(Long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(ClientAddressSQL.PARAM_ID_CLIENT, id);
        int rows = jdbcTemplate.update(ClientAddressSQL.QUERY_DELETE_BY_ID_CLIENT, parameter);
        if (rows > 0){
            return id;
        }
        return id;
    }

    @Override
    public ClientAddress get(Long id) {
        return null;
    }

    @Override
    public Long create(ClientAddress object) {
        return null;
    }

    @Override
    public Long update(ClientAddress object) {
        return null;
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    private class ClientAddressExtractor implements ResultSetExtractor<List<ClientAddress>> {
        private ClientDao clientDao;
        private AddressDao addressDao;

        @Autowired
        public ClientAddressExtractor(ClientDao clientDao, AddressDao addressDao) {
            this.clientDao = clientDao;
            this.addressDao = addressDao;
        }

        @Override
        public List<ClientAddress> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<ClientAddress> clientAddresses = new ArrayList<>();

            while (resultSet.next()){
                ClientAddress clientAddress = new ClientAddress();

                clientAddress.setClient(clientDao.get(resultSet.getLong(ClientAddressSQL.PARAM_ID_CLIENT)));
                clientAddress.setAddress(addressDao.get(resultSet.getLong(ClientAddressSQL.PARAM_ID_ADDRESS)));

                clientAddresses.add(clientAddress);
            }
            return clientAddresses;
        }
    }
}
