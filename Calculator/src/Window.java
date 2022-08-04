import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Insets;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnTan;
	private JButton button_1;
	private JButton nine;
	private JButton six;
	private JButton three;
	private JButton btnCos_1;
	private JButton btnSin_1;
	private JButton btnRad;
	private JButton btnY;
	private JButton btnx;
	private JButton btnX_1;
	private JButton btnVar;
	private JButton btnLog;
	private JButton button_14;
	private JButton btnX;
	private JButton button_16;
	private JButton button_17;
	private JButton Equals;
	private JButton btnCos;
	private JButton button_20;
	private JButton eight;
	private JButton five;
	private JButton two;
	private JButton comma;
	private JButton btnSin;
	private JButton btnPow;
	private JButton seven;
	private JButton four;
	private JButton one;
	private JButton zero;
	private JButton btnPi;
	private JButton btnC;
	private JButton btnBack;

	static ArrayList<MathSentence> sentences = new ArrayList<MathSentence>();
	static int currentSentence = 0;
	
	
	//for undo
	static char[] charNumbers = {'0', '1', '2', '3', '4', '5', '6',  '7', '8', '9'};
	static char[] functionChars = {'^', '√'};
	static char[] threeLetterChars = {'s', 'n', 'g'};
	
	double var;
	private JLabel lblVarValue;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MakeFirstSentence();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	boolean inArray(char s, char[] a) {
		for (int i = 0; i < a.length; i++) {
			if (s == a[i]) return true;
			
		}
		
		return false;
		
	}
	
	static void MakeFirstSentence() {
		sentences.add(new MathSentence());

	}
	
	MathSentence GetCurrentMathSentence() {
		return sentences.get(currentSentence);
	}
	Led GetCurrentLed() {
		return GetCurrentMathSentence().GetCurrentLed();
	}
	Faktor GetCurrentFaktor() {
		return GetCurrentMathSentence().GetCurrentFaktor();
	}
	

	/**
	 * Create the frame.
	 */

	
	void Parentes() {
		textField.setText(textField.getText()+"(");
		currentSentence += 1;
		sentences.add(new MathSentence());
		
	}
	
	void EndParentes() {
		if(currentSentence != 0) {
			textField.setText(textField.getText()+")");
			currentSentence -= 1;
			GetCurrentFaktor().setNumber(sentences.get(currentSentence + 1).equals());
			
		}
		
		
	
		
	}
	public Window() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblVarValue = new JLabel("");
		lblVarValue.setForeground(Color.ORANGE);
		lblVarValue.setBounds(253, 77, 46, 14);
		contentPane.add(lblVarValue);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(10, 25, 289, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tan");
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"Tan");
				GetCurrentFaktor().function("Tan");
				Parentes();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(190, 155, 50, 50);
		contentPane.add(btnNewButton);
		
		btnTan = new JButton("Tan-¹");
		btnTan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"Tan-¹");
				GetCurrentFaktor().function("Tan-1");
				Parentes();
			}
		});
		btnTan.setMargin(new Insets(2, 2, 2, 2));
		btnTan.setBorderPainted(false);
		btnTan.setBackground(Color.LIGHT_GRAY);
		btnTan.setBounds(190, 94, 50, 50);
		contentPane.add(btnTan);
		
		JLabel beforeEquals = new JLabel("");
		beforeEquals.setBounds(10, 11, 289, 14);
		contentPane.add(beforeEquals);
		
		button_1 = new JButton(")");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("EndParentes");
				EndParentes();
			}
		});
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(190, 216, 50, 50);
		contentPane.add(button_1); 
		
		nine = new JButton("9");
		nine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nine.setMargin(new Insets(2, 2, 2, 2));
		nine.setBorderPainted(false);
		nine.setBackground(Color.LIGHT_GRAY);
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"9");
				GetCurrentFaktor().addToNumber(9);

			}
		});
		nine.setBounds(190, 277, 45, 45);
		contentPane.add(nine);
		
		six = new JButton("6");
		six.setFont(new Font("Tahoma", Font.PLAIN, 14));
		six.setMargin(new Insets(2, 2, 2, 2));
		six.setBorderPainted(false);
		six.setBackground(Color.LIGHT_GRAY);
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"6");
				GetCurrentFaktor().addToNumber(6);

			}
		});
		six.setBounds(190, 333, 45, 45);
		contentPane.add(six);
		
		three = new JButton("3");
		three.setFont(new Font("Tahoma", Font.PLAIN, 14));
		three.setMargin(new Insets(2, 2, 2, 2));
		three.setBorderPainted(false);
		three.setBackground(Color.LIGHT_GRAY);
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
				GetCurrentFaktor().addToNumber(3);

			}
		});
		three.setBounds(190, 389, 45, 45);
		contentPane.add(three);
		
		btnCos_1 = new JButton("Cos-¹");
		btnCos_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"Cos-¹");
				GetCurrentFaktor().function("Cos-1");
				Parentes();
			}
		});
		btnCos_1.setMargin(new Insets(2, 2, 2, 2));
		btnCos_1.setBorderPainted(false);
		btnCos_1.setBackground(Color.LIGHT_GRAY);
		btnCos_1.setBounds(130, 94, 50, 50);
		contentPane.add(btnCos_1);
		
		btnSin_1 = new JButton("Sin-¹");
		btnSin_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"Sin-¹");
				GetCurrentFaktor().function("Sin-1");
				Parentes();
			}
		});
		btnSin_1.setMargin(new Insets(2, 2, 2, 2));
		btnSin_1.setBorderPainted(false);
		btnSin_1.setBackground(Color.LIGHT_GRAY);
		btnSin_1.setBounds(70, 94, 50, 50);
		contentPane.add(btnSin_1);
		
		btnRad = new JButton("Rad");
		btnRad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnRad.getText() == "Rad") {
					btnRad.setText("Deg");
					GetCurrentFaktor().setRadians(true);
				}else {
					btnRad.setText("Rad");
					GetCurrentFaktor().setRadians(false);
				}
			}
		});
		btnRad.setMargin(new Insets(2, 2, 2, 2));
		btnRad.setBorderPainted(false);
		btnRad.setBackground(Color.LIGHT_GRAY);
		btnRad.setBounds(10, 95, 50, 31);
		contentPane.add(btnRad);
		
		btnY = new JButton("y√(x)");
		btnY.setMargin(new Insets(2, 2, 2, 2));
		btnY.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"√");
				GetCurrentFaktor().function("rooty");
				Parentes();
			}
		});
		btnY.setBorderPainted(false);
		btnY.setBackground(Color.LIGHT_GRAY);
		btnY.setBounds(10, 135, 50, 50);
		contentPane.add(btnY);
		
		btnx = new JButton("√(x)");
		btnx.setMargin(new Insets(2, 2, 2, 2));
		btnx.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"√");
				GetCurrentFaktor().function("sqrt");
				Parentes();
			}
		});
		btnx.setBorderPainted(false);
		btnx.setBackground(Color.LIGHT_GRAY);
		btnx.setBounds(10, 196, 50, 50);
		contentPane.add(btnx);
		
		btnX_1 = new JButton("abs");
		btnX_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"abs");
				GetCurrentFaktor().function("Abs");
				Parentes();
			}
		});
		btnX_1.setMargin(new Insets(2, 2, 2, 2));
		btnX_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnX_1.setBorderPainted(false);
		btnX_1.setBackground(Color.LIGHT_GRAY);
		btnX_1.setBounds(10, 257, 50, 50);
		contentPane.add(btnX_1);
		
		btnVar = new JButton("Var");
		btnVar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVar.setMargin(new Insets(2, 2, 2, 2));
		btnVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "" + var;
				s = s.contains(".") ? s.replaceAll("0*$","").replaceAll("\\.$","") : s;
				textField.setText(textField.getText()+s);
				GetCurrentFaktor().setNumber(var);
			}
		});
		btnVar.setBorderPainted(false);
		btnVar.setBackground(Color.LIGHT_GRAY);
		btnVar.setBounds(249, 93, 50, 31);
		contentPane.add(btnVar);
		
		btnLog = new JButton("log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"Log");
				GetCurrentFaktor().function("Log");
				Parentes();
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLog.setMargin(new Insets(2, 2, 2, 2));
		btnLog.setBorderPainted(false);
		btnLog.setBackground(Color.LIGHT_GRAY);
		btnLog.setBounds(250, 135, 50, 50);
		contentPane.add(btnLog);
		
		button_14 = new JButton("/");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"/");
				GetCurrentLed().divide();
			}
		});
		button_14.setBorderPainted(false);
		button_14.setBackground(Color.LIGHT_GRAY);
		button_14.setBounds(250, 196, 50, 50);
		contentPane.add(button_14);
		
		btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"*");
				GetCurrentLed().multiply();
			}
		});
		btnX.setBorderPainted(false);
		btnX.setBackground(Color.LIGHT_GRAY);
		btnX.setBounds(250, 257, 50, 50);
		contentPane.add(btnX);
		
		button_16 = new JButton("-");
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"-");
				sentences.get(currentSentence).subtract();
			}
		});
		button_16.setBorderPainted(false);
		button_16.setBackground(Color.LIGHT_GRAY);
		button_16.setBounds(250, 318, 50, 50);
		contentPane.add(button_16);
		
		button_17 = new JButton("+");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"+");
				sentences.get(currentSentence).add();
			}
		});
		button_17.setBorderPainted(false);
		button_17.setBackground(Color.LIGHT_GRAY);
		button_17.setBounds(250, 379, 50, 50);
		contentPane.add(button_17);
		
		Equals = new JButton("=");
		Equals.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < currentSentence; i+= 0) {
					EndParentes();
				}
				
				beforeEquals.setText(textField.getText()+ "=");
				double n = sentences.get(currentSentence).equals();
				n = ((double)(Math.round(n*10000))) / 10000; //round down to 4 decimals
				String s = "" + n;
				s = s.contains(".") ? s.replaceAll("0*$","").replaceAll("\\.$","") : s;
				
				textField.setText(s);
				sentences = new ArrayList<MathSentence>();
				MakeFirstSentence();
				currentSentence = 0;
				GetCurrentFaktor().addToNumber(n);
				var = n;
				lblVarValue.setText(s);
				
			}
		});
		Equals.setBorderPainted(false);
		Equals.setBackground(Color.LIGHT_GRAY);
		Equals.setBounds(190, 440, 110, 50);
		contentPane.add(Equals);
		
		btnCos = new JButton("Cos");
		btnCos.setMargin(new Insets(2, 2, 2, 2));
		btnCos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"Cos");
				GetCurrentFaktor().function("Cos");
				Parentes();
			}
		});
		btnCos.setBorderPainted(false);
		btnCos.setBackground(Color.LIGHT_GRAY);
		btnCos.setBounds(130, 155, 50, 50);
		contentPane.add(btnCos);
		
		button_20 = new JButton("(");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("parentes");
				Parentes();
				
			}
		});
		button_20.setBorderPainted(false);
		button_20.setBackground(Color.LIGHT_GRAY);
		button_20.setBounds(130, 216, 50, 50);
		contentPane.add(button_20);
		
		eight = new JButton("8");
		eight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eight.setMargin(new Insets(2, 2, 2, 2));
		eight.setBorderPainted(false);
		eight.setBackground(Color.LIGHT_GRAY);
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"8");
				GetCurrentFaktor().addToNumber(8);

			}
		});
		eight.setBounds(130, 277, 45, 45);
		contentPane.add(eight);
		
		five = new JButton("5");
		five.setFont(new Font("Tahoma", Font.PLAIN, 14));
		five.setMargin(new Insets(2, 2, 2, 2));
		five.setBorderPainted(false);
		five.setBackground(Color.LIGHT_GRAY);
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
				GetCurrentFaktor().addToNumber(5);

			}
		});
		five.setBounds(130, 333, 45, 45);
		contentPane.add(five);
		
		two = new JButton("2");
		two.setFont(new Font("Tahoma", Font.PLAIN, 14));
		two.setMargin(new Insets(2, 2, 2, 2));
		two.setBorderPainted(false);
		two.setBackground(Color.LIGHT_GRAY);
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
				GetCurrentFaktor().addToNumber(2);

			}
		});
		two.setBounds(130, 389, 45, 45);
		contentPane.add(two);
		
		comma = new JButton(",");
		comma.setBorderPainted(false);
		comma.setBackground(Color.LIGHT_GRAY);
		comma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+",");
				GetCurrentFaktor().comma = 1;
			}
		});
		comma.setBounds(130, 445, 45, 45);
		contentPane.add(comma);
		
		btnSin = new JButton("Sin");
		btnSin.setMargin(new Insets(2, 2, 2, 2));
		btnSin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"Sin");
				GetCurrentFaktor().function("Sin");
				Parentes();
			}
		});
		btnSin.setBorderPainted(false);
		btnSin.setBackground(Color.LIGHT_GRAY);
		btnSin.setBounds(70, 154, 50, 50);
		contentPane.add(btnSin);
		
		btnPow = new JButton("^");
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"^");
				GetCurrentFaktor().function("exponent");
			}
		});
		btnPow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPow.setBorderPainted(false);
		btnPow.setBackground(Color.LIGHT_GRAY);
		btnPow.setBounds(70, 215, 50, 50);
		contentPane.add(btnPow);
		
		seven = new JButton("7");
		seven.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seven.setMargin(new Insets(2, 2, 2, 2));
		seven.setBorderPainted(false);
		seven.setBackground(Color.LIGHT_GRAY);
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"7");
				GetCurrentFaktor().addToNumber(7);

			}
		});
		seven.setBounds(70, 277, 45, 45); 
		contentPane.add(seven);
		
		four = new JButton("4");
		four.setFont(new Font("Tahoma", Font.PLAIN, 14));
		four.setMargin(new Insets(2, 2, 2, 2));
		four.setBorderPainted(false);
		four.setBackground(Color.LIGHT_GRAY);
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"4");
				GetCurrentFaktor().addToNumber(4);

			}
		});
		four.setBounds(70, 333, 45, 45);
		contentPane.add(four);
		
		one = new JButton("1");
		one.setFont(new Font("Tahoma", Font.PLAIN, 14));
		one.setMargin(new Insets(2, 2, 2, 2));
		one.setBorderPainted(false);
		one.setBackground(Color.LIGHT_GRAY);
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
				GetCurrentFaktor().addToNumber(1);

				
			}
		});
		one.setBounds(70, 389, 45, 45);
		contentPane.add(one);
		
		zero = new JButton("0");
		zero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		zero.setMargin(new Insets(2, 2, 2, 2));
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"0");
				GetCurrentFaktor().addToNumber(0);

			}
		});
		zero.setBackground(Color.LIGHT_GRAY);
		zero.setBorderPainted(false);
		zero.setBounds(70, 445, 45, 45);
		contentPane.add(zero);
		
		btnPi = new JButton("π");
		btnPi.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"π");
				GetCurrentFaktor().addToNumber(3.14f);
			}
		});
		btnPi.setBorderPainted(false);
		btnPi.setBackground(Color.LIGHT_GRAY);
		btnPi.setBounds(10, 318, 50, 50);
		contentPane.add(btnPi);
		
		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beforeEquals.setText("");
				textField.setText("");
				sentences = new ArrayList<MathSentence>();
				currentSentence = 0;
				MakeFirstSentence();
			}
		});
		btnC.setBorderPainted(false);
		btnC.setBackground(Color.LIGHT_GRAY);
		btnC.setBounds(10, 379, 50, 50);
		contentPane.add(btnC);
		
		btnBack = new JButton("←");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				char lastChar = textField.getText().charAt(textField.getText().length() - 1);
				
				if( inArray(lastChar, charNumbers)) {
					GetCurrentFaktor().removeNumber();

				}else if (lastChar == '*' || lastChar == '/') {
					GetCurrentLed().removeFaktor();
					
				}else if (lastChar == '+' || lastChar == '-') {
					GetCurrentMathSentence().removeLed();
					
				}else if (inArray(lastChar, functionChars)) {
					GetCurrentFaktor().function("no");
					
				}else if (inArray(lastChar, threeLetterChars)) {
					for(int i = 0; i<2; i++) {
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
					}
					GetCurrentFaktor().function("no");
					
				}else if (lastChar == '¹') {
					for(int i = 0; i<4; i++) {
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
					}
					GetCurrentFaktor().function("no");
					
				}else if (lastChar == 'r') {
					for(int i = 0; i<2; i++) {
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
						GetCurrentFaktor().removeNumber();
					}
					
				}else if (lastChar == '(' ) {
					sentences.remove(currentSentence);
					currentSentence--;
					
				}
				else if (lastChar == ')' ) {
					currentSentence++;
					
				}
				
				textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
				
			}
		});
		btnBack.setBounds(10, 440, 50, 50);
		contentPane.add(btnBack);
		

		
		
	}
}
