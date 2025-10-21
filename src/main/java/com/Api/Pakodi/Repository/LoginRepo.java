package com.Api.Pakodi.Repository;


import com.Api.Pakodi.Config.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Component
public class LoginRepo{

    @Autowired
    DBConfig connect;
    LoginRepo(DBConfig connect) { this.connect = connect;}

     public HashMap<String, String> loginRepo(String email, String password) throws SQLException {

        // array which return back to front end as response
        HashMap<String, String> dictonary = new HashMap<>();
        dictonary.put("error", "False");

        try {

            // mysql query
            String query = "SELECT EmailId, UserName FROM USERSDATA WHERE password = ? and EmailId = ?";

            //Preparing Statement
            PreparedStatement statement = connect.getConnect().prepareStatement(query);


            //Sanitization and Cleaning Input Data
            password = password.trim().toLowerCase();
            email = email.trim().toLowerCase();


            statement.setString(1, password);
            statement.setString(2, email);


            try (ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();

                if (resultSet.getRow() > 0) {

                    dictonary.put("username", resultSet.getString("UserName"));
                    dictonary.put("gmailId", resultSet.getString("EmailId"));

                    return dictonary;
                } else {

                    dictonary.put("error", "True");
                    return dictonary;
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
            dictonary.put("error", "True");
            return dictonary;
        }
    }

}
