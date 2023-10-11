package calcolatrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calcolatrice {
    private JButton b1;
    private JButton plus;
    private JButton b2;
    private JButton b3;
    private JButton diviso;
    private JButton equal;
    private JButton sorpresa;
    private JButton b0;
    private JButton per;
    private JButton b9;
    private JButton b8;
    private JButton b7;
    private JButton minus;
    private JButton b6;
    private JButton b5;
    private JButton b4;
    private JPanel panel;
    private JLabel label;
    private JButton canc;

    private String[] array;
    private int i = 0;


    public Calcolatrice() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("1"));
                array[i] = "1";
                i++;
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("2"));
                array[i] = "2";
                i++;
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("3"));
                array[i] = "3";
                i++;
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("4"));
                array[i] = "4";
                i++;
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("5"));
                array[i] = "5";
                i++;
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("6"));
                array[i] = "6";
                i++;
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("7"));
                array[i] = "7";
                i++;
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("8"));
                array[i] = "8";
                i++;
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("9"));
                array[i] = "9";
                i++;
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("0"));
                array[i] = "0";
                i++;
            }
        });
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("+"));
                array[i] = "+";
                i++;
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("-"));
                array[i] = "-";
                i++;
            }
        });
        per.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("*"));
                array[i] = "*";
                i++;
            }
        });
        diviso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().concat("/"));
                array[i] = "/";
                i++;
            }
        });
        sorpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "I don't want to set the world on fire\n" +
                        "I just want to start\n" +
                        "A flame in your heart\n" +
                        "In my heart, I have but one desire\n" +
                        "And that one is you\n" +
                        "No other will do\n" +
                        "I've lost all ambition\n" +
                        "For worldly acclaim\n" +
                        "I just want to be the one you love\n" +
                        "And with your admission\n" +
                        "That you feel the same\n" +
                        "I'll have reached the goal I'm dreaming of\n" +
                        "Believe me\n" +
                        "I don't want to set the world on fire\n" +
                        "I just want to start\n" +
                        "A flame in your heart\n" +
                        "I don't want to set the world on fire, honey\n" +
                        "I love you too much\n" +
                        "I just want to start\n" +
                        "A great big flame\n" +
                        "Down in your heart\n" +
                        "You see\n" +
                        "Way down inside of me\n" +
                        "Darlin', I have only one desire\n" +
                        "And that one desire is you\n" +
                        "And I know\n" +
                        "Nobody else ain't gonna do\n" +
                        "I've lost all ambition\n" +
                        "For worldly acclaim\n" +
                        "I just want to be the one you love\n" +
                        "And with your admission\n" +
                        "That you feel the same\n" +
                        "I'll have reached the goal I'm dreaming of\n" +
                        "Believe me\n" +
                        "I don't want to set the world on fire\n" +
                        "I just want to start\n" +
                        "A flame in your heart");
            }
        });
        canc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().substring(0, label.getText().length() -1));
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcolatrice");
        frame.setContentPane(new Calcolatrice().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 2800);
        frame.setVisible(true);
    }
}
