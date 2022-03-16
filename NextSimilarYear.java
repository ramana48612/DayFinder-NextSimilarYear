package DayFinderCalc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NextSimilarYear extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NextSimilarYear frame = new NextSimilarYear();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NextSimilarYear() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setForeground(Color.RED);
		txt1.setFont(new Font("Dialog", Font.BOLD, 20));
		txt1.setBackground(Color.DARK_GRAY);
		txt1.setBounds(245, 30, 114, 42);
		contentPane.add(txt1);
		txt1.setColumns(10);
	
		
		JLabel lblEnterTheYear = new JLabel("Enter the Year : ");
		lblEnterTheYear.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEnterTheYear.setForeground(Color.RED);
		lblEnterTheYear.setBounds(33, 24, 226, 55);
		contentPane.add(lblEnterTheYear);
		
		txt2 = new JTextField();
		txt2.setForeground(Color.RED);
		txt2.setFont(new Font("Dialog", Font.BOLD, 20));
		txt2.setColumns(10);
		txt2.setBackground(Color.DARK_GRAY);
		txt2.setBounds(245, 165, 114, 42);
		contentPane.add(txt2);
		
		JLabel lblNextSimilarYear = new JLabel("Next Similar year : \n");
		lblNextSimilarYear.setForeground(Color.RED);
		lblNextSimilarYear.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNextSimilarYear.setBounds(12, 159, 226, 55);
		contentPane.add(lblNextSimilarYear);
		
		JButton btnClick = new JButton("Click");
		btnClick.setForeground(Color.GREEN);
		btnClick.setBackground(Color.GRAY);
		
		btnClick.addActionListener(new ActionListener() {
			
		     public void actionPerformed(ActionEvent e) {
		    	 
		    	 int year = Integer.parseInt(txt1.getText());
		    	 
		    	 int ans = 0;
		 		int years[] = new int[27];
		 		int oddDays[] = new int[27];
		 		int count = 0;
		 		int z = 0;
		 		
		 		if(year%4==0 && (year%100!=0 || year%400==0)) {
		 			ans = year + 28;
		 		}
		 		else {
		 			for(int i=0;i<27;i++) {
		 				years[i] = year;
		 				year++;
		 			}
		 			for(int i=0; i<27;i++) {
		 				int temp = years[i];
		 				if(temp%4==0 && (temp%100!=0 || temp%400==0)) {
		 					oddDays[i] = 2;
		 				}				
		 				else {
		 					oddDays[i] = 1;
		 				}				
		 			}
		 			
		 			
		 			
		 			boolean oddDaysForYear = false;
		 			
		 			while(oddDaysForYear == false) {
		 				
		 				count += oddDays[z];
		 				oddDaysForYear  = count % 7 == 0;
		 				z++;
		 			}
		 			
		 			year = years[z];
		 			if(year%4==0 && (year%100!=0 || year%400==0)) {
		 				ans = year + 5;
		 			}
		 			else {
		 				ans = year;
		 			}
		 			
		 		 }	
		 		
		 		
		 		txt2.setText(String.valueOf(ans));
		    	 
		    	 
		     }
		});
		btnClick.setBounds(144, 101, 133, 42);
		contentPane.add(btnClick);
	}

}
