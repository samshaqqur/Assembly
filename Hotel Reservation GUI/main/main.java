package project6.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import project6.common.*;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class CS125_Project6_Client extends JFrame {
 
	//componet variables
	private JPanel contentPane;
	private JComboBox cbHotels;
	private JList lstReservations;
	private ArrayList<Reservation> reservations;
	ArrayList<Hotel> hotels;
	//componet models
	
	DefaultComboBoxModel hotelsModel = new DefaultComboBoxModel();
	DefaultListModel reservationsModel= new DefaultListModel();
	private JLabel lblSelectHotel;
	private JLabel lblNewReservation;
	private JLabel lblCheckInMonth;
	private JComboBox MonthBox;
	private JLabel lblNewLabel;
	private JComboBox DayInBox;
	private JLabel lblCheckOutDay;
	private JComboBox DayOutBox;
	private JButton ReservationButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CS125_Project6_Client frame = new CS125_Project6_Client();
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
	public CS125_Project6_Client() {
		initComponets();
		createEvents();
	}
	
	public void initComponets()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cbHotels = new JComboBox(hotelsModel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblSelectHotel = new JLabel("Select Hotel:");
		
		lblNewReservation = new JLabel("New Reservation");
		
		lblCheckInMonth = new JLabel("Check in Month:");
		
		String [] MonthStrings= {"January","February","March","April","May","June","July","August","September","October","Nobember","December"};
		MonthBox = new JComboBox(MonthStrings);
		
		lblNewLabel = new JLabel("Check in Day:");
		String [] a1= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		DayInBox = new JComboBox(a1);
		
		lblCheckOutDay = new JLabel("Check out Day:");
		String [] a2= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		DayOutBox = new JComboBox(a2);
		
		ReservationButton = new JButton("Reserve");
		

		 
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewReservation)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCheckInMonth)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(2)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(MonthBox, Alignment.TRAILING, 0, 104, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel)
													.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
												.addComponent(lblCheckOutDay)
												.addComponent(DayOutBox, Alignment.TRAILING, 0, 104, Short.MAX_VALUE)
												.addComponent(DayInBox, Alignment.TRAILING, 0, 104, Short.MAX_VALUE)
												.addComponent(ReservationButton))))))
							.addGap(47))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbHotels, 0, 147, Short.MAX_VALUE)
							.addGap(18)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblSelectHotel)
					.addContainerGap(372, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSelectHotel)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbHotels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblNewReservation)
							.addGap(8)
							.addComponent(lblCheckInMonth)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MonthBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel)
							.addGap(4)
							.addComponent(DayInBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblCheckOutDay)
							.addGap(5)
							.addComponent(DayOutBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ReservationButton)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		lstReservations = new JList(reservationsModel);
		scrollPane.setViewportView(lstReservations);
		contentPane.setLayout(gl_contentPane);
		
		initHotelsAndReservations();
	}
	public void createEvents() {
		
		cbHotels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel selectedHotel=(Hotel)cbHotels.getSelectedItem(); 
				
				//This is where you will write code which will change the contents of JList
				//Update your reservationsModel
				reservationsModel.clear();
				
				for (Reservation r: selectedHotel.getReservations())
					reservationsModel.addElement(r);
				
				JOptionPane.showMessageDialog(null, "You selected the " + selectedHotel.getHotelName());
				
			}
		});
		
		
		cbHotels.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Hotel)
				{
					// Here value will be of the Type 'Hotel'
					((JLabel) renderer).setText(((Hotel) value).getHotelName());
				}
				return renderer;
			}
		});
		
		lstReservations.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		                if (renderer instanceof JLabel && value instanceof Reservation)
			{
		                    // Here value will be of the Type 'Reservation'
		                		Hotel selectedHotel=(Hotel)cbHotels.getSelectedItem(); 
		                    ((JLabel) renderer).setText(((Reservation) value).getFormattedDisplayString(selectedHotel.getPricePerNight()));
		                }
		                return renderer;
		        }
		});


	}
	
	public void initHotelsAndReservations() {
		//Read in hotels and reservations from file TODO 1
		//Should be able to use project 5 code
		
		
		hotels= new ArrayList<Hotel>();
		reservations= new ArrayList<Reservation>();
		
	/*	Hotel h1=new Hotel(1, "Azusa Inn"," 23 Main St.", "Azusa", "CA", 159);
		h1.addReservation(new Reservation(1, 7,7,4,8));
		h1.addReservation(new Reservation(1, 7,7,9,12));
		Hotel h2=new Hotel(2, "San Dimas Suits", "1456 Apollo Ave.", "San Dimas", "CA", 129);
		h2.addReservation(new Reservation(1, 7,7,5,20));
		Hotel h3=new Hotel(3, "Covina Comfort", "211 Crestline St.", "Covina", "CA", 109);
		h3.addReservation(new Reservation(1, 2,2,2,6));
		Hotel h4=new Hotel(4, "Hotel Glendorado", "394 W. Third St.", "Glendora", "CA", 179);
		h4.addReservation(new Reservation(1, 1,1,2,6));
		Hotel h5=new Hotel(5, "Pasadena Place", "483 Florence St.", "Pasadena", "CA", 249);
		h5.addReservation(new Reservation(1, 3,3,2,6));
		
		hotels.add(h1);
		hotels.add(h2);
		hotels.add(h3);
		hotels.add(h4);
		hotels.add(h5);
		*/
		
		
		ReservationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hotel h = hotels.get(cbHotels.getSelectedIndex());
				Hotel h = (Hotel)cbHotels.getSelectedItem();
				Reservation newRes = new Reservation(h.getUniqueId(),MonthBox.getSelectedIndex()+1,Integer.parseInt(DayInBox.getSelectedItem().toString()),Integer.parseInt(DayOutBox.getSelectedItem().toString()));
					if(h.addResIfCanBook(newRes)) {
					reservations.add(newRes);
					reservationsModel.addElement(newRes);
					writeReservationFile("Reservations.txt",reservations);
					}
					else {
						JOptionPane.showMessageDialog(null, "Reservation already booked!!","Booking Conflict",JOptionPane.WARNING_MESSAGE);
					}
						
				}
				
			
		});
		
	//	h1.addReservation(newRes);
	//	reservationsModel
		
		hotels=getHotelsFromFile("Hotels.txt");
		reservations=readReservationsFromFile("Reservations.txt");
		assignReservationsToCorrectHotel(reservations,hotels);
		
		
		//Binding hotel objects to the model/jcombobox
		for ( Hotel h: hotels)
			hotelsModel.addElement(h);
		cbHotels.setSelectedItem(hotels.get(0));
		
		
		//Binding hotel reservations to model/jlist
		Hotel selectedHotel=(Hotel)cbHotels.getSelectedItem();
		for (Reservation r: selectedHotel.getReservations())
			reservationsModel.addElement(r);
		

		//hotelsModel.addElement("Test 1");
		//reservationsModel.addElement("Test 2");
	
		

	}
	private static void assignReservationsToCorrectHotel(ArrayList<Reservation> reservations, ArrayList<Hotel> hotels)
	{
		// TODO 16: Add code to complete method...
		//
		
		//goes through both arraylists checks when ids match and adds reservation 
		
		for(int r=0;r<reservations.size();r++) {
			for(int h=0;h<hotels.size();h++) {
				if(reservations.get(r).getHotelId()==hotels.get(h).getUniqueId()) {
					hotels.get(h).addReservation(reservations.get(r));
				}
			}
		 
		}
		
		
		
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	// Reads Hotels from fileName and returns as a new ArrayList of hotels.
	//
	// Uses plain-text input.
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<Hotel> getHotelsFromFile(String fileName)
	{
		// TODO 17: Add code to complete method...
		// Initialize input streams
		
		//Array list type Hotel that will be returned
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		FileInputStream fis = null;
		Scanner sc = null;	
		Hotel a1	= new Hotel();
		try
		{
			fis = new FileInputStream("Hotels.txt");
			sc = new Scanner(fis);

			// Keep reading words from file...
		        while (sc.hasNextLine()) {
		        		String line=sc.nextLine();
		        		line= line.replace("Hotel(", "").replace(")", "");
		            String[] arrayLine= line.split("\\s*,\\s*"); 
		            a1.setUniqueId(Long.parseLong(arrayLine[0]));
		            a1.setHotelName(arrayLine[1]);
		            a1.setAddress(arrayLine[2]);;
		            a1.setCity(arrayLine[3]);
		            a1.setStateAbbrev(arrayLine[4]);
		            a1.setPricePerNight(Double.parseDouble(arrayLine[5]));
		            Hotel newH=new Hotel(a1.getUniqueId(),a1.getHotelName(),a1.getAddress(),a1.getCity(),a1.getStateAbbrev(),a1.getPricePerNight());
					hotels.add(newH);  
		   
		        }
				
		}
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		return hotels;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	// Reads Reservations from a given file and stores them into the reservations
	// list. Returns a new ArrayList of reservations read in from file. If no reservations
	// in file found at fileName, should return an empty ArrayList. 
	//
	// Uses serialize for input.
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<Reservation> readReservationsFromFile(String fileName)
	{
		// TODO 18: Add code to complete method...
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		
		// Your code here.....`
		
		try { //reads objects from file to arraylist
			fis=new FileInputStream (fileName);
			ois=new ObjectInputStream(fis);
			
			while (true) {
				reservations.add((Reservation)ois.readObject());
			}
			
			//ois.close();
		} catch (EOFException e) {
			System.out.println(fileName + " file successfully read.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservations;
		
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	// Overwrites the file at fileName with the reservations found in globalReservations. 
	// globalReservations should contain the reservations found in the file when the program
	// begin, as well as any new reservation the user made. Returns true upon success; false upon failure
	//
	// Uses serialize for input.
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	private static boolean writeReservationFile(String fileName, ArrayList<Reservation> globalReservations)
	{
		// TODO 19: Add code to complete method...
		
		readReservationsFromFile(fileName);

		// Initialize output streams
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		boolean readFail = false;

		
		try { //writes objects to the file
			fos=new FileOutputStream(fileName);
			oos=new ObjectOutputStream(fos);
			
			for (Reservation e : globalReservations)
				oos.writeObject(e);
			
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			readFail = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			readFail = false;
		}
		
		
		// Return whether there was success or not
		if (readFail)
			return false;
		else
			return true; //If we made it here, then the file was read successfully. Return true.
	} 
		
	
	
}
