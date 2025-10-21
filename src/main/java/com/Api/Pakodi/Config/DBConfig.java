package com.Api.Pakodi.Config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DBConfig {

    @Value("${spring.datasource.url}")
    protected String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String dbpassword;



    //Connection storing variable to Datatbase
    private Connection connection;

    private Statement statement;


    protected void connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, dbpassword);
            statement = connection.createStatement();

            System.out.println("Connceted");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //getter to get Database connection
    public Connection getConnect() throws SQLException {
        if (connection == null) {
            connect();
            return connection;
        } else {
            return connection;
        }
    }


    //getter to get Database statement
    public Statement getStatement() {
        return statement;
    }


}
