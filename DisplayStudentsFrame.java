import javax.swing.*;
import java.awt.*;

public class DisplayStudentsFrame extends JFrame {
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JLabel titleLabel;

    public DisplayStudentsFrame(String data) {
        setTitle("University - View Students");
        setSize(500, 400);
        setLocation(350, 250);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));

        titleLabel = new JLabel("All Registered Students", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(titleLabel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setText(data);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}