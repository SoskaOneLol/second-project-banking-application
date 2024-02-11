
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BankGUI extends MoneyActions{
    protected static JFrame mainBank;
    private JPanel mainPanel;
    private JLabel greetings;
    private JButton withdraw;
    private JButton deposit;
    private JButton info;
    protected static JLabel balance;
    protected ImageIcon bankIcon = new ImageIcon("src/images/bankIcon.png");
    protected Image bankCard = Toolkit.getDefaultToolkit().getImage("src/images/bankCard.png");

    public BankGUI(){
    }
        class ImgPanel extends JPanel{
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(bankCard, 190, 20, this);
            }
        }
        public void bankGUI() {
            mainBank = new JFrame("Motivated Bank");
            mainPanel = new ImgPanel();
            balance = new JLabel("Your balance is: " + ButtonClickListener.UserInfo.balanceUser);
            greetings = new JLabel("Hello " + ButtonClickListener.UserInfo.firstNameUser +" "+ ButtonClickListener.UserInfo.lastNameUser+"!");
            withdraw = new JButton("Withdraw");
            deposit = new JButton("Deposit");
            info = new JButton("Info");
            Font text = new Font("Monospaced", Font.BOLD, 20);
            mainBank.setSize(800, 500);
            mainBank.setIconImage(bankIcon.getImage());
            mainBank.getContentPane().setBackground(new Color(64,64,64));
            mainBank.setResizable(false);
            mainBank.setLayout(null);
            mainBank.setLocationRelativeTo(null);

            mainPanel.setLayout(null);
            mainPanel.setBackground(new Color(50, 50, 50));
            mainPanel.setBounds(0, 0, 800, 300);
            balance.setForeground(Color.BLACK);
            balance.setFont(text);
            balance.setBounds(0,65, 800, 60);
            greetings.setBounds(0, 20, 800, 60);
            greetings.setHorizontalAlignment(JLabel.CENTER);
            balance.setHorizontalAlignment(JLabel.CENTER);
            greetings.setFont(text);
            greetings.setForeground(Color.BLACK);
            JButton[] jButtons = {withdraw, deposit, info};
            for(JButton jButton : jButtons){
                jButton.setFont(text);
                jButton.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
                jButton.setForeground(Color.BLACK);
                jButton.setBackground(new Color(255, 255,255));
                jButton.addActionListener(new ButtonClickListener());
                jButton.addActionListener(new MoneyActions());
            }
            withdraw.setBounds(140, 350, 200, 40);
            deposit.setBounds(448, 350, 200, 40);
            info.setBounds(0, 0, 100, 40);
            mainPanel.add(info);
            mainPanel.add(greetings);
            mainPanel.add(balance);
            mainBank.add(mainPanel);
            mainBank.add(deposit);
            mainBank.add(withdraw);

            mainBank.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    FirstMenu.firstMenuGUI.setVisible(true);
                }
            });

            mainBank.setVisible(true);
}

}

