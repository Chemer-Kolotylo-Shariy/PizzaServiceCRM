package com.pizza.project.dao.impl;

import com.pizza.project.dao.AddressDao;
import com.pizza.project.dao.ClientDao;
import com.pizza.project.dao.OrderDao;
import com.pizza.project.dao.PaymentDao;
import com.pizza.project.dao.impl.sql.OrderSQL;
import com.pizza.project.model.Order;
import com.pizza.project.model.enums.Delivery;
import com.pizza.project.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderDaoImpl implements OrderDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private OrderExtractor orderExtractor;

    public OrderDaoImpl(DataSource dataSource, PaymentDao paymentDao, ClientDao clientDao, AddressDao addressDao) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        orderExtractor = new OrderExtractor(paymentDao, clientDao, addressDao);
    }

    @Override
    public Order get(Long id) {
        if(id == null){
           return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderSQL.PARAM_ID, id);
        return jdbcTemplate.query(OrderSQL.QUERY_GET_BY_ID, parameter, orderExtractor).stream().findFirst().orElse(null);
    }

    @Override
    public Long create(Order object) {
        if (object.getId() != null){
            return  null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderSQL.PARAM_PRICE, object.getPrice())
                .addValue(OrderSQL.PARAM_ID_ORDER_STATUS, object.getOrderStatus().getId())
                .addValue(OrderSQL.PARAM_ID_PAYMENT, object.getPayment().getId())
                .addValue(OrderSQL.PARAM_ID_DELIVERY, object.getDelivery())
                .addValue(OrderSQL.PARAM_ID_CLIENT, object.getClient().getId())
                .addValue(OrderSQL.PARAM_ID_ADDRESS, object.getAddress().getId())
                .addValue(OrderSQL.PARAM_DATE, object.getDate())
                .addValue(OrderSQL.PARAM_TIME, object.getTime());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(OrderSQL.QUERY_INSERT_INTO, parameter, keyHolder, new String[]{"id"});
        return keyHolder.getKey().longValue();
    }

    @Override
    public Long update(Order object) {
        return null;
    }

    @Override
    public Long remove(Long id) { return null; }

    private Long remove(Long id, String sql) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderSQL.PARAM_ID, id);
        int rows = jdbcTemplate.update(sql, parameter);
        if(rows > 0){
            return id;
        }
        return null;
    }

    @Override
    public Long removeByIdAndStatusClient(Long id) {
        return remove(id, OrderSQL.QUERY_DELETE_BY_ID_AND_STATUS_CLIENT);
    }

    @Override
    public Long removeByIdAndStatusADMIN(Long id) {
        return remove(id, OrderSQL.QUERY_DELETE_BY_ID_AND_STATUS_ADMIN);
    }

    @Override
    public Long changeStatus(Integer id, Integer status) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderSQL.PARAM_ID, id)
                .addValue(OrderSQL.PARAM_ID_ORDER_STATUS, status);
        return (long) jdbcTemplate.update(OrderSQL.QUERY_UPDATE_BY_ID, parameter);
    }

    @Override
    public List<Order> getByStatus(String status) {
        SqlParameterSource parameter = new MapSqlParameterSource(OrderSQL.PARAM_ORDER_STATUS, status);
        return jdbcTemplate.query(OrderSQL.QUERY_GET_ALL_BY_STATUS, parameter, orderExtractor
        );
    }

    private class OrderExtractor implements ResultSetExtractor<List<Order>>{
        private PaymentDao paymentDao;
        private ClientDao clientDao;
        private AddressDao addressDao;

        @Autowired
        OrderExtractor(PaymentDao paymentDao, ClientDao clientDao, AddressDao addressDao) {
            this.paymentDao = paymentDao;
            this.clientDao = clientDao;
            this.addressDao = addressDao;
        }

        @Override
        public List<Order> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getLong(OrderSQL.PARAM_ID));
                order.setPrice(resultSet.getDouble(OrderSQL.PARAM_PRICE));
                order.setOrderStatus(OrderStatus.valueOf(resultSet.getString(OrderSQL.PARAM_ORDER_STATUS)));
                order.setPayment(paymentDao.get(resultSet.getInt(OrderSQL.PARAM_ID_PAYMENT)));
                order.setDelivery(resultSet.getInt(OrderSQL.PARAM_ID_DELIVERY));
                order.setClient(clientDao.get(resultSet.getLong(OrderSQL.PARAM_ID_CLIENT)));
                order.setAddress(addressDao.get(resultSet.getLong(OrderSQL.PARAM_ID_ADDRESS)));
                order.setDate(resultSet.getString(OrderSQL.PARAM_DATE));
                order.setTime(resultSet.getString(OrderSQL.PARAM_TIME));
                order.setDelivery_str(resultSet.getString(OrderSQL.PARAM_DELIVERY));

                orders.add(order);
            }
            return orders;
        }
    }
}
