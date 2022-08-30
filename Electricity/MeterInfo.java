package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {
    JButton next;
    Choice meterloc, metertype, phasecode, billtype;
    String meterno;

    MeterInfo(String meterno) {
        this.meterno = meterno;
        setSize(700, 500);
        setLocation(600, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("meter Information");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblmeter = new JLabel("meter Number");
        lblmeter.setBounds(100, 80, 100, 20);
        p.add(lblmeter);

        JLabel lblmeterno = new JLabel(meterno);
        lblmeterno.setBounds(240, 80, 100, 20);
        p.add(lblmeterno);

        JLabel lblloc = new JLabel("Meter Location");
        lblloc.setBounds(100, 120, 100, 20);
        p.add(lblloc);

        meterloc = new Choice();
        meterloc.add("Outside");
        meterloc.add("Insideside");
        meterloc.setBounds(240, 120, 200, 20);
        p.add(meterloc);

        JLabel lblmtype = new JLabel("Meter Type");
        lblmtype.setBounds(100, 160, 100, 20);
        p.add(lblmtype);

        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240, 160, 200, 20);
        p.add(metertype);

        JLabel lblcode = new JLabel("Phase Code");
        lblcode.setBounds(100, 200, 100, 20);
        p.add(lblcode);

        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(240, 200, 200, 20);
        p.add(phasecode);

        JLabel lblbbtype = new JLabel("Bill Type");
        lblbbtype.setBounds(100, 240, 100, 20);
        p.add(lblbbtype);

        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(240, 240, 200, 20);
        p.add(billtype);

        JLabel lbldays = new JLabel("Days");
        lbldays.setBounds(100, 280, 100, 20);
        p.add(lbldays);

        JLabel lblemail1 = new JLabel("30 days");
        lblemail1.setBounds(240, 280, 100, 20);
        p.add(lblemail1);

        JLabel lblnote = new JLabel("Note");
        lblnote.setBounds(100, 320, 100, 20);
        p.add(lblnote);

        JLabel lblnotetext = new JLabel("By default bill is calculated for 30 days only");
        lblnotetext.setBounds(240, 320, 500, 20);
        p.add(lblnotetext);

        next = new JButton("Submit");
        next.setBounds(220, 390, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener((ActionListener) this);
        p.add(next);

        setLayout(new BorderLayout());
        add(p, "Center");

        // ImageIcon i1 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/newcust.png"));
        // Image i2 = i1.getImage().getScaledInstance(170, 300, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel image = new JLabel(i3);
        // add(image, "West");

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meterno;
            String meterloc1 = meterloc.getSelectedItem();
            String type = metertype.getSelectedItem();
            String pcode = phasecode.getSelectedItem();
            String btype = billtype.getSelectedItem();
            String days = "30";

            String query1 = "insert into meter_info values('" + meter + "','" + meterloc1 + "','" + type +
                    "','" + pcode + "','" + btype + "','" + days + "')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Meter Information added successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MeterInfo("");
    }
}
