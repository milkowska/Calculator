import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private JButton add, substitute, multiply, divide, decimal, equal, delete,
            clear, negation;
    private JButton[] numberOfButtons = new JButton[10];
    private JButton[] functionalButtons = new JButton[9];
    private JPanel panel;

    private Font font = new Font("Times New Roman", Font.BOLD, 35);

    double first = 0, second = 0, third = 0, result = 0;
    char sign;

    Application() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);
        frame.setLayout(null);

        // Creating a text field and setting font and bounds to it. Text field can not be editable
        textField = new JTextField();
        textField.setFont(font);
        textField.setEditable(false);
        textField.setBounds(60, 30, 360, 60);

        // Creating JButtons for each mathematical symbol
        add = new JButton("+");
        substitute = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        decimal = new JButton(".");
        equal = new JButton("=");
        delete = new JButton("DELETE");
        clear = new JButton("CLEAR");
        negation = new JButton("(-)");

        //Added each mathematical symbol button to the array storing all functional buttons
        functionalButtons[0] = add;
        functionalButtons[1] = substitute;
        functionalButtons[2] = multiply;
        functionalButtons[3] = divide;
        functionalButtons[4] = decimal;
        functionalButtons[5] = equal;
        functionalButtons[6] = delete;
        functionalButtons[7] = clear;
        functionalButtons[8] = negation;

        //Added action listener for each functional button
        for (int i = 0; i < 9; i++) {
            functionalButtons[i].addActionListener(this);
            functionalButtons[i].setFont(font);
            functionalButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberOfButtons[i] = new JButton(String.valueOf(i));
            numberOfButtons[i].addActionListener(this);
            numberOfButtons[i].setFont(font);
            numberOfButtons[i].setFocusable(false);
        }

        //TODO set bounds for clear delete negation

        /*Creating a separate panel which contains all 9 digits and a few
         * mathematical symbols. This will be added to the frame
         * */
        panel = new JPanel();
        panel.setBounds(60, 120, 360, 360);
        panel.setLayout(new GridLayout(4, 4, 12, 12));
        panel.add(numberOfButtons[1]);
        panel.add(numberOfButtons[2]);
        panel.add(numberOfButtons[3]);
        panel.add(add);
        panel.add(numberOfButtons[4]);
        panel.add(numberOfButtons[5]);
        panel.add(numberOfButtons[6]);
        panel.add(substitute);
        panel.add(numberOfButtons[7]);
        panel.add(numberOfButtons[8]);
        panel.add(numberOfButtons[9]);
        panel.add(multiply);
        panel.add(decimal);
        panel.add(numberOfButtons[0]);
        panel.add(equal);
        panel.add(divide);

        frame.add(panel);
        frame.add(negation);
        frame.add(delete);
        frame.add(clear);
        frame.add(textField);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        Application calculator = new Application();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberOfButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == add) {
            first = Double.parseDouble(textField.getText());
            sign = '+';
            textField.setText("");
        }
        if (e.getSource() == substitute) {
            first = Double.parseDouble(textField.getText());
            sign = '-';
            textField.setText("");
        }
        if (e.getSource() == multiply) {
            first = Double.parseDouble(textField.getText());
            sign = '*';
            textField.setText("");
        }
        if (e.getSource() == divide) {
            first = Double.parseDouble(textField.getText());
            sign = '/';
            textField.setText("");
        }
        if (e.getSource() == decimal) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == equal) {
            second = Double.parseDouble(textField.getText());

            switch (sign) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case '/':
                    result = first / second;
                    break;
            }
            textField.setText(String.valueOf(result));
            first = result;
        }
        if (e.getSource() == delete) {
            String text = textField.getText();
            textField.setText("");
            for (int i = 0; i < text.length() - 1; i++) {
                textField.setText(textField.getText() + text.charAt(i));
            }
        }
        if (e.getSource() == negation) {
            third = Double.parseDouble(textField.getText());
            third *= -1;
            textField.setText(String.valueOf(third));
        }

    }
}
