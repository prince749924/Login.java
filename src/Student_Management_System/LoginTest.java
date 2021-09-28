package Student_Management_System;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    @Test
    void insert_Test1() {
        Operations db = new Operations();
        String query = "insert into registration(studentname,address,gender,class,subject,password,confirm)values('" + "ram" + "','" + "ktm" + "','" + "male" + "','" + 10 + "','" + "science" + "','" + 123 + "','" + 123 + "')";
        int result = db.insert(query);
        assertEquals(1, result);
    }
    @Test
    void insert_Test2() {
        Operations db = new Operations();
        String query = "insert into registration(studentname,address,gender,class,subject,password,confirm)values('" +"sita" + "','" + "ktm" + "','" + "female" + "','" + 10 + "','" + "management" + "','" + 123 + "','" + 123 + "')";
        int result = db.insert(query);
        assertEquals(1, result);
    }
    @Test
    void select_Test1() throws SQLException {
        Operations db = new Operations();
        String studentname = "ram";
        String query = "select * from registration where studentname='" + studentname + "'";
        ResultSet rs = db.select(query);
        int count = rs.getRow();
        assertEquals(0, count);
    }
    @Test
    void select_Test2() throws SQLException {
        Operations db = new Operations();
        String studentname = "hari";
        String query = "select * from registration where studentname='" + studentname + "'";
        ResultSet rs = db.select(query);
        int count = rs.getRow();
        assertEquals(1, count);
    }
    @Test
    void update_Test() {
        String query = "update registration set studentname='" + 50 + "' where studentname='" + 50 + "'";
        Operations db = new Operations();
        int rs = db.Update(query);
        assertEquals(1, rs);
    }

}