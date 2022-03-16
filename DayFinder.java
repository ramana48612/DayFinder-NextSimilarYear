package DayFinderCalc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;

public class DayFinder extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DayFinder frame = new DayFinder();
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
	public DayFinder() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 403);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDayFinder = new JLabel("DAY FINDER");
		lblDayFinder.setFont(new Font("C059", Font.BOLD, 20));
		lblDayFinder.setForeground(Color.RED);
		lblDayFinder.setBounds(146, 0, 214, 50);
		contentPane.add(lblDayFinder);
		
		JLabel lblEnterTheDate = new JLabel("Enter the DATE : ");
		lblEnterTheDate.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEnterTheDate.setBounds(39, 80, 228, 29);
		contentPane.add(lblEnterTheDate);
		
		JLabel lblEnterTheMonth = new JLabel("Enter the MONTH :  ");
		lblEnterTheMonth.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEnterTheMonth.setBounds(39, 121, 228, 29);
		contentPane.add(lblEnterTheMonth);
		
		JLabel lblEnterTheYear = new JLabel("Enter the YEAR : ");
		lblEnterTheYear.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEnterTheYear.setBounds(39, 162, 228, 29);
		contentPane.add(lblEnterTheYear);
		
		txt1 = new JTextField();
		txt1.setBackground(Color.CYAN);
		txt1.setBounds(285, 62, 153, 38);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBackground(Color.CYAN);
		txt2.setColumns(10);
		txt2.setBounds(285, 112, 153, 38);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setBackground(Color.CYAN);
		txt3.setColumns(10);
		txt3.setBounds(285, 160, 153, 38);
		contentPane.add(txt3);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(90, 239, 116, 43);
		contentPane.add(label);
		
		
		
		
		
		JButton btnDay = new JButton("Day");
		btnDay.setBackground(Color.ORANGE);
		
		btnDay.addActionListener(new ActionListener() {
			
		     public void actionPerformed(ActionEvent e) {
		    	
		    	 
		    	 int date = Integer.parseInt(txt1.getText());
		    	 int month = Integer.parseInt(txt2.getText());
		    	 int year = Integer.parseInt(txt3.getText());
		    	 
		    	 
		    	 
		    	 int oddYear = 0 , oddMonth = 0, oddDate = 0;		
		 		String ans[] = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
		 		int oddForMonth[] = {3,7,3,2,3,2,3,3,2,3,2,3};		
		 		oddForMonth[1]=(year%4==0 && (year%100!=0 || year%400 == 0))?1:0;			
		 		int lastdate = oddForMonth[month-1] == 3 ? 31 :oddForMonth[month-1] == 2 ? 30 :oddForMonth[month-1] == 1 ? 29 : 28; 		
		 		if((date>=1 && date <= lastdate ) && month>=1 && month<13 ) {		
		 		year--;
		 		year = year % 400;		
		 		oddYear  += (year>=300) ? 1  : (year>=200) ? 3  : (year>=100) ? 5  : 0;
		 		year -= (year>=300) ? 300  : (year>=200) ? 200  :  (year>=100) ? 100  : 0;	
		 		int a = (int)(year/4);		
		 		oddYear += a*2 + year-a;		
		 		oddYear %= 7;		
		 		for(int i=0; i<month-1; i++) {
		 			oddMonth += oddForMonth[i];			
		 		}
		 		oddMonth %= 7;
		 		oddDate = date; 
		 		int odd = (oddYear+oddMonth+oddDate )% 7;		
		 		txt4.setText(ans[odd]);
		 		}else {
		 			System.out.println();
		 			txt4.setText("Please give correct input.");
		 		}		
		     }
		});
		
		btnDay.setBounds(80, 249, 117, 25);
		contentPane.add(btnDay);
		
	
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Dialog", Font.PLAIN, 17));
		txt4.setBackground(Color.PINK);
		txt4.setBounds(224, 244, 214, 35);
		contentPane.add(txt4);
		txt4.setColumns(10);
	}
}
