package Electricity;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.*;
// import javax.swing.plaf.ColorUIResource;

// import javafx.scene.paint.Color;

// import javafx.scene.paint.Color;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {
    String meter;

    BillDetails(String meter) {
        this.meter = meter;
        setSize(700, 650);
        setLocation(400, 150);

        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();

        try {
            Conn c = new Conn();
            String query = "Select * from bill where meter_no = '" + meter + "'";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}
