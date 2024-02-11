import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoneyActions implements ActionListener {
    private JButton submitDeposit;
    private JButton submitWithdraw;
    private static JTextField depositSum;
    private static JTextField withdrawSum;
    protected static JFrame withdraw;
    protected static JFrame deposit;

    private void withdrawAction(){
        withdraw = new JFrame("Withdraw");
        submitWithdraw = new JButton("Submit Withdraw");
        Font text = new Font("Monospaced", Font.BOLD, 20);
        withdrawSum = new JTextField(10);
        withdrawSum.setFont(text);
        withdrawSum.setBounds(0,1,334,30);
        submitWithdraw.setBounds(0,60,334,30);
        withdrawSum.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)){
                    evt.consume();
                }
            }
        });
        submitWithdraw.setBackground(Color.WHITE);
        submitWithdraw.setForeground(Color.BLACK);
        submitWithdraw.setFont(text);
        submitWithdraw.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        submitWithdraw.addActionListener(new MoneyActions());
        withdraw.setLocationRelativeTo(null);
        withdraw.setIconImage(BankGUI.mainBank.getIconImage());
        withdraw.setLayout(null);
        withdraw.getContentPane().setBackground(new Color(64,64,64));
        withdraw.setSize(350, 130);
        withdraw.setResizable(false);
        withdraw.add(withdrawSum);
        withdraw.add(submitWithdraw);
        withdraw.add(LogRegGUI.error);
        withdraw.setVisible(true);
    }
    private void depositAction(){
        Font text = new Font("Monospaced", Font.BOLD, 20);
        deposit = new JFrame("Deposit");
        submitDeposit = new JButton("Submit Deposit");
        depositSum = new JTextField(10);
        depositSum.setFont(text);
        depositSum.setBounds(0,1,334,30);
        submitDeposit.setBounds(0,30,334,30);
        submitDeposit.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        depositSum.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)){
                    evt.consume();
                }
            }
        });
        submitDeposit.setBackground(Color.WHITE);
        submitDeposit.setForeground(Color.BLACK);
        submitDeposit.setFont(text);
        submitDeposit.addActionListener(new MoneyActions());
        deposit.setLocationRelativeTo(null);
        deposit.setIconImage(BankGUI.mainBank.getIconImage());
        deposit.setLayout(null);
        deposit.getContentPane().setBackground(new Color(64,64,64));
        deposit.setSize(350, 100);
        deposit.setResizable(false);
        deposit.add(depositSum);
        deposit.add(submitDeposit);
        deposit.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Withdraw")){
            BankGUI.mainBank.setEnabled(false);
            withdrawAction();
            withdraw.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    BankGUI.mainBank.setEnabled(true);
                }
            });
        }
        if(command.equals("Submit Withdraw")){
            if(!(ButtonClickListener.UserInfo.balanceUser < Integer.parseInt(withdrawSum.getText()))){
                ButtonClickListener.UserInfo.balanceUser -= Integer.parseInt(withdrawSum.getText());
                BankGUI.balance.setText("Your balance is: " + ButtonClickListener.UserInfo.balanceUser);
                withdraw.setVisible(false);
                BankGUI.mainBank.setEnabled(true);
            }
            else{
                LogRegGUI.error.setBounds(2,35, 350, 20);
                LogRegGUI.error.setText("Amount to withdraw is bigger than balance");
                LogRegGUI.error.setVisible(true);
            }
        }
        if(command.equals("Deposit")){
            BankGUI.mainBank.setEnabled(false);
            depositAction();
            deposit.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    BankGUI.mainBank.setEnabled(true);
                }
            });
        }
        if(command.equals("Submit Deposit")){
            ButtonClickListener.UserInfo.balanceUser += Integer.parseInt(depositSum.getText());
            BankGUI.balance.setText("Your balance is: " + ButtonClickListener.UserInfo.balanceUser);
            deposit.setVisible(false);
            BankGUI.mainBank.setEnabled(true);
        }
    }
}
