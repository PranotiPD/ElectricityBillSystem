package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, cancel;
    JTextField username, pass;
    Choice loginas;

    Login() {
        super("Login Page");
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);

        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 60, 100, 20);
        add(password);

        pass = new JTextField();
        pass.setBounds(400, 60, 150, 20);
        add(pass);

        JLabel Loginas = new JLabel("Login as");
        Loginas.setBounds(300, 100, 100, 20);
        add(Loginas);

        loginas = new Choice();// awt
        loginas.add("Admin");
        loginas.add("Customer");
        loginas.setBounds(400, 100, 150, 20);
        add(loginas);

        setSize(640, 300);
        setLocation(400, 200);

        login = new JButton("Login");
        login.setBounds(330, 160, 100, 20);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener((java.awt.event.ActionListener) this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 160, 100, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        signup = new JButton("Sign up");
        signup.setBounds(380, 200, 100, 20);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel prof = new JLabel(i3);
        prof.setBounds(0, 0, 200, 200);
        add(prof);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String susername = username.getText();
            String spass = pass.getText();
            String user = loginas.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "Select * from login where username = '" + susername + "' and password = '" + spass
                        + "' and user = '" + user + "'";

                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user, meter);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    pass.setText("");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
