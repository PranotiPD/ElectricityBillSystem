package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionListener;

public class Calbill extends JFrame implements ActionListener {
    JTextField tfname, tfunits, tfstate, tfemail, tfmobno;
    JButton next, cancel;
    JLabel lblmeterval, tfadd;
    Choice meternum, cmonth;

    Calbill() {
        setSize(700, 500);
        setLocation(600, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Thoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblname = new JLabel("Meter Number");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);

        meternum = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while (rs.next()) {
                meternum.add(rs.getString("meter"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        meternum.setBounds(240, 80, 200, 20);
        p.add(meternum);

        JLabel lblmeter = new JLabel("Name ");
        lblmeter.setBounds(100, 120, 100, 20);
        p.add(lblmeter);

        lblmeterval = new JLabel();
        lblmeterval.setBounds(240, 120, 200, 20);
        p.add(lblmeterval);

        JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(100, 160, 100, 20);
        p.add(lbladd);

        tfadd = new JLabel();
        tfadd.setBounds(240, 160, 200, 20);
        p.add(tfadd);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s
                    .executeQuery("Select * from customer where meter_no = '" + meternum.getSelectedItem() + "'");
            while (rs.next()) {
                lblmeterval.setText(rs.getString("name"));
                tfadd.setText(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        meternum.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s
                            .executeQuery(
                                    "Select * from customer where meter_no = '" + meternum.getSelectedItem() + "'");
                    while (rs.next()) {
                        lblmeterval.setText(rs.getString("name"));
                        tfadd.setText(rs.getString("address"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        JLabel unit = new JLabel("Unit consumed");
        unit.setBounds(100, 200, 100, 20);
        p.add(unit);

        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);

        JLabel month = new JLabel("Month");
        month.setBounds(100, 240, 100, 20);
        p.add(month);

        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);

        next = new JButton("Submit");
        next.setBounds(120, 350, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("cancel");
        cancel.setBounds(250, 350, 100, 25);
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
            String meter = meternum.getSelectedItem();
            String units = tfunits.getText();
            String month = cmonth.getSelectedItem();

            int totalbill = 0;
            int units_consumed = Integer.parseInt(units);
            String query = "select * from tax";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()) {
                    totalbill += units_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String query2 = "insert into bill values('" + meter + "', '" + month + "','" + units + "','" + totalbill
                    + "', 'Not Paid')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer bill updated successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Calbill();
    }
}
