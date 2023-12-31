package calcolatrice;

import database.DB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private JLabel LOGIN;
    private JPasswordField passwordField1;
    private JPanel panel;
    private JTextField textField1;
    private JButton LOGINButton;
    private JButton register;
    private DB db = new DB();


    public login() {
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());
                JFrame frameCalc;
                if(db.login(username, password) == 1){
                    frameCalc = new JFrame("Calcolatrice");
                    frameCalc.setContentPane(new calcolatrice(username).panelCalc);
                    frameCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameCalc.setSize(800, 500 );
                    frameCalc.setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Login fallito");
                    textField1.setText("");
                    passwordField1.setText("");
                }
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField1.getPassword());
                String utente = new String(textField1.getText());
                db.Register(utente, password);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("login");
        frame.setContentPane(new login().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
