package com.pizza.project.dao.impl;

import com.pizza.project.dao.CategoryDao;
import com.pizza.project.dao.impl.sql.CategorySQL;
import com.pizza.project.model.Category;
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
public class CategoryDaoImpl implements CategoryDao {

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private CategoryExtractor categoryExtractor;

    public CategoryDaoImpl(DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(CategorySQL.PARAM_TABLE)
                .usingGeneratedKeyColumns(CategorySQL.PARAM_ID);
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        categoryExtractor = new CategoryExtractor();
    }

    @Override
    public Category get(Long id) {
        return null;
    }

    @Override
    public Long create(Category object) {
        return null;
    }

    @Override
    public Long update(Category object) {
        return null;
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(CategorySQL.QUERY_GET_ALL_CATEGORY, categoryExtractor);
    }

    @Override
    public Integer createCategory(Category object) {
        if (object.getId() != null){
            return null;
        }
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue(CategorySQL.PARAM_CATEGORY, object.getCategory());
        Integer id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        object.setId(id);
        return id;
    }

    @Override
    public Category getCategory(Integer id) {
        if (id == null){
            return null;
        }
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(CategorySQL.PARAM_ID, id);
        return jdbcTemplate.query(CategorySQL.QUERY_GET_BY_ID, parameter, categoryExtractor).stream().findFirst().orElse(null);
    }

    private class CategoryExtractor implements ResultSetExtractor<List<Category>> {

        @Override
        public List<Category> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Category>categories = new ArrayList<>();
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt(CategorySQL.PARAM_ID));
                category.setCategory(resultSet.getString(CategorySQL.PARAM_CATEGORY));

                categories.add(category);
            }
            return categories;
        }
    }
}
