import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CalculatorView extends JFrame implements ActionListener {

	Calculator calc;
	private JTextArea area;
	private JTextField input;
	public static void main(String[] args) {
		new CalculatorView();
	}
	public CalculatorView(){
		super("Calculator");
		setSize(new Dimension(400,400));
		setLayout(new BorderLayout());
		calc=new Calculator();
		initializeComponents();
		setVisible(true);
	}
	private void initializeComponents() {
		area = new JTextArea(20,15);
		area.setLineWrap(true);
		area.setEditable(false);
		JScrollPane pane = new JScrollPane(area);
		add(pane,BorderLayout.NORTH);
		
		input = new JTextField(20);
		input.addActionListener(this);
		add(input,BorderLayout.SOUTH);
	
		//add(answer);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == input)
		{
			if(input.getText().equals("clear"))
			{
				area.setText("");
				input.setText("");
			}
		double result = calc.calculate(input.getText());
		area.setText(area.getText() + "\n" + input.getText() + " = " + result);
		input.setText("");
		}
		
	}
}
