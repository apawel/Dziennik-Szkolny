package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Teacher;
import chat.Client_GUI_Teacher;
import chat.Server_GUI;
import controller.PushNotification;

public class VirtualMeeting extends JFrame {

	private JPanel contentPane;
	private JSpinner dateSpinner;

	private JButton btnUstalZebranie;
	private JButton btnRozpoczniZebranie;
	
	private   Date date;
	
	
	

	/**
	 * Create the frame.
	 */
	public VirtualMeeting(final Teacher teacher) {
		super("Ustal Zebranie");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 286, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setVisible(true);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.8);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		

		
		
		SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
		
		spinnerDateModel.addChangeListener(new ChangeListener() {
            DateFormat intFormat = new SimpleDateFormat("M");
            DateFormat strFormat = new SimpleDateFormat("MMM");
    		@Override
            public void stateChanged(ChangeEvent e) {
                 date = ((SpinnerDateModel)e.getSource()).getDate();
               
            }

        });
		 dateSpinner = new JSpinner(spinnerDateModel);
		 //EEE,d MMMMMMMM, yyyy , HH:mm  	
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "EEE,d MMMMMMMM, yyyy , HH:mm  ");
		
		dateSpinner.setEditor(dateEditor);
		dateSpinner.setValue(new Date()); 
		panel.add(dateSpinner);
		btnUstalZebranie = new JButton("Ustal Zebranie");
		btnUstalZebranie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("EEE,d MMMMMMMM, yyyy , HH:mm ");
				
				try {
					new PushNotification().sendObject("localhost",dateSpinner.getValue().toString() );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//System.out.println("data to : " + date.toLocaleString());
			}
		});
		
	
		
		
		
		panel.add(btnUstalZebranie);
		
		
		

		
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnRozpoczniZebranie = new JButton("Rozpoczni Zebranie");
		btnRozpoczniZebranie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Server_GUI server_gui= new Server_GUI();
				server_gui.setVisible(true);
				Client_GUI_Teacher CGT = new Client_GUI_Teacher(teacher);
			}
		});
		panel_1.add(btnRozpoczniZebranie);
		
	
	}

}
