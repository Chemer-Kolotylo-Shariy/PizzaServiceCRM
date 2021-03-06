package com.pizza.project.dao.impl.sql;

public class ClientAddressSQL {
    public static final String PARAM_TABLE = "client_address";
    public static final String PARAM_ID_CLIENT = "id_client";
    public static final String PARAM_ID_ADDRESS = "id_address";

    public static final String QUERY_GET_ALL = "SELECT id_client, id_address " +
            "FROM client_address " +
            "ORDER BY id_client DESC; ";
    public static final String QUERY_DELETE_BY_ID_CLIENT = "DELETE FROM client_address WHERE id_client = :id_client;";



//    SELECT c.name, a.street
//    FROM address a
//    INNER JOIN client_address r
//    ON a.id = r.id_address
//    INNER JOIN client c
//    ON c.id = r.id_client;
}
