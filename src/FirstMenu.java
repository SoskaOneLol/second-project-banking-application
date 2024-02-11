import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FirstMenu implements ActionListener {
    protected int SCREEN_WIDTH = 300;
    protected int SCREEN_HEIGHT = 400;
    protected static JFrame firstMenuGUI;
    private JPanel loginButtons;

    public void guiSettings(){
        BankGUI bankGUI = new BankGUI();
        firstMenuGUI = new JFrame("Motivated Bank");
        firstMenuGUI.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        firstMenuGUI.setResizable(false);
        firstMenuGUI.setLocationRelativeTo(null);
        firstMenuGUI.setLayout(null);
        firstMenuGUI.getContentPane().setBackground(new Color(64,64,64));
        firstMenuGUI.setIconImage(bankGUI.bankIcon.getImage());

        JLabel bankText = new JLabel("Motivated Bank");
        Font text = new Font("Monospaced", Font.BOLD, 20);
        bankText.setBounds(58, 0, SCREEN_WIDTH, 40);
        bankText.setFont(text);
        bankText.setForeground(Color.BLACK);

        firstMenuGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButtons = new JPanel();
        loginButtons.setLayout(new GridLayout(2, 1));
        firstMenuGUI.add(bankText);
        firstMenuGUI.add(loginButtons);
        loginButtonsEvent();
        firstMenuGUI.setVisible(true);


    }
    private void loginButtonsEvent(){
        JButton login = new JButton("Login");
        JButton register = new JButton("Register");
        loginButtons.add(login);
        loginButtons.add(register);
        loginButtons.setBounds(44, 140, 200, 70);
        loginButtons.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        Font text = new Font("Monospaced", Font.BOLD, 20);
        JButton[] buttons = new JButton[]{login, register};
        for (JButton jButton : buttons) {
            jButton.setForeground(Color.black);
            jButton.setFont(text);
            jButton.setBackground(new Color(255,255,255));
            jButton.addActionListener(new FirstMenu());
        }
        firstMenuGUI.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        LogRegGUI logRegGUI = new LogRegGUI(null);
        String command = e.getActionCommand();
        if (command.equals("Login")) {
            logRegGUI.setLogGUI();
            firstMenuGUI.setVisible(false);

        } else if (command.equals("Register")) {
            logRegGUI.setRegGUI();
            firstMenuGUI.setVisible(false);
        }
    }
}