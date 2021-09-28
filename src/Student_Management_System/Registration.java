package Student_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Registration implements ActionListener {
    JFrame fr;
    JLabel lbl_heading, lbl_studentname, lbl_address, lbl_gender,lbl_class,lbl_section, lbl_subject, lbl_password, lbl_confirm, lbl_register_img;
    JTextField txt_studentname, txt_address, txt_class, txt_subject, txt_section;
    JPasswordField txt_password, txt_confirm;
    JButton btn_register, btn_login;
    JRadioButton rmale, rfemale;
    Font fon1, fon2;
    JPanel panel;
    ImageIcon reg_bg;

    public Registration() {
        fr = new JFrame("Registeration");
        fon1 = new Font("Times new roman", Font.BOLD, 40);
        fon2 = new Font("Times new roman", Font.BOLD, 25);

        panel = new JPanel();
        panel.setBounds(0, 0, 815, 715);
        panel.setLayout(null);
        fr.add(panel);

        lbl_heading = new JLabel("Student Registration");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(200, 50, 550, 50);
        lbl_heading.setForeground(new Color(248, 233, 0));
        panel.add(lbl_heading);


        lbl_studentname = new JLabel("Student Name:");
        lbl_studentname.setFont(fon2);
        lbl_studentname.setBounds(50, 90, 300, 50);
        panel.add(lbl_studentname);

        txt_studentname = new JTextField();
        txt_studentname.setFont(fon2);
        txt_studentname.setBackground(new Color(245, 254, 255));
        txt_studentname.setBounds(210, 95, 170, 35);
        panel.add(txt_studentname);

        lbl_address= new JLabel("Address:");
        lbl_address.setFont(fon2);
        lbl_address.setBounds(410, 90, 300, 50);
        panel.add(lbl_address);

        txt_address = new JTextField();
        txt_address.setFont(fon2);
        txt_address.setBounds(570, 95, 170, 35);
        txt_address.setBackground(new Color(245, 254, 255));
        panel.add(txt_address);

        lbl_class = new JLabel("Class:");
        lbl_class.setFont(fon2);
        lbl_class.setBounds(50, 130, 300, 50);
        panel.add(lbl_class);

        txt_class = new JTextField();
        txt_class.setFont(fon2);
        txt_class.setBounds(210, 135, 170, 35);
        txt_class.setBackground(new Color(245, 254, 255));
        panel.add(txt_class);

        lbl_section = new JLabel("Section:");
        lbl_section.setFont(fon2);
        lbl_section.setBounds(50, 170, 300, 50);
        panel.add(lbl_section);

        txt_section = new JTextField();
        txt_section.setFont(fon2);
        txt_section.setBounds(210, 175, 170, 35);
        txt_section.setBackground(new Color(245, 254, 255));
        panel.add(txt_section);

        lbl_subject = new JLabel("Subject:");
        lbl_subject.setFont(fon2);
        lbl_subject .setBounds(410, 170, 300, 50);
        panel.add(lbl_subject );

        txt_subject  = new JTextField();
        txt_subject .setFont(fon2);
        txt_subject .setBounds(570, 175, 170, 35);
        txt_subject .setBackground(new Color(245, 254, 255));
        panel.add(txt_subject);

        lbl_gender = new JLabel("Gender:");
        lbl_gender.setFont(fon2);
        lbl_gender.setBounds(410, 130, 300, 50);
        panel.add(lbl_gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(530, 135, 80, 30);
        rmale.setBackground(new Color(83, 121, 98));
        rmale.setFont(fon2);
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(630, 135, 100, 30);
        rfemale.setBackground(new Color(83, 121, 98));
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

        txt_password= new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBounds(210, 215, 170, 35);
        txt_password.setBackground(new Color(245, 254, 255));
        panel.add(txt_password);

        lbl_confirm = new JLabel("Confirm Password:");
        lbl_confirm.setFont(fon2);
        lbl_confirm.setBounds(390, 210, 300, 50);
        panel.add(lbl_confirm);

        txt_confirm = new JPasswordField();
        txt_confirm.setFont(fon2);
        txt_confirm.setBounds(590, 215, 150, 35);
        txt_confirm.setBackground(new Color(245, 254, 255));
        panel.add(txt_confirm);

        btn_register = new JButton("Register");
        btn_register.setFont(fon2);
        btn_register.setForeground(new Color(0, 73, 0));
        btn_register.setBackground(Color.white);
        btn_register.setBounds(220, 295, 200, 40);
        btn_register.addActionListener(this);
        panel.add(btn_register);

        btn_login = new JButton("LOGIN");
        btn_login.setBackground(new Color(165, 174, 213));
        btn_login.setFont(fon2);
        btn_login.setBounds(450, 295, 130, 40);
        btn_login.addActionListener(this);
        panel.add(btn_login);

        reg_bg = new ImageIcon(getClass().getResource("registration_image.png"));
        lbl_register_img = new JLabel(reg_bg);
        lbl_register_img.setBounds(0, 0, 800, 680);
        panel.add(lbl_register_img);

        fr.setSize(815,715);
        fr.setVisible(true);
        fr.setBackground(Color.YELLOW);
    }
    public static void main(String[] args) {
        new Registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_login) {
            fr.dispose();
            new Login();

        }
        else if (e.getSource()==btn_register) {

            String studentname=txt_studentname.getText();
            String address=txt_address.getText();
            String classes=txt_class.getText();
            String section=txt_section.getText();
            String subject=txt_subject.getText();
            String gender="";
            if (rmale.isSelected()) {
                gender=rmale.getText();
            }
            if(rfemale.isSelected()) {
                gender=rfemale.getText();
            }
            ;

            String password=txt_password.getText();
            String confirm=txt_confirm.getText();
            if (studentname.length()==0 ||address.length()==0 || classes.length()==0||section.length()==0 || subject.length()==0
                    || rmale.isSelected()==false && rfemale.isSelected()==false
                    || password.length()==0 ||confirm.length()==0)
            {
                JOptionPane.showMessageDialog(btn_register, "Enter all Fields completely");
            }
            else if(password.equals(confirm) != true) {
                JOptionPane.showMessageDialog(btn_register, "Your password and confirm password did not match.");
            }
            else  {
                Operations db=new Operations();
                String query="insert into registration(studentname,address,gender,class,section,subject,password,confirm)"
                        + " values('"+studentname+"','"+address+"','"+gender+"','"+classes+"','"+section+"','"+subject+"','"+password+"','"+confirm+"')";
                int ans= db.insert(query);
                if (ans>0) {
                    JOptionPane.showMessageDialog(btn_register, "User successfully registered");
                    txt_studentname.setText("");
                    txt_address.setText("");
                    txt_class.setText("");
                    txt_section.setText("");
                    txt_subject.setText("");
                    txt_password.setText("");
                    txt_confirm.setText("");
                    ButtonGroup bg=new ButtonGroup();
                    bg.add(rmale);
                    bg.add(rfemale);
                    panel.add(rmale);
                    panel.add(rfemale);
                    bg.clearSelection();
                }
            }
        }
    }
}

