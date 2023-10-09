package projectexample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBotApp extends JFrame implements ActionListener {
    private static JTextArea textArea = new JTextArea(20, 40);
    private static JButton button = new JButton("Send");
    private static JTextField textField = new JTextField(30);
    JLabel label=new JLabel();

    public ChatBotApp() {
        setTitle("Chatbot Application");
        setResizable(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel topPanel = new JPanel(); 
    	topPanel.setBackground(new Color(182, 183, 223)); 
    	topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
    	label.setText("WELCOME TO CHATBOT");
    
    	label.setForeground(new Color(0,0,0)); 
    	label.setFont(new Font("Arial", Font.PLAIN, 24));
    	topPanel.add(label);
    	add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.SOUTH);

        button.addActionListener(this);
        
        DatabaseConnection.initializeDatabase();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String message = textField.getText();
            if (!message.isEmpty()) {
                appendToTextArea("question: " + message);
                textField.setText("");
                
                String getResponse = DatabaseConnection.queryDb(message);
                appendToTextArea("answer: " + getResponse);
            }
        }
    }

    private void appendToTextArea(String message) {
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatBotApp());
    }
}
