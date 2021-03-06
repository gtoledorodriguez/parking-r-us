package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class RAS_CC {

	private JFrame frame;

	// header object declarations
	private static JPanel headerPanel; // panel for header
	// center object declarations
	// mainly used for showing the 'action', or the sorting process
	private static JPanel centerPanel; // panel for center

	// footer object declarations
	private static JPanel optionsPanel;

	private static int[] randData; // stores current array to be sorted
	private static JButton btnParkingRUs;
	private static JButton btnAbout;
	private static JLabel lblMadeByGladys;
	private static JButton btnEnter;
	private JButton btnReserveASpot;
	private JButton btnMonthlySubscription;
	private JLabel lblReserveASpot;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblCreditCardNumber;
	private JTextField txtEnterCreditCard;
	private JLabel lblExpirationDate;
	private JTextField txtEnterMmyy;
	private JLabel lblSecurityCode;
	private JTextField txtEnterCvncvv;
	private JLabel lblPricespriceVaries;
	private JButton btnProfile;
	private JButton btnStatistics;
	private Boolean viewStatistics;
	private String ccn;
	private String expiration;
	private String security;
	private Boolean isValid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RAS_CC window = new RAS_CC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RAS_CC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Parking R Us");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setSize(900, 500);
		frame.setResizable(false);
		System.out.println("GUI Initialized!"); // debug

		// Create panel for top
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(60, 179, 113));

		// Create panel for center
		centerPanel = new JPanel();
		centerPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));


		// Creating menu panel at bottom
		optionsPanel = new JPanel();

		// align and add panes to frame
		frame.getContentPane().add(BorderLayout.NORTH, headerPanel);
		headerPanel.setLayout(new MigLayout("", "[123px][75px][][][][][][][][][][][][][][][][]", "[29px][]"));
		
		btnParkingRUs = new JButton("Parking R Us");
		btnParkingRUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI gui = new GUI();
				frame.setVisible(false);
			}
		});
		headerPanel.add(btnParkingRUs, "cell 0 0,alignx left,aligny top");
		
		btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.NewScreen();
			}
		});
		
		viewStatistics = true;
		if (viewStatistics) {
			btnStatistics= new JButton("Statistics");
				btnStatistics.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Statistics statistics = new Statistics();
						frame.setVisible(false);
					}
				});
			headerPanel.add(btnStatistics, "cell 16 0");
		}
		
		btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile profile = new Profile();
				frame.setVisible(false);
			}
		});
		headerPanel.add(btnProfile, "cell 17 0");
		headerPanel.add(btnAbout, "cell 0 1,alignx left,aligny top");
		
		btnReserveASpot = new JButton("Reserve A Spot");
		btnReserveASpot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReserveASpot reserve = new ReserveASpot();
				frame.setVisible(false);
			}
		});
		headerPanel.add(btnReserveASpot, "cell 1 1");
		
		btnMonthlySubscription = new JButton("Monthly Subscription");
		btnMonthlySubscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonthlySubscription mSub = new MonthlySubscription();
				frame.setVisible(false);
			}
		});
		headerPanel.add(btnMonthlySubscription, "cell 2 1");
		frame.getContentPane().add(BorderLayout.SOUTH, optionsPanel);
		
		lblMadeByGladys = new JLabel("Made by Grace Arnold, Chris Dharma, and Gladys Toledo-Rodriguez");
		optionsPanel.add(lblMadeByGladys);
		frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		centerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblReserveASpot = new JLabel("Reserve A Spot");
		lblReserveASpot.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblReserveASpot);
		
		lblPricespriceVaries = new JLabel("Prices: [Price varies based on lot]");
		lblPricespriceVaries.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblPricespriceVaries);
		
		lblCreditCardNumber = new JLabel("Credit Card Number");
		lblCreditCardNumber.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblCreditCardNumber);
		
		txtEnterCreditCard = new JTextField();
		txtEnterCreditCard.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterCreditCard.setText("Enter Credit Card #");
		centerPanel.add(txtEnterCreditCard);
		txtEnterCreditCard.setColumns(10);
		
		lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblExpirationDate);
		
		txtEnterMmyy = new JTextField();
		txtEnterMmyy.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterMmyy.setText("Enter MM/YY");
		centerPanel.add(txtEnterMmyy);
		txtEnterMmyy.setColumns(10);
		
		lblSecurityCode = new JLabel("Security Code");
		lblSecurityCode.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblSecurityCode);
		
		txtEnterCvncvv = new JTextField();
		txtEnterCvncvv.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterCvncvv.setText("Enter CVN/CVV");
		centerPanel.add(txtEnterCvncvv);
		txtEnterCvncvv.setColumns(10);
		
		btnEnter = new JButton("Enter");
		centerPanel.add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ccn = txtEnterCreditCard.getText();
				expiration = txtEnterMmyy.getText();
				security = txtEnterCvncvv.getText();
				if (ccn.equals("Enter Credit Card #") || expiration.equals("Enter MM/YY") || security.equals("Enter CVN/CVV")) {
					NullError nerror = new NullError();
				}
				else if (ccn.equals("") || expiration.equals("") || security.equals("")) {
					NullError nerror = new NullError();
				}
				else if (ccn.length() != 16 && security.length() != 3 && expiration.length() != 5) {
					NullError nerror = new NullError();
				}
				else {
					isValid = true;
					try {
						Double intccn = Double.parseDouble(ccn);
					} catch (NumberFormatException nfe) {
						isValid = false;
						NullError nerror = new NullError();
					}
					try {
						int intsec = Integer.parseInt(security);
					} catch (NumberFormatException nfe) {
						isValid = false;
						NullError nerror = new NullError();
					}
					if (isValid) {
						RAS_Congrats rasCongrats = new RAS_Congrats();
						frame.setVisible(false);
					}
				}
			}
		});
		// turn on frame
		frame.setVisible(true);
	}
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RAS_CC window = new RAS_CC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
}
