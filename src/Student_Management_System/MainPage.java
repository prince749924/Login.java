package Student_Management_System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainPage implements ActionListener {
    Font fon1, fon2;
    JFrame fr;
    JPanel panel;
    JLabel lbl_heading, lbl_studentname, lbl_address, lbl_gender, lbl_class, lbl_section, lbl_subject, lbl_password, lbl_confirm, lbl_img,lbl_delname;
    JTextField txt_studentname, txt_address, txt_class, txt_subject, txt_section, txt_gender, txt_password, txt_confirm,txt_delname;
    JRadioButton rmale, rfemale;
    JButton btn_update,btn_delete;
    String studentname;
    ImageIcon background;

    public MainPage(String studentname) {
        fr = new JFrame("Main Page");
        this.studentname = studentname;
        fon1 = new Font("Times new roman", Font.BOLD, 40);
        fon2 = new Font("areal", Font.BOLD, 18);

        panel = new JPanel();
        panel.setBounds(0, 0, 815, 715);
        panel.setLayout(null);
        fr.add(panel);
        lbl_heading = new JLabel("Update your information here");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(120, 30, 600, 50);
        lbl_heading.setForeground(new Color(76, 80, 82));
        panel.add(lbl_heading);

        lbl_studentname = new JLabel("Student Name:");
        lbl_studentname.setFont(fon2);
        lbl_studentname.setBounds(50, 90, 300, 50);
        panel.add(lbl_studentname);


        lbl_address = new JLabel("Address:");
        lbl_address.setFont(fon2);
        lbl_address.setBounds(410, 90, 300, 50);
        panel.add(lbl_address);





        lbl_subject = new JLabel("Subject:");
        lbl_subject.setFont(fon2);
        lbl_subject.setBounds(410, 170, 300, 50);
        panel.add(lbl_subject);

        lbl_delname = new JLabel("Enter your name to delete:");
        lbl_delname.setFont(fon2);
        lbl_delname.setBounds(250, 350, 400, 50);
        panel.add(lbl_delname);

        txt_delname = new JTextField();
        txt_delname.setFont(fon2);
        txt_delname.setBounds(270, 400, 170, 35);
        txt_delname.setBackground(new Color(245, 254, 255));
        panel.add(txt_delname);

        btn_delete = new JButton("DELETE");
        btn_delete.setForeground(Color.white);
        btn_delete.setBackground(Color.red);
        btn_delete.setFont(fon2);
        btn_delete.setBounds(250, 450, 200, 50);
        btn_delete.addActionListener(this);
        panel.add(btn_delete);





        lbl_gender = new JLabel("Gender:");
        lbl_gender.setFont(fon2);
        lbl_gender.setBounds(410, 130, 300, 50);
        panel.add(lbl_gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(530, 135, 80, 30);
        rmale.setFont(fon2);
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(630, 135, 100, 30);
        rfemale.setFont(fon2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        panel.add(rmale);
        panel.add(rfemale);


        lbl_password = new JLabel("Password  :");
        lbl_password.setFont(fon2);
        lbl_password.setBounds(50, 210, 300, 50);
        panel.add(lbl_password);


        lbl_confirm = new JLabel("Confirm Password:");
        lbl_confirm.setFont(fon2);
        lbl_confirm.setBounds(390, 210, 300, 50);
        panel.add(lbl_confirm);


        Operations db = new Operations();
        String query = "select * from registration where studentname='" + studentname + "'";
        ResultSet rs = db.select(query);
        try {
            while (rs.next()) {
                txt_studentname = new JTextField(rs.getString("studentname"));
                txt_studentname.setFont(fon2);
                txt_studentname.setBackground(new Color(245, 254, 255));
                txt_studentname.setBounds(210, 95, 170, 35);
                panel.add(txt_studentname);

                txt_address = new JTextField(rs.getString("address"));
                txt_address.setFont(fon2);
                txt_address.setBounds(570, 95, 170, 35);
                txt_address.setBackground(new Color(245, 254, 255));
                panel.add(txt_address);

                String gender = rs.getString("gender");
                if (gender.length() == 4) {
                    System.out.println("male");
                    rmale.setSelected(true);
                } else {
                    rfemale.setSelected(true);
                    System.out.println("female");

                }
                txt_class = new JTextField(rs.getString("class"));
                txt_class.setFont(fon2);
                txt_class.setBounds(210, 135, 170, 35);
                txt_class.setBackground(new Color(245, 254, 255));
                panel.add(txt_class);


                txt_section = new JTextField(rs.getString("section"));
                txt_section.setFont(fon2);
                txt_section.setBounds(210, 175, 170, 35);
                txt_section.setBackground(new Color(245, 254, 255));
                panel.add(txt_section);

                txt_subject = new JTextField(rs.getString("subject"));
                txt_subject.setFont(fon2);
                txt_subject.setBounds(570, 175, 170, 35);
                txt_subject.setBackground(new Color(245, 254, 255));
                panel.add(txt_subject);


                txt_password = new JPasswordField(rs.getString("password"));
                txt_password.setFont(fon2);
                txt_password.setBounds(210, 215, 170, 35);
                txt_password.setBackground(new Color(245, 254, 255));
                panel.add(txt_password);

                txt_confirm = new JPasswordField(rs.getString("confirm"));
                txt_confirm.setFont(fon2);
                txt_confirm.setBounds(590, 215, 150, 35);
                txt_confirm.setBackground(new Color(245, 254, 255));
                panel.add(txt_confirm);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        btn_update = new JButton("UPDATE");
        btn_update.setForeground(Color.white);
        btn_update.setBackground(Color.green);
        btn_update.setFont(fon2);
        btn_update.setBounds(250, 280, 200, 50);
        btn_update.addActionListener(this);
        panel.add(btn_update);
        background = new ImageIcon(getClass().getResource("green.jpg"));
        lbl_img = new JLabel(background);
        lbl_img.setBounds(0, 0, 800, 680);
        panel.add(lbl_img);
        fr.setSize(815, 715);
        fr.setVisible(true);
        fr.setBackground(Color.YELLOW);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_delete){
            try {
                Operations db=new Operations();
                String sql = "DELETE FROM registration WHERE studentname='"+txt_delname.getText()+"'";
                int rowsDeleted = db.executeDelete(sql);
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(btn_delete, "Successfully deleted");
                    fr.dispose();
                    new Login();

                }
                else{
                    JOptionPane.showMessageDialog(btn_delete, "Name not found.");
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == btn_update) {
            String gender = "";
            if (rmale.isSelected()) {
                gender = rmale.getText();
            }
            if (rfemale.isSelected()) {
                gender = rfemale.getText();
            }
            ;
            try {
                String query = "update registration set studentname='" + txt_studentname.getText() + "',"
                        + "address='" + txt_address.getText() + "',gender='" + gender + "',class='" + txt_class.getText() + "',"
                        + "section='" + txt_section.getText() + "',subject='" + txt_subject.getText() + "'"
                        + ",confirm='"+txt_confirm.getText()+"',password='"+txt_password.getText()+"' where studentname='"+studentname+"'";
                Operations db = new Operations();
                int rs = db.Update(query);
                JOptionPane.showMessageDialog(btn_update, "Update successsful");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(btn_update, "Update unsuccesssful");
            }
        }
    }
}
