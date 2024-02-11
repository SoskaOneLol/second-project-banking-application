import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class ButtonClickListener implements ActionListener {
    static class UserInfo {
        protected static String passwordUser;
        protected static String phoneNumberUser;
        protected static String firstNameUser;
        protected static String lastNameUser;
        protected static String passwordUser1;
        protected static String phoneNumberUser1;
        protected static String sex;
        protected static String check = "";
        protected static String check1 = "";
        protected static int balanceUser = 0;


    }
    BankGUI bankGUI = new BankGUI();
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Font text = new Font("Monospaced", Font.BOLD, 20);
        UserInfo.firstNameUser = LogRegGUI.firstName.getText();
        UserInfo.lastNameUser = LogRegGUI.lastName.getText();
        UserInfo.phoneNumberUser1 = UserInfo.phoneNumberUser;
        UserInfo.passwordUser1 = UserInfo.passwordUser;
        UserInfo.phoneNumberUser = LogRegGUI.phoneNumber.getText();
        UserInfo.passwordUser = Arrays.toString(LogRegGUI.passwordField.getPassword());
        if(command.equals("Info")){
            JFrame info = new JFrame("UserInfo");
            JLabel firstName = new JLabel("First name: " + UserInfo.firstNameUser);
            JLabel lastName = new JLabel("Last name: " + UserInfo.lastNameUser);
            JLabel phoneNumber = new JLabel("Phone number: " + UserInfo.phoneNumberUser1);
            JLabel balance = new JLabel("Balance: "+ UserInfo.balanceUser);
            JLabel sex = new JLabel("Sex: "+ UserInfo.sex);
            info.setLayout(new GridLayout(5, 1));
            JLabel[] jLabel = {firstName,lastName,phoneNumber,sex,balance};
            for(JLabel jLabel1 : jLabel){
                info.add(jLabel1);
                jLabel1.setForeground(Color.BLACK);
                jLabel1.setFont(text);
                jLabel1.setSize(300, 50);
            }
            info.getContentPane().setBackground(new Color(64,64,64));
            info.setSize(450, 250);
            info.setLocationRelativeTo(null);
            info.setResizable(false);
            info.setIconImage(bankGUI.bankIcon.getImage());
            BankGUI.mainBank.setEnabled(false);
            info.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    BankGUI.mainBank.setEnabled(true);
                }
            });
            info.setVisible(true);
        }
        if (command.equals("Login")) {
            bankGUI.bankGUI();
            if(UserInfo.phoneNumberUser1.equals(LogRegGUI.phoneNumber.getText()) && UserInfo.check.equals("pass")){
                if(UserInfo.passwordUser1.equals(Arrays.toString(LogRegGUI.passwordField.getPassword())) && UserInfo.check1.equals("pass1"))
                {
                    System.out.println("Login success");
                    LogRegGUI.mainLogRegGUI.setVisible(false);
                }
                else{
                    LogRegGUI.error.setText("Invalid password");
                    LogRegGUI.error.setBounds(24, 300, 300, 60);
                    LogRegGUI.error.setVisible(true);
                }
            }
            else{
                LogRegGUI.error.setText("Invalid phone number");
                LogRegGUI.error.setBounds(24, 300, 300, 60);
                LogRegGUI.error.setVisible(true);
            }
        } else if (command.equals("Register")) {
            if(LogRegGUI.mSex.isSelected()){
                UserInfo.sex = "Male";
            }
            else if(LogRegGUI.fSex.isSelected()){
                UserInfo.sex = "Female";
            }
            if(!(UserInfo.firstNameUser.isEmpty())){
                if(!(UserInfo.lastNameUser.isEmpty())){
                    if(!(UserInfo.phoneNumberUser.length() < 12)){
                        UserInfo.check = "pass";
                        if(!(UserInfo.passwordUser.length() < 16)){
                            UserInfo.check1 = "pass1";
                            JFrame succs = new JFrame("Success");
                            JLabel succ = new JLabel("Success", JLabel.CENTER);
                            succs.add(succ);
                            succ.setFont(new Font("Monospaced", Font.BOLD, 20));
                            succ.setForeground(Color.BLACK);
                            succs.setSize(150, 90);
                            succs.getContentPane().setBackground(new Color(64,64,64));
                            succs.setLocationRelativeTo(null);
                            succs.setIconImage(bankGUI.bankIcon.getImage());
                            succs.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosing(WindowEvent e) {
                                    LogRegGUI.mainLogRegGUI.setVisible(false);
                                    FirstMenu.firstMenuGUI.setVisible(true);
                                }
                            });
                            LogRegGUI.mainLogRegGUI.setEnabled(false);
                            succs.setVisible(true);
                        } else{
                            LogRegGUI.error.setText("Your password is too short");
                            LogRegGUI.error.setBounds(39, 300, 300, 60);
                            LogRegGUI.error.setVisible(true);

                        }
                    }
                    else{
                        LogRegGUI.error.setText("Your phone number is too short");
                        LogRegGUI.error.setBounds(24, 300, 300, 60);
                        LogRegGUI.error.setVisible(true);

                    }
                }
                else{
                    LogRegGUI.error.setText("Your last name is empty");
                    LogRegGUI.error.setBounds(50, 300, 300, 60);
                    LogRegGUI.error.setVisible(true);
                }
            }
            else{
                LogRegGUI.error.setText("Your first name is empty");
                LogRegGUI.error.setVisible(true);
            }
        }
    }
}
