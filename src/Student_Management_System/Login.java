package Student_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class Login implements ActionListener{
    JFrame fr;
    JLabel lbl_heading,lbl_username,lbl_password,lbl_img;
    JTextField txt_studentname;
    JPasswordField txt_password;
    JButton btn_login,btn_reg;
    Font fon1,fon2;
    JPanel panel;
    ImageIcon image_bg;
    public Login(){
        fr=new JFrame("Login Page");
        fon1=new Font("Times new roman",Font.BOLD,40);
        fon2=new Font("Times new roman",Font.PLAIN,30);

        panel= new JPanel();
        panel.setBounds(0,0,1370,750);
        panel.setLayout(null);
        fr.add(panel);

        lbl_heading=new JLabel("LOGIN HERE");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(300,60,350,50);
        lbl_heading.setForeground(Color.white);
        panel.add(lbl_heading);

        lbl_username=new JLabel("User name :");
        lbl_username.setForeground(Color.white);
        lbl_username.setFont(fon2);
        lbl_username.setBounds(220,120,150,40);
        panel.add(lbl_username);

        txt_studentname=new JTextField();
        txt_studentname.setFont(fon2);
        txt_studentname.setBackground(Color.white);
        txt_studentname.setBounds(380,125,200,40);
        panel.add(txt_studentname);

        lbl_password=new JLabel("Password  :");
        lbl_password.setForeground(Color.white);
        lbl_password.setFont(fon2);
        lbl_password.setBounds(220,180,150,40);
        panel.add(lbl_password);

        txt_password=new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBackground(Color.white);
        txt_password.setBounds(380,185,200,40);
        panel.add(txt_password);

        btn_login=new JButton("LOGIN");
        btn_login.setFont(fon2);
        btn_login.setBackground(Color.green);
        btn_login.setForeground(Color.white);
        btn_login.addActionListener(this);
        btn_login.setBounds(350,250,150,40);

        panel.add(btn_login);

        btn_reg=new JButton("Register Here");
        btn_reg.setForeground(Color.white);
        btn_reg.setBackground(Color.green);
        btn_reg.setFont(fon2);
        btn_reg.setBounds(330,300,220,40);
        btn_reg.addActionListener(this);
        panel.add(btn_reg);

        image_bg=new ImageIcon(Objects.requireNonNull(getClass().getResource("registration_image.png")));
        lbl_img=new JLabel(image_bg);
        lbl_img.setBounds(0,0,800,680);
        panel.add(lbl_img);

        fr.setSize(815,715);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_reg) {
            fr.dispose();
            new Registration();
        }
        else if (e.getSource()==btn_login) {
            String studentname=txt_studentname.getText();
            String password=txt_password.getText();
            String query="select * from registration where studentname='"+studentname+"' and password='"+password+"'";
            Operations db=new Operations();
            ResultSet rs=db.select(query);
            try {
                if(rs.next()) {
                    String gender=rs.getString(4);
                    JOptionPane.showMessageDialog(btn_login, "Login successsful");
                    fr.dispose();
                    new MainPage(studentname);
                }
                else if(studentname.length()==0 && password.length()==0) {
                    JOptionPane.showMessageDialog(btn_login, "All filds mast be filled");
                }
                else {
                    JOptionPane.showMessageDialog(btn_login, "Your username and password do not match.");
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
