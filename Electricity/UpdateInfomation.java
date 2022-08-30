package Electricity;

import javax.swing.*;

// import javafx.scene.image.Image;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateInfomation extends JFrame implements ActionListener {
    JButton update, cancel;
    String meter;
    JTextField txtadd, txtcity, txtstate, txtmail, txtmob;

    UpdateInfomation(String meter) {
        this.meter = meter;
        setBounds(300, 200, 1000, 480);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Information");
        heading.setBounds(100, 0, 400, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 70, 100, 20);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        JLabel name = new JLabel("");
        name.setBounds(150, 70, 100, 20);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);

        JLabel lblmeterno = new JLabel("Meter No");
        lblmeterno.setBounds(30, 110, 100, 20);
        lblmeterno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblmeterno);

        JLabel meterno = new JLabel();
        meterno.setBounds(150, 110, 100, 20);
        meterno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(meterno);

        JLabel add = new JLabel("Address");
        add.setBounds(30, 150, 100, 20);
        add.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(add);

        txtadd = new JTextField();
        txtadd.setBounds(150, 150, 200, 20);
        add(txtadd);

        JLabel city = new JLabel("city");
        city.setBounds(30, 190, 100, 20);
        city.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(city);

        txtcity = new JTextField();
        txtcity.setBounds(150, 190, 200, 20);
        add(txtcity);

        JLabel state = new JLabel("state");
        state.setBounds(30, 230, 100, 20);
        state.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(state);

        txtstate = new JTextField();
        txtstate.setBounds(150, 230, 200, 20);
        add(txtstate);

        JLabel email = new JLabel("Email");
        email.setBounds(30, 270, 100, 20);
        email.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(email);

        txtmail = new JTextField();
        txtmail.setBounds(150, 270, 200, 20);
        add(txtmail);

        JLabel mobno = new JLabel("Mobile No");
        mobno.setBounds(30, 310, 100, 20);
        mobno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(mobno);

        txtmob = new JTextField();
        txtmob.setBounds(150, 310, 200, 20);
        add(txtmob);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where meter = '" + meter + "'");
            while (rs.next()) {
                name.setText(rs.getString("name"));
                txtadd.setText(rs.getString("address"));
                txtcity.setText(rs.getString("city"));
                txtmail.setText(rs.getString("email"));
                txtmob.setText(rs.getString("mob"));
                txtstate.setText(rs.getString("state"));
                meterno.setText(rs.getString("meter"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setBounds(70, 370, 100, 25);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setBounds(200, 370, 100, 25);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updatecustinfo.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520, 50, 400, 300);
        add(image);
        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateInfomation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String address = txtadd.getText();
            String city = txtcity.getText();
            String state = txtstate.getText();
            String mob = txtmob.getText();
            String email = txtmail.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate(
                        "Update customer set address = '" + address + "' city = '" + city + "', state = '" + state
                                + "', mob = '" + mob + "', email = '" + email + "' where meter = '" + meter + "'");

                JOptionPane.showMessageDialog(null, "User information updated successfully");
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();

            }
        } else {
            setVisible(false);
        }
    }
}
