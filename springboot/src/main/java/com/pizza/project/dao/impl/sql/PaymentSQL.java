package com.pizza.project.dao.impl.sql;

public class PaymentSQL {
    public static final String PARAM_TABLE = "payment";
    public static final String PARAM_ID = "id";
    public static final String PARAM_PAYMENT = "payment";

    public static final String QUERY_GET_ALL = "SELECT * FROM payment;";
    public static final String QUERY_GET_BY_ID = "SELECT * FROM payment WHERE id = :id;";
    public static final String QUERY_DELETE_BY_ID = "DELETE FROM payment WHERE id = :id;";

}
