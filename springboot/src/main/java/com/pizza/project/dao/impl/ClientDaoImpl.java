package com.pizza.project.dao.impl;

import com.pizza.project.dao.ClientDao;
import com.pizza.project.dao.impl.sql.ClientSQL;
import com.pizza.project.model.Client;
import com.pizza.project.model.enums.Role;
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
public class ClientDaoImpl implements ClientDao {

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private ClientExtractor clientExtractor;

    @Autowired
    public ClientDaoImpl(DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(ClientSQL.PARAM_TABLE)
                .usingGeneratedKeyColumns(ClientSQL.PARAM_ID);
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        clientExtractor = new ClientExtractor();
    }

    @Override
    public Client getByPhone(String phone) {
        return null;
    }

    @Override
    public List getAllClients() {
        return null;
    }

    @Override
    public Client get(Long id) {
        if (id == null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(ClientSQL.PARAM_ID, id);

        return jdbcTemplate.query(ClientSQL.QUERY_GET_BY_ID, parameter, clientExtractor).stream().findFirst().orElse(null);
    }

    @Override
    public Long create(Client object) {
        return null;
    }

    @Override
    public Long update(Client object) {
        return null;
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    private class ClientExtractor implements ResultSetExtractor<List<Client>>{

        @Override
        public List<Client> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Client> clients = new ArrayList<>();

            while (resultSet.next()){
                Client client = new Client();

                client.setId(resultSet.getLong(ClientSQL.PARAM_ID));
                client.setName(resultSet.getString(ClientSQL.PARAM_NAME));
                client.setSurname(resultSet.getString(ClientSQL.PARAM_SURNAME));
                client.setEmail(resultSet.getString(ClientSQL.PARAM_EMAIL));
                client.setPhone(resultSet.getString(ClientSQL.PARAM_PHONE));
                client.setPassword(resultSet.getString(ClientSQL.PARAM_PASSWORD));
                client.setRole(Role.valueOf(resultSet.getString(ClientSQL.PARAM_ROLE)));

                clients.add(client);
            }
            return clients;
        }
    }
}
