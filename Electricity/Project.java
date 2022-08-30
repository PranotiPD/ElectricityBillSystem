package Electricity;

import javax.swing.*;
import java.awt.event.ActionListener;
// import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    String atype;
    String meter;

    Project(String atype, String meter) {
        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);// full screen

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/project.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 980, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu master = new JMenu("Master");
        master.setFont(new Font("arial", Font.BOLD, 18));
        master.setForeground(Color.black);

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont((new Font("monospaced", Font.PLAIN, 14)));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/cust.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('D');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);

        JMenuItem custdeets = new JMenuItem("Customer Details");
        custdeets.setFont((new Font("monospaced", Font.PLAIN, 14)));
        custdeets.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/custdeets.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        custdeets.setIcon(new ImageIcon(image2));
        custdeets.setMnemonic('M');
        custdeets.addActionListener(this);
        custdeets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                ActionEvent.CTRL_MASK));
        master.add(custdeets);

        JMenuItem depositdeets = new JMenuItem("Deposit Details");
        depositdeets.setFont((new Font("monospaced", Font.PLAIN, 14)));
        depositdeets.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/depodeets.jpg"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdeets.setIcon(new ImageIcon(image3));
        depositdeets.setMnemonic('E');
        depositdeets.addActionListener(this);
        depositdeets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        master.add(depositdeets);

        JMenuItem calbill = new JMenuItem("Calculate Bill");
        calbill.setFont((new Font("monospaced", Font.PLAIN, 14)));
        calbill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icons/calc.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calbill.setIcon(new ImageIcon(image4));
        calbill.setMnemonic('C');
        calbill.addActionListener(this);
        calbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(calbill);

        JMenu info = new JMenu("Information");
        info.setForeground(Color.black);
        info.setFont(new Font("arial", Font.BOLD, 18));

        JMenuItem updatinfo = new JMenuItem("Update Information");
        updatinfo.setFont((new Font("monospaced", Font.PLAIN, 14)));
        updatinfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/updateinfo.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updatinfo.setIcon(new ImageIcon(image5));
        updatinfo.setMnemonic('U');
        updatinfo.addActionListener(this);
        updatinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(updatinfo);

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont((new Font("monospaced", Font.PLAIN, 14)));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image6));
        viewinfo.setMnemonic('V');
        viewinfo.addActionListener(this);
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        info.add(viewinfo);

        JMenu user = new JMenu("User");
        user.setForeground(Color.black);
        user.setFont(new Font("arial", Font.BOLD, 18));

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont((new Font("monospaced", Font.PLAIN, 14)));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icons/paybill.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('P');
        paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(paybill);

        JMenuItem billdeets = new JMenuItem("Bill Details");
        billdeets.setFont((new Font("monospaced", Font.PLAIN, 14)));
        billdeets.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icons/billdeets.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdeets.setIcon(new ImageIcon(image8));
        billdeets.setMnemonic('B');
        billdeets.addActionListener(this);
        billdeets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billdeets);

        JMenu report = new JMenu("Report");
        report.setForeground(Color.black);
        report.setFont(new Font("arial", Font.BOLD, 18));

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont((new Font("monospaced", Font.PLAIN, 14)));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icons/generatebill.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('G');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generatebill);

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        utility.setFont(new Font("arial", Font.BOLD, 18));

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont((new Font("monospaced", Font.PLAIN, 14)));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('N');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        JMenuItem Calculator = new JMenuItem("calculator");
        Calculator.setFont((new Font("monospaced", Font.PLAIN, 14)));
        Calculator.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icons/calc.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Calculator.setIcon(new ImageIcon(image11));
        Calculator.setMnemonic('L');
        Calculator.addActionListener(this);
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(Calculator);

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.black);
        exit.setFont(new Font("arial", Font.BOLD, 18));

        JMenuItem exitm = new JMenuItem("Exit");
        exitm.setFont((new Font("monospaced", Font.PLAIN, 14)));
        exitm.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icons/exit.jpg"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exitm.setIcon(new ImageIcon(image12));
        exitm.setMnemonic('X');
        exitm.addActionListener(this);
        exitm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        exit.add(exitm);

        if (atype.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(exit);
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void main(String[] args) {
        new Project("", "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String msg = e.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();
        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new Calbill();
        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);
        } else if (msg.equals("Update Information")) {
            new UpdateInfomation(meter);
        } else if (msg.equals("Bill details")) {
            new BillDetails(meter);
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception qe) {
                qe.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception pe) {
                pe.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meter);
        }

    }
}
