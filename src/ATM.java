import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
import java.util.Objects;
// import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class ATM implements Bank{
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel main;
    private JButton button1;

    static int totalBalance = 20000;
    static int amount;
    public static void main(String[] args) {
        ATM atm =new ATM();
        //atm.calculate();
        JFrame frame = new JFrame("ATM");
        frame.setContentPane(new ATM().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public ATM(){

        comboBox1.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            if (Objects.equals(comboBox1.getSelectedItem(), "Exit")) {
                System.exit(200);
            }
        });

        button1.addActionListener(e -> {
            try {
                comboBox1.addActionListener(button1.getAction());
                if (Objects.equals(comboBox1.getSelectedItem(), "Cash Withdrawal")) {
                    amount = Integer.parseInt(textField1.getText());
                    cashWithdrawal();
                } else if (Objects.equals(comboBox1.getSelectedItem(), "Deposit Cash")) {
                    amount = Integer.parseInt(textField1.getText());
                    deposit();
                } else if (Objects.equals(comboBox1.getSelectedItem(), "Check Balance")) {
                    checkBalance();
                }
            } catch (NullPointerException r){
                textField3.setText("Exception");
            }
        });
    }
    void cashWithdrawal() {
        if (amount < 0) {
            textField3.setText(" Invalid Amount, Amount should be greater then 0 ");
            return;
        }
        if (amount <= totalBalance) {
            textField3.setText("Transaction Successful");
            textField4.setText(" Thank u");
            totalBalance = totalBalance - amount;
            textField2.setText(String.valueOf(totalBalance));
        } else {
            textField3.setText(" Insufficient Balance");
            textField4.setText("Transaction Failure");
        }

    }

    public void checkBalance() {
        textField4.setText(String.valueOf(totalBalance));
        textField3.setText(" Your total balance:");
    }

    void deposit() {
        totalBalance = totalBalance + amount;
        textField2.setText(String.valueOf(totalBalance));
        textField3.setText("Deposited Successful");
        textField4.setText(" Thank u");
    }
}
