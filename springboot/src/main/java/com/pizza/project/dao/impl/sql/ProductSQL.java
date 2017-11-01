package com.pizza.project.dao.impl.sql;

public class ProductSQL {
    public static final String PARAM_TABLE = "product";
    public static final String PARAM_ID = "id";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_SPECIFICATION = "specification";
    public static final String PARAM_AMOUNT = "amount";
    public static final String PARAM_PHOTO = "foto";
    public static final String PARAM_PRICE = "price";
    public static final String PARAM_PERSENT = "persent";
    public static final String PARAM_ID_CATEGORY = "id_category";
    public static final String PARAM_ID_SIZE = "id_size";
    public static final String PARAM_SIZE = "size";

    public static final String QUERY_GET_ALL_BY_CATEGORY = "SELECT * FROM product " +
                                        "WHERE id_category = :id_category;";

    public static final String QUERY_GET_BY_ID = "SELECT * FROM product p " +
            "INNER JOIN size s " +
            "ON p.id_size = s.id " +
            "INNER JOIN category c " +
            "ON p.id_category = c.id " +
            "WHERE p.id = :id;";

    public static final String QUERY_GET_ALL = "SELECT * FROM product;";
}
