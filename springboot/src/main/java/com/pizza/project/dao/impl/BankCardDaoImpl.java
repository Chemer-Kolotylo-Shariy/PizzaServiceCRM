package com.pizza.project.dao.impl;

import com.pizza.project.dao.BankCardDao;
import com.pizza.project.dao.ClientDao;
import com.pizza.project.dao.impl.sql.BankCardSQL;
import com.pizza.project.model.BankCard;
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
public class BankCardDaoImpl implements BankCardDao {

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private BankCardExtractor bankCardExtractor;

    @Autowired
    public BankCardDaoImpl(DataSource dataSource, ClientDao clientDao) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                                .withTableName(BankCardSQL.PARAM_TABLE)
                                .usingGeneratedKeyColumns(BankCardSQL.PARAM_ID);
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        bankCardExtractor = new BankCardExtractor(clientDao);
    }

    @Override
    public BankCard get(Long id) {
        if (id == null){
            return null;
        }
        return null;
    }

    @Override
    public Long create(BankCard object) {
        if (object.getId() != null){
            return null;
        }
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue(BankCardSQL.PARAM_NUMBER, object.getNumber())
                .addValue(BankCardSQL.PARAM_DATE, object.getDate())
                .addValue(BankCardSQL.PARAM_SECRET_CODE, object.getSecret_code());
        Long id = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long update(BankCard object) {
        return null;
    }

    @Override
    public Long remove(Long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(BankCardSQL.PARAM_ID, id);
        int row = jdbcTemplate.update(BankCardSQL.QUERY_DELETE, parameter);
        if (row > 0){
            return id;
        }
        return null;
    }

    @Override
    public List<BankCard> getByClientId(Long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(BankCardSQL.PARAM_ID_CLIENT, id);

        return jdbcTemplate.query(BankCardSQL.QUERY_GET_BY_ID_CLIENT, parameter, bankCardExtractor);
    }

    @Override
    public BankCard getByNumberAndDateAndSecredCode(Long id, int date, int secredCode) {
        return null;
    }

    @Override
    public Long createWithClientId(BankCard bankCard) {
        if (bankCard.getId() != null){
            return null;
        }
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue(BankCardSQL.PARAM_NUMBER, bankCard.getNumber())
                .addValue(BankCardSQL.PARAM_DATE, bankCard.getDate())
                .addValue(BankCardSQL.PARAM_SECRET_CODE, bankCard.getSecret_code())
                .addValue(BankCardSQL.PARAM_ID_CLIENT, bankCard.getClient().getId());
        Long id = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
        bankCard.setId(id);
        return id;
    }

    private class BankCardExtractor implements ResultSetExtractor<List<BankCard>>{
        private ClientDao clientDao;

        @Autowired
        public BankCardExtractor(ClientDao clientDao) {
            this.clientDao = clientDao;
        }

        @Override
        public List<BankCard> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<BankCard> bankCards = new ArrayList<>();

            while (resultSet.next()){
                BankCard bankCard = new BankCard();

                bankCard.setId(resultSet.getLong(BankCardSQL.PARAM_ID));
                bankCard.setNumber(resultSet.getLong(BankCardSQL.PARAM_NUMBER));
                bankCard.setDate(resultSet.getInt(BankCardSQL.PARAM_DATE));
                bankCard.setSecret_code(resultSet.getInt(BankCardSQL.PARAM_SECRET_CODE));
                bankCard.setClient(clientDao.get(resultSet.getLong(BankCardSQL.PARAM_ID_CLIENT)));

                bankCards.add(bankCard);
            }
            return bankCards;
        }
    }
}
