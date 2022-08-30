package Electricity;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.ActionListener;

public class CustomerDetails extends JFrame implements ActionListener {

    JTable table;
    Choice x;
    JButton print;

    CustomerDetails() {
        super("Customer Details");
        setSize(1200, 650);
        setLocation(200, 150);

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        add(sp);

        print = new JButton("Print");
        print.addActionListener(this);
        add(print, "South");

        setVisible(true);

    }

    public static void main(String[] args) {
        new CustomerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            table.print();
        } catch (Exception p) {
            p.printStackTrace();
        }

    }

}
