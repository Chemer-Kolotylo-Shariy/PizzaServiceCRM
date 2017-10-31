package com.pizza.project.dao.impl.sql;

public final class ClientSQL {
    public static final String PARAM_TABLE = "client";
    public static final String PARAM_ID = "id";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_SURNAME = "surname";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_ID_ROLE = "id_role";
    public static final String PARAM_ROLE = "role";

    public static final String QUERY_GET_ALL_CLIENTS = "SELECT * FROM client c " +
            "INNER JOIN role r " +
            "ON c.id_role = r.id;";

    public static final String QUERY_GET_BY_ID = "SELECT c.id, name, surname, email, " +
            "phone, password, id_role, role, r.id " +
            "FROM client c " +
            "INNER JOIN role r " +
            "ON c.id_role = r.id " +
            "WHERE c.id = :id;";

    public static final String QUERY_GET_BY_PHONE = "SELECT c.id, name, surname, email, " +
            "phone, password, id_role, role, r.id " +
            "FROM client c " +
            "INNER JOIN role r " +
            "ON c.id_role = r.id " +
            "WHERE phone = :phone;";

    public static final String QUERY_DELETE_BY_ID = "DELETE FROM client WHERE id = :id";

}
