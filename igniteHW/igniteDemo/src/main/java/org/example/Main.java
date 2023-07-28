package org.example;

import org.apache.ignite.client.ClientConnectionException;

import java.sql.*;

public class Main {

    public static void main(String[] args){
        String jdbcURL = "jdbc:ignite:thin://127.0.0.1:32772/";

        try {
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
            Connection con = DriverManager.getConnection(jdbcURL);

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM SUBSCRIBER");

            while (rs.next()){
                int subscId = rs.getInt("SUBSC_ID");
                String subscName = rs.getString("SUBSC_NAME");
                String subscLName = rs.getString("SUBSC_SURNAME");
                String subscMSISDN = rs.getString("MSISDN");
                String subscDate = String.valueOf(rs.getDate("START_DATE"));

                System.out.println(subscId + " " + subscName + " " + subscLName +" " + subscMSISDN + " " + subscDate);
            }

        }catch(ClientConnectionException | ClassNotFoundException ce){
            System.out.println(ce.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}