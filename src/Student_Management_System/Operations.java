package Student_Management_System;

import java.sql.*;

public class Operations {
    Connection con;
    Statement st;
    int val;
    ResultSet rows;
    int valuess;
    int values;
    public Operations() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagement","root","9869");
            if (con!=null) {
                System.out.println("connected");
                st=con.createStatement();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public int insert(String query) {
        try {

            val=st.executeUpdate(query);
        }catch(SQLException throwables){
            throwables.printStackTrace();

        }
        return val;
    }
    public ResultSet select(String query) {
        try {
            rows =st.executeQuery(query);
        }
        catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;

    }
    public  int Update(String query) {
        try {
            values=st.executeUpdate(query);
        }
        catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return values;
    }

    public int executeDelete(String sql) {
        try {
            values=st.executeUpdate(sql);
        }
        catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return values;
    }
    public static void main(String[]args) {
        new Operations();
    }
}