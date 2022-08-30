package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionListener;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfadd, tfcity, tfstate, tfemail, tfmobno;
    JButton next, cancel;
    JLabel lblmeterval;

    NewCustomer() {
        setSize(700, 500);
        setLocation(600, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(240, 80, 200, 20);
        p.add(tfname);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 120, 100, 20);
        p.add(lblmeter);

        lblmeterval = new JLabel();
        lblmeterval.setBounds(240, 120, 200, 20);
        p.add(lblmeterval);

        Random num = new Random();
        long number = num.nextLong() % 1000000;
        lblmeterval.setText("" + Math.abs(number));
        p.add(lblmeterval);

        JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(100, 160, 100, 20);
        p.add(lbladd);

        tfadd = new JTextField();
        tfadd.setBounds(240, 160, 200, 20);
        p.add(tfadd);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(240, 200, 200, 20);
        p.add(tfcity);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(240, 240, 200, 20);
        p.add(tfstate);

        JLabel lblemail = new JLabel("Email Address");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(240, 280, 200, 20);
        p.add(tfemail);

        JLabel lblmobno = new JLabel("Mobile Number");
        lblmobno.setBounds(100, 320, 100, 20);
        p.add(lblmobno);

        tfmobno = new JTextField();
        tfmobno.setBounds(240, 320, 200, 20);
        p.add(tfmobno);

        next = new JButton("next");
        next.setBounds(120, 390, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("cancel");
        cancel.setBounds(250, 390, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcust.png"));
        Image ii2 = ii1.getImage().getScaledInstance(170, 280, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image = new JLabel(ii3);
        add(image, "West");

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String name = tfname.getText();
            String meter = lblmeterval.getText();
            String add = tfadd.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String mail = tfemail.getText();
            String mobno = tfmobno.getText();

            String query1 = "insert into customer values('" + name + "','" + meter + "','" + add + "','" + city + "','"
                    + state + "','" + mail + "','" + mobno + "')";
            String query2 = "insert into login values('" + meter + "','', '" + name + "','','')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Detail Added Successfully");
                setVisible(false);

                new MeterInfo(meter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
