package com.example.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.example.gui.events.LineRecivedEvent;
import com.example.gui.events.WrapperListener;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 8987048222781457033L;
	
	private Wrapper wrapper = new Wrapper();
	
	private void addOutput( JPanel pnlContainer )
	{
		JScrollPane scrollPane = new JScrollPane();
		
		final JTextArea txtOutput = new JTextArea();
		txtOutput.setBackground( Color.black );
		txtOutput.setForeground( Color.white );
		txtOutput.setEditable( false );
		
		this.wrapper.addLineRecivedListener( new WrapperListener()
		{
			@Override
			public void programStarted()
			{
				txtOutput.setText( "" );
			}
			
			@Override
			public void programFailed()
			{
				JOptionPane.showMessageDialog( null, "Execution error." );
			}
			
			@Override
			public void lineRecived( LineRecivedEvent e )
			{
				txtOutput.append( e.getLine() + "\n" );
			}
			
			@Override
			public void programFinished()
			{
				JOptionPane.showMessageDialog( null, "Execution completed." );
			}
		} );
		
		scrollPane.setViewportView( txtOutput );
		
		pnlContainer.add( scrollPane, BorderLayout.CENTER );
	}
	
	private void addControls( JPanel pnlContainer )
	{
		JPanel pnlControl = new JPanel();
		pnlControl.setLayout( new GridLayout( 1, 3 ) );
		
		final JComboBox<Object> cbxIterationsCount = new JComboBox<Object>( new Object[] { "1 iteration", "2 iterations", "3 iterations" } );
		pnlControl.add( cbxIterationsCount );
		
		final JComboBox<Object> cbxLineSize = new JComboBox<Object>( new Object[] { "Line size = 1", "Line size = 2", "Line size = 3" } );
		pnlControl.add( cbxLineSize );
		
		JButton btnProgramRun = new JButton();
		btnProgramRun.setText( "Run" );
		btnProgramRun.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent arg0 )
			{
				int iterationsCount = cbxIterationsCount.getSelectedIndex() + 1;
				int lineSize = cbxLineSize.getSelectedIndex() + 1;
				
				MainFrame.this.wrapper.execute( iterationsCount, lineSize );
			}
		} );
		pnlControl.add( btnProgramRun );
		
		pnlContainer.add( pnlControl, BorderLayout.SOUTH );
	}
	
	public MainFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );
		
		this.addOutput( panel );
		this.addControls( panel );
		
		this.add( panel );
	}
}
