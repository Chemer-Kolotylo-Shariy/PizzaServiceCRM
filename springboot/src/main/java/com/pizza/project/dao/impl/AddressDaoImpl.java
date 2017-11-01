package com.pizza.project.dao.impl;

import com.pizza.project.dao.AddressDao;
import com.pizza.project.dao.impl.sql.AddressSQL;
import com.pizza.project.dao.impl.sql.ClientAddressSQL;
import com.pizza.project.dao.impl.sql.ClientSQL;
import com.pizza.project.model.Address;
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
public class AddressDaoImpl implements AddressDao {
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private AddressExtractor addressExtractor;

    @Autowired
    public AddressDaoImpl(DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(AddressSQL.PARAM_TABLE)
                .usingGeneratedKeyColumns(AddressSQL.PARAM_ID);
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        addressExtractor = new AddressExtractor();
    }

    @Override
    public List<Address> getAllAddresesByClientId(int id) {
        return null;
    }

    @Override
    public List<Address> getAddressesByClientIdAndLableNotNull(Long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(ClientAddressSQL.PARAM_ID_CLIENT, id);
        return jdbcTemplate.query(AddressSQL.QUERY_GET_ADDRESS_BY_CLIENT_ID_AND_LABLE_NOT_NULL, parameter, addressExtractor);
    }

    @Override
    public Address get(Long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(AddressSQL.PARAM_ID, id);
        return jdbcTemplate.query(AddressSQL.QUERY_GET_BY_ID, parameter, addressExtractor).stream().findFirst().orElse(null);
    }

    @Override
    public Long create(Address object) {
        if(object.getId() != null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(AddressSQL.PARAM_STREET, object.getStreet())
                .addValue(AddressSQL.PARAM_HOUSE, object.getHouse())
                .addValue(AddressSQL.PARAM_APARTAMENT, object.getApartament())
                .addValue(AddressSQL.PARAM_LABLE, object.getLable());
        Long id = simpleJdbcInsert.executeAndReturnKey(parameter).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long update(Address object) {
        return null;
    }

    @Override
    public Long remove(Long id) {
        return null;
    }
     private class AddressExtractor implements ResultSetExtractor<List<Address>>{

         @Override
         public List<Address> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
             List<Address> addresses = new ArrayList<>();
             while (resultSet.next()){
                 Address address = new Address();

                 address.setId(resultSet.getLong(AddressSQL.PARAM_ID));
                 address.setStreet(resultSet.getString(AddressSQL.PARAM_STREET));
                 address.setHouse(resultSet.getString(AddressSQL.PARAM_HOUSE));
                 address.setApartament(Integer.parseInt(resultSet.getString(AddressSQL.PARAM_APARTAMENT) != null ?
                         resultSet.getString(AddressSQL.PARAM_APARTAMENT) : "0"));
                 address.setLable(resultSet.getString(AddressSQL.PARAM_LABLE));

                 addresses.add(address);
             }
             return addresses;
         }
     }
}
