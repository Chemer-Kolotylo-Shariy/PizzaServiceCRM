package com.pizza.project.dao.impl.sql;

public class BankCardSQL {
    public static final String PARAM_TABLE = "bank_card";
    public static final String PARAM_ID = "id";
    public static final String PARAM_NUMBER = "number";
    public static final String PARAM_DATE = "date";
    public static final String PARAM_SECRET_CODE = "secret_code";
    public static final String PARAM_ID_CLIENT = "id_client";

    public static final String QUERY_GET_ALL = "SELECT * FROM bank_card;";

    public static final String QUERY_DELETE = "DELETE FROM bank_card WHERE id = :id;";

    public static final String QUERY_GET_BY_ID_CLIENT = "SELECT * FROM bank_card WHERE id_client = :id_client;";
}
