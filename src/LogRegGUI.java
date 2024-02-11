import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogRegGUI extends FirstMenu{
    public static JFrame mainLogRegGUI;
    private JPanel regFields;
    private JPanel radButtons;
    protected static JTextField firstName;
    protected static JTextField lastName;
    public static JTextField phoneNumber;
    public static JPasswordField passwordField;
    public static ButtonGroup radioGroup = new ButtonGroup();
    public static JRadioButton mSex = new JRadioButton("Male");
    public static JRadioButton fSex = new JRadioButton("Female");
    public static JLabel error = new JLabel("");

    public LogRegGUI(JPanel regFields){
        this.regFields = regFields;
    }
    public void setLogGUI(){
            BankGUI bankGUI = new BankGUI();
            LogRegGUI logGUI = new LogRegGUI(new JPanel(new GridLayout(2, 1, 0, 45)));
            mainLogRegGUI = new JFrame("Login");
            phoneNumber = new JTextField(10);
            passwordField = new JPasswordField();
            JButton login = new JButton("Login");
            Font text = new Font("Monospaced", Font.BOLD, 20);
        error.setForeground(Color.BLACK);
        error.setFont(new Font("Monospaced", Font.BOLD, 14));
        error.setBounds(47, 300, 300, 60);
        error.setVisible(false);
        mainLogRegGUI.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        mainLogRegGUI.setLocationRelativeTo(null);
        mainLogRegGUI.getContentPane().setBackground(new Color(64,64,64));
        mainLogRegGUI.setLayout(null);
        mainLogRegGUI.setResizable(false);
        mainLogRegGUI.add(logGUI.regFields);
        logGUI.regFields.setBounds(42, 40, 200, 100);
        logGUI.regFields.add(phoneNumber);
        logGUI.regFields.add(passwordField);
        logGUI.regFields.setBackground(new Color(64,64,64));
        login.setForeground(Color.black);
        login.setFont(text);
        login.setBackground(Color.WHITE);
        login.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        login.setBounds(42, 200, 200, 40);
        login.addActionListener(new ButtonClickListener());
        mainLogRegGUI.add(login);
        mainLogRegGUI.setIconImage(bankGUI.bankIcon.getImage());
        phoneNumber.setToolTipText("Your phone number");
        passwordField.setToolTipText("Your password");
        passwordField.setFont(text);
        phoneNumber.setFont(text);
        mainLogRegGUI.add(error);
        phoneNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)){
                    evt.consume();
                }
                if (phoneNumber.getText().length() >= 12 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    evt.consume();
                }
            }
        });
        mainLogRegGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FirstMenu.firstMenuGUI.setVisible(true);
            }
        });
        mainLogRegGUI.setVisible(true);
    }
    public void setRegGUI() {
        BankGUI bankGUI = new BankGUI();
        LogRegGUI regGUI = new LogRegGUI(new JPanel(new GridLayout(5, 1, 0, 30)));
        mainLogRegGUI = new JFrame("Register");
        phoneNumber = new JTextField(10);
        passwordField = new JPasswordField();
        firstName = new JTextField(10);
        lastName = new JTextField(10);
        radButtons = new JPanel(new GridLayout(1, 2));
        mSex.setSelected(true);
        JButton register = new JButton("Register");
        Font text = new Font("Monospaced", Font.BOLD, 20);
        error.setForeground(Color.BLACK);
        error.setFont(new Font("Monospaced", Font.BOLD, 14));
        error.setBounds(47, 300, 300, 60);
        error.setVisible(false);

        mainLogRegGUI.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        mainLogRegGUI.setLocationRelativeTo(null);
        mainLogRegGUI.getContentPane().setBackground(new Color(64,64,64));
        mainLogRegGUI.setLayout(null);
        mainLogRegGUI.setResizable(false);
        mainLogRegGUI.setIconImage(bankGUI.bankIcon.getImage());
        register.setForeground(Color.black);
        register.setFont(text);
        register.setBackground(Color.WHITE);
        register.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        register.addActionListener(new ButtonClickListener());
        register.setBounds(42, 280, 200, 40);

        firstName.setToolTipText("Your first name");
        lastName.setToolTipText("Your last name");
        phoneNumber.setToolTipText("Your phone number");
        passwordField.setToolTipText("Your password");

        phoneNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if(!Character.isDigit(c)){
                    evt.consume();
                }
                if (phoneNumber.getText().length() >= 12 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                evt.consume();
                }
            }
        });
        firstName.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if(Character.isDigit(c) || Character.isSpaceChar(c)){
                    evt.consume();
                }
            }
        });

        lastName.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if(Character.isDigit(c) || Character.isSpaceChar(c)){
                    evt.consume();
                }
            }
        });
        regGUI.regFields.setBackground(new Color(64,64,64));
        regGUI.regFields.setBounds(42, 20, 200, 250);
        passwordField.setFont(text);
        mainLogRegGUI.add(regGUI.regFields);
        JTextField[] textFields = {firstName, lastName, phoneNumber};
        for (JTextField jTextField : textFields) {
            regGUI.regFields.add(jTextField);
            jTextField.setFont(text);
        }
        regGUI.regFields.add(passwordField);
        JRadioButton[] radioButton = {mSex, fSex};
        for (JRadioButton jRadioButton : radioButton) {
            jRadioButton.setBackground(new Color(64,64,64));
            jRadioButton.setForeground(Color.BLACK);
            jRadioButton.setFont(text);
            radioGroup.add(jRadioButton);
            radButtons.add(jRadioButton);
        }
        regGUI.regFields.add(radButtons);
        mainLogRegGUI.add(register);
        mainLogRegGUI.add(error);

        mainLogRegGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FirstMenu.firstMenuGUI.setVisible(true);
            }
        });
        mainLogRegGUI.setVisible(true);
    }

}


