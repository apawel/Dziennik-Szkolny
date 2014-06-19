package com.example.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GuiProgram
{
	public static void main( String[] args )
	{
		EventQueue.invokeLater( new Runnable()
		{
			@Override
			public void run()
			{
				MainFrame frame = new MainFrame();
				
				frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				frame.setSize( 640, 480 );
				frame.setVisible( true );
			}
		} );
	}
}
