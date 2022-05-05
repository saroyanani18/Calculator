import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
public class Calculator implements ActionListener {
    JFrame frame = new JFrame("Calculator");
    JTextField textField;

    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[8];
    JButton additionButton, subtractionButton, multiplicationButton, divisionButton, deleteButton,
            dotButton, equalsButton, clearButton;
    JPanel panel;
    ImageIcon logo=new ImageIcon("OMG_8929.JPG");
    Font font = new Font("Courier", Font.BOLD, 30);
    double firstNumber = 0, secondNumber = 0, answer = 0;
    char operator;

    Calculator() {
        ImageIcon logo=new ImageIcon("IMG_8929.JPG");
        frame.setIconImage(logo.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(172, 213, 243));
        frame.setResizable(false);
        textField = new JTextField();
        textField.setBounds(50, 35, 300, 55);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setBackground(Color.getHSBColor(277, 47, 100));

        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("\u00D7");
        divisionButton = new JButton("\u00F7");
        dotButton = new JButton(".");
        deleteButton = new JButton("C");
        equalsButton = new JButton("=");
        clearButton = new JButton("CE");

        functions[0] = additionButton;
        functions[1] = subtractionButton;
        functions[2] = multiplicationButton;
        functions[3] = divisionButton;
        functions[4] = dotButton;
        functions[5] = equalsButton;
        functions[6] = deleteButton;
        functions[7] = clearButton;

        for (int i = 0; i < 8; i++) {
            functions[i].addActionListener(this);
            functions[i].setFont(font);
            functions[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }
        deleteButton.setBounds(60, 430, 145, 50);
        clearButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(172, 213, 243));
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(additionButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtractionButton);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiplicationButton);
        panel.add(dotButton);
        panel.add(numbers[0]);
        panel.add(equalsButton);
        panel.add(divisionButton);

        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbers[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dotButton) {
            textField.setText(textField.getText().concat("."));

        }
        if (e.getSource() == additionButton) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(" ");
        }
        if (e.getSource() == subtractionButton) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText(" ");
        }
        if (e.getSource() == multiplicationButton) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText(" ");
        }
        if (e.getSource() == divisionButton) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText(" ");
        }
        if (e.getSource() == equalsButton) {
            secondNumber = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    answer = firstNumber + secondNumber;
                    break;
                case '-':
                    answer = firstNumber - secondNumber;
                    break;
                case 'x':
                    answer = firstNumber * secondNumber;
                    break;
                case '/':
                    answer = firstNumber / secondNumber;

            }
            textField.setText(String.valueOf(answer));
            firstNumber = answer;
        }
        if (e.getSource() == clearButton) {
            textField.setText(" ");
        }
        if (e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText(" ");
            for (int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText()+string.charAt(i));
             }
        }
    }

}
