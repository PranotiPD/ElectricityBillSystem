package Electricity;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;

public class PayBill extends JFrame {
    Choice cmonth;
    String meter;

    PayBill(String meter) {
        this.meter = meter;
        setLayout(null);
        setBounds(300, 150, 900, 600);

        JLabel heading = new JLabel("Electricity Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(120, 5, 400, 30);
        add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(35, 80, 200, 20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(300, 80, 200, 20);
        add(meternumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 140, 200, 20);
        add(lblname);

        JLabel name = new JLabel("");
        name.setBounds(300, 140, 200, 20);
        add(name);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35, 200, 200, 20);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(300, 200, 200, 20);
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
        add(cmonth);

        JLabel lblunit = new JLabel("Units");
        lblunit.setBounds(35, 260, 200, 20);
        add(lblunit);

        JLabel units = new JLabel("");
        units.setBounds(300, 260, 200, 20);
        add(units);

        JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setBounds(35, 320, 200, 20);
        add(lbltotalbill);

        JLabel totalbill = new JLabel("");
        totalbill.setBounds(300, 320, 200, 20);
        add(totalbill);

        JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(35, 380, 200, 20);
        add(lblstatus);

        JLabel status = new JLabel("");
        status.setBounds(300, 380, 200, 20);
        status.setForeground(Color.RED);
        add(status);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where meter_no = '" + meter + "'");
            while (rs.next()) {
                meternumber.setText(meter);
                lblname.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' and month = '"
                    + cmonth.getSelectedItem() + "'");
            while (rs.next()) {
                lblunit.setText(rs.getString("units"));
                lbltotalbill.setText(rs.getString("totalbill"));
                lblstatus.setText(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // cmonth.addItemListener(new ItemListener());
        // @Override
        // public void itemStateChanged(ItenEvent ae){

        // } setVisible(true);
    }

    public static void main(String[] args) {
        new PayBill("");
    }
}
