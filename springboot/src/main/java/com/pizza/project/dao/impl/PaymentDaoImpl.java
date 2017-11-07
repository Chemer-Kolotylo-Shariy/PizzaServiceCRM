package com.pizza.project.dao.impl;

import com.pizza.project.dao.PaymentDao;
import com.pizza.project.dao.impl.sql.PaymentSQL;
import com.pizza.project.model.Payment;
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
public class PaymentDaoImpl implements PaymentDao<Payment> {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;
    private PaymentExtractor paymentExtractor;

    public PaymentDaoImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(PaymentSQL.PARAM_TABLE)
                .usingGeneratedKeyColumns(PaymentSQL.PARAM_ID);
        paymentExtractor = new PaymentExtractor();
    }

    @Override
    public Payment get(Integer id) {
        if (id == null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(PaymentSQL.PARAM_ID, id);
        return jdbcTemplate.query(PaymentSQL.QUERY_GET_BY_ID, parameter, paymentExtractor).stream().findFirst().orElse(null);
    }

    @Override
    public Integer create(Payment payment) {
        if (payment.getId() != null){
            return null;
        }

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue(PaymentSQL.PARAM_PAYMENT, payment.getPayment());
        Integer id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        payment.setId(id);
        return id;
    }

    @Override
    public Integer remove(Integer id) {
        SqlParameterSource parameter = new MapSqlParameterSource(PaymentSQL.PARAM_ID, id);
        ///////////////////////////////////////////////////////////////////////////////////////
        Integer rows = jdbcTemplate.update(PaymentSQL.QUERY_DELETE_BY_ID, parameter);
        if (rows > 0){
            return rows;
        }
        return null;
    }

    @Override
    public List<Payment> getAllPaymentMethods() {
        return jdbcTemplate.query(PaymentSQL.QUERY_GET_ALL,paymentExtractor);
    }

    private class PaymentExtractor implements ResultSetExtractor<List<Payment>> {

        @Override
        public List<Payment> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Payment> paymentMethods = new ArrayList<>();
            while (resultSet.next()){
                Payment payment = new Payment();
                payment.setId(resultSet.getInt(PaymentSQL.PARAM_ID));
                payment.setPayment(resultSet.getString(PaymentSQL.PARAM_PAYMENT));

                paymentMethods.add(payment);
            }
            return paymentMethods;
        }
    }
}
