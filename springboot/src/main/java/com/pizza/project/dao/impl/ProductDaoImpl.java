package com.pizza.project.dao.impl;

import com.pizza.project.dao.CategoryDao;
import com.pizza.project.dao.ProductDao;
import com.pizza.project.dao.impl.sql.ProductSQL;
import com.pizza.project.model.Product;
import com.pizza.project.model.enums.Size;
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
public class ProductDaoImpl implements ProductDao{
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private ProductExtractor productExtractor;

    public ProductDaoImpl(DataSource dataSource, CategoryDao categoryDao) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(ProductSQL.PARAM_TABLE)
                .usingGeneratedKeyColumns(ProductSQL.PARAM_ID);
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        productExtractor = new ProductExtractor(categoryDao);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return null;
    }

    @Override
    public Product get(Long id) {
        if (id == null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(ProductSQL.PARAM_ID, id);
        return jdbcTemplate.query(ProductSQL.QUERY_GET_BY_ID, parameter, productExtractor).stream().findFirst().orElse(null);
    }

    @Override
    public Long create(Product object) {
        if (object.getId() != null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(ProductSQL.PARAM_NAME, object.getName())
                .addValue(ProductSQL.PARAM_SPECIFICATION, object.getSpecification())
                .addValue(ProductSQL.PARAM_AMOUNT, object.getAmount())
                .addValue(ProductSQL.PARAM_PHOTO, object.getPhoto())
                .addValue(ProductSQL.PARAM_PRICE, object.getPrice())
                .addValue(ProductSQL.PARAM_ID_CATEGORY, object.getCategory().getId())
                .addValue(ProductSQL.PARAM_ID_SIZE, object.getSize().getId());

        Long id = simpleJdbcInsert.executeAndReturnKey(parameter).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long update(Product object) {
        return null;
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    private class ProductExtractor implements ResultSetExtractor<List<Product>>{


        CategoryDao categoryDao;

        ProductExtractor(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        public List<Product> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Product> products = new ArrayList<>();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong(ProductSQL.PARAM_ID));
                product.setName(resultSet.getString(ProductSQL.PARAM_NAME));
                product.setSpecification(resultSet.getString(ProductSQL.PARAM_SPECIFICATION));
                product.setAmount(resultSet.getInt(ProductSQL.PARAM_AMOUNT));
                product.setPhoto(resultSet.getString(ProductSQL.PARAM_PHOTO));
                product.setPrice(resultSet.getDouble(ProductSQL.PARAM_PRICE));
                product.setPersent(resultSet.getInt(ProductSQL.PARAM_PERSENT));
                product.setCategory(categoryDao.getCategory(resultSet.getInt(ProductSQL.PARAM_ID_CATEGORY)));
                product.setSize(Size.valueOf(resultSet.getString(ProductSQL.PARAM_SIZE)));

                products.add(product);
            }
            return products;
        }
    }
}
