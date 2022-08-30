package Electricity;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener, FocusListener {
    JButton create, back;
    Choice accountType;
    JTextField txtmeter, txtuser, txtpass, txtname;

    Signup() {
        setBounds(450, 150, 700, 400);// used for frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        accountType.addFocusListener(this);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        txtmeter = new JTextField();
        txtmeter.setBounds(260, 90, 150, 20);
        txtmeter.setVisible(false);
        panel.add(txtmeter);

        JLabel username = new JLabel("Username");
        username.setBounds(100, 130, 150, 20);
        panel.add(username);

        txtuser = new JTextField();
        txtuser.setBounds(260, 130, 150, 20);
        panel.add(txtuser);

        JLabel name = new JLabel("Name");
        name.setBounds(100, 170, 150, 20);
        panel.add(name);

        txtname = new JTextField();
        txtname.setBounds(260, 170, 150, 20);
        panel.add(txtname);

        txtmeter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {

            }

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s
                            .executeQuery("Select * from login where meter_no = '" + txtmeter.getText() + "'");

                    while (rs.next()) {
                        txtname.setText(rs.getString(("name")));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JLabel password = new JLabel("Password");
        password.setBounds(100, 210, 150, 20);
        panel.add(password);

        txtpass = new JTextField();
        txtpass.setBounds(260, 210, 150, 20);
        panel.add(txtpass);

        accountType.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    txtmeter.setVisible(true);
                    txtname.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    txtmeter.setVisible(false);
                    txtname.setEditable(true);
                }

            }

        });

        create = new JButton("Create");
        create.setBounds(140, 250, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBounds(300, 250, 120, 25);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        } else if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = txtuser.getText();
            String sname = txtname.getText();
            String spass = txtpass.getText();
            String smeter = txtmeter.getText();

            try {
                Conn c = new Conn();

                String query = null;
                if (accountType.equals("Admin")) {
                    query = "Insert into login values('" + smeter + "', '" + susername + "','" + sname + "','"
                            + spass + "','" + atype + "')";
                } else {
                    query = "update login set username = '" + susername + "', password = '" + spass + "', user = '"
                            + atype + "' where meter_no = '" + smeter + "'";
                }
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub

    }
}
