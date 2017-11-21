package com.pizza.project.dao.impl;

import com.pizza.project.dao.OrderDao;
import com.pizza.project.dao.OrderProductDao;
import com.pizza.project.dao.ProductDao;
import com.pizza.project.dao.impl.sql.OrderProductSQL;
import com.pizza.project.model.OrderProduct;
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
public class OrderProductDaoImpl implements OrderProductDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;
    private OrderProductExtractor orderProductExtractor;

    @Autowired
    public OrderProductDaoImpl(DataSource dataSource, OrderDao orderDao, ProductDao productDao) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(OrderProductSQL.PARAM_TABLE);
        orderProductExtractor = new OrderProductExtractor(orderDao, productDao);
    }

    @Override
    public OrderProduct get(Long id) {
        return null;
    }

    @Override
    public Long create(OrderProduct object) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderProductSQL.PARAM_ID_ORDER, object.getOrder().getId())
                .addValue(OrderProductSQL.PARAM_ID_PRODUCT, object.getProduct().getId())
                .addValue(OrderProductSQL.PARAM_COUNT_PRODUCT, object.getCountProduct());
        return simpleJdbcInsert.executeAndReturnKey(parameter).longValue();
    }

    @Override
    public Long update(OrderProduct object) { return null; }

    @Override
    public Long remove(Long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderProductSQL.PARAM_ID_ORDER, id);
        int row = jdbcTemplate.update(OrderProductSQL.QUERY_DELETE_BY_ORDER_ID, parameter);

        if (row > 0){
            return id;
        }
        return id;
    }

    @Override
    public List<OrderProduct> getAllByOrderId(Long idOrder) {
        if (idOrder == null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderProductSQL.PARAM_ID_ORDER, idOrder);
        return jdbcTemplate.query(OrderProductSQL.QUERY_GET_ALL_BY_ID_ORDER, parameter, orderProductExtractor);
    }

    @Override
    public OrderProduct getOrderProduct(Long idOrder, Long idProduct) {
        if (idOrder == null || idProduct == null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(OrderProductSQL.PARAM_ID_ORDER, idOrder)
                .addValue(OrderProductSQL.PARAM_ID_PRODUCT, idProduct);
        return jdbcTemplate.query(OrderProductSQL.QUERY_BY_ID_ORDER_AND_ID_PRODUCT, parameter, orderProductExtractor).stream().findFirst().orElse(null);
    }

    private class OrderProductExtractor implements ResultSetExtractor<List<OrderProduct>>{

        private OrderDao orderDao;
        private ProductDao productDao;

        @Autowired
        public OrderProductExtractor(OrderDao orderDao, ProductDao productDao) {
            this.orderDao = orderDao;
            this.productDao = productDao;
        }

        @Override
        public List<OrderProduct> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<OrderProduct> orderProducts = new ArrayList<>();
            while (resultSet.next()){
                OrderProduct orderProduct = new OrderProduct();

                orderProduct.setOrder(orderDao.get(resultSet.getLong(OrderProductSQL.PARAM_ID_ORDER)));
                orderProduct.setProduct(productDao.get(resultSet.getLong(OrderProductSQL.PARAM_ID_PRODUCT)));
                orderProduct.setCountProduct(resultSet.getInt(OrderProductSQL.PARAM_COUNT_PRODUCT));

                orderProducts.add(orderProduct);
            }
            return orderProducts;
        }
    }
}
