package calcolatrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Stack;

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
    private JRadioButton RPNRadioButton;

    private boolean RPN = false;

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
                JOptionPane.showMessageDialog(panel, "BECCATISTOTRAPEZIOPERFAVOREHHH");
            }
        });
        canc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(label.getText().substring(0, label.getText().length() -1));
            }
        });
        RPNRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RPN = !RPN;
            }
        });
    }
    String RPNInput = "2395-*+3-";

    public boolean Operazione(String RPNInput, int i){
        boolean operazione = false;
        if(RPNInput.charAt(i) == '+' || RPNInput.charAt(i) == '-' || RPNInput.charAt(i) == '*' || RPNInput.charAt(i) == '/'){
            operazione = true;
        }
       return operazione;
    }

    public void scriviRPN(String RPNInput){
        char arrayOperazioni[] = new char[RPNInput.length()];
        int x = 0;
        String RPNOutput = "";
        for (int i = 0; i < RPNInput.length(); i++){
            if (!Operazione(RPNInput, i) ){
                RPNOutput+=RPNInput.charAt(i);
            }
            else{
                arrayOperazioni[x] = RPNInput.charAt(i);
            }
        }
        for (int i = 0; i < arrayOperazioni.length; i++){
            RPNOutput += arrayOperazioni[i];
        }
    }

    public float CalcolaRPN(String RPNInput){
        //stack int
        Float op[] = new Float[2];
        float newPush=0;
        Stack<Float> stack = new Stack<Float>();
        for(int i = 0; i < RPNInput.length(); i++){
            if(!Operazione(RPNInput, i) ){
                stack.push((float) RPNInput.charAt(i));
            }
            else {
                op[1] = stack.pop();
                op[0] = stack.pop();
                switch (RPNInput.charAt(i)){
                    case '+': newPush = op[0]+op[1];
                    case '-': newPush = op[0]-op[1];
                    case '*': newPush = op[0]*op[1];
                    case '/': newPush = op[0]/op[1];
                }
                stack.push(newPush);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcolatrice");
        frame.setContentPane(new Calcolatrice().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 2800);
        frame.setVisible(true);
    }
}
