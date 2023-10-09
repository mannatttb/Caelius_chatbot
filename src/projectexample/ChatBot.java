package projectexample;

import java.awt.Color;

import javax.swing.*;

public class ChatBot extends JFrame{
	private JTextArea ta=new JTextArea();
	ChatBot(){
		setTitle("CHATBOT CAELIUS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.gray);
        
        
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setBackground(new Color(255, 255, 255));
        
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatBot();

	}

}
