package Electricity;

import javax.swing.JButton;

// import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.*;
import java.awt.*;

public class GenerateBill extends JFrame implements ActionListener {
    String meter;
    JButton bill;
    JTextArea area;
    Choice cmonth;

    GenerateBill(String meter) {
        this.meter = meter;
        setSize(500, 700);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel(meter);
        cmonth = new Choice();

        cmonth.setBounds(520, 20, 150, 20);
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

        area = new JTextArea(50, 15);
        area.setText("\n\n\t------Click on the------\n\t generate bill button to get \n\t bill of selected month ");
        area.setFont(new Font("San Sarif", Font.ITALIC, 18));

        JScrollPane pane = new JScrollPane(area);

        bill = new JButton("Generate Bill");

        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);

        add(panel, "North");

        add(pane, "Center");
        add(bill, "South");
        setVisible(true);

    }

    public static void main(String[] args) {
        new GenerateBill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            Conn c = new Conn();

            String month = cmonth.getSelectedItem();

            area.setText("\t Realiance Power Limited\n ElECTRICITY BILL GENERERATED FOR MONTH\n OF '");
            //
        } catch (Exception ae) {
            ae.printStackTrace();
        }

    }
}
