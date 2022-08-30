package Electricity;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    // Conn(){}

    Conn() throws SQLException {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "Oksmarty123");
        s = c.createStatement();
        // Class.forName("com.mysql.cj.jdbc.river");
    }

    public static void main(String[] args) {
        // try{
        // Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs",
        // "root", "Oksmarty123");
        // Statement s = c.createStatement();
        // Class.forName("com.mysql.cj.jdbc.river");
        // // ResultSet resultSet=statement.executeQuery(sql:"select*from people");
        // }catch(Exception e){
        // e.printStackTrace();

        // }
        // new Conn();
    }
}
