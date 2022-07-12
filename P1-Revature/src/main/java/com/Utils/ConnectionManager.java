package com.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {




    public static ConnectionManager connectionManager;
    // this is our Connection instance

    public static Connection connection;



    private ConnectionManager() {


    }

    private ConnectionManager getConnectionManager() {

        if (connectionManager == null) {
            connectionManager = new ConnectionManager();

        }
        return connectionManager;


    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = connect();
        }

        return connection;
    }

    public static Connection connect() {
        try {
            Properties props = new Properties();

            FileReader fileReader = new FileReader("/Users/jorda/Documents/P1-Revature" + "/src/main/resources/jdbc.properties");

            props.load(fileReader);

            StringBuilder sb = new StringBuilder();

            sb.append("jdbc:postgresql://");
            sb.append(props.get("hostname"));
            sb.append(":");
            sb.append(props.get("port"));
            sb.append("/");
            sb.append(props.get("database"));

            String connectionURL = sb.toString();
            String user = String.valueOf(props.get("user"));
            String password = String.valueOf(props.get("password"));
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL, user, password);


            System.out.println(connectionURL);

        } catch ( Exception e) {

            System.out.println(e.getMessage());
            System.out.println("this is the connection manager class");

        }

        return connection;
    }

        public static void main(String [] args){
            try {
                Connection connection = ConnectionManager.connect();
                System.out.println(connection.getSchema());
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }

        }


}
