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

    private Font font = new Font("Times New Roman", Font.BOLD, 35 );


    Application() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setFont(font);
        textField.setEditable(false);
        textField.setBounds(60, 30, 360, 60);

    }


    public static void main(String[] args) {
        Application calculator = new Application();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
