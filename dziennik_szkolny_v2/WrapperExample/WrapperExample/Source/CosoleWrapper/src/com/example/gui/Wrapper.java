package com.example.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.example.gui.events.LineRecivedEvent;
import com.example.gui.events.WrapperListener;

public class Wrapper
{
	private String jvmPath = ""; // "C:\\Program Files\\Java\\jre7\\bin"
	private String applicationPath = ""; // sciezka do katalogu z aplikacja
	
	private String combinedPath = jvmPath + "java -jar " + applicationPath + "ConsoleProgram.jar";
	
	private Runtime runtime = Runtime.getRuntime();
	
	protected List<WrapperListener> listeners = new ArrayList<WrapperListener>();
	
	public void addLineRecivedListener( WrapperListener listener )
	{
		this.listeners.add( listener );
	}
	
	public void removeLineRecivedListener( WrapperListener listener )
	{
		this.listeners.remove( listener );
	}
	
	protected void fireProgramStarted()
	{
		Iterator<WrapperListener> items = this.listeners.iterator();
		
		while ( items.hasNext() )
			items.next().programStarted();
	}
	
	protected void fireProgramFailed()
	{
		Iterator<WrapperListener> items = this.listeners.iterator();
		
		while ( items.hasNext() )
			items.next().programFailed();
	}
	
	protected void fireLineRecived( String line )
	{
		LineRecivedEvent event = new LineRecivedEvent( this, line );
		Iterator<WrapperListener> items = this.listeners.iterator();
		
		while ( items.hasNext() )
			items.next().lineRecived( event );
	}
	
	protected void fireProgramFinished()
	{
		Iterator<WrapperListener> items = this.listeners.iterator();
		
		while ( items.hasNext() )
			items.next().programFinished();
	}
	
	public boolean execute( int iterationsCount, int lineSize )
	{
		Process process;
		
		try
		{
			process = this.runtime.exec( this.combinedPath );
		}
		catch ( IOException e )
		{
			this.fireProgramFailed();
			
			return false;
		}
		
		this.fireProgramStarted();
		
		PrintWriter writer = new PrintWriter( process.getOutputStream() );
		Scanner scanner = new Scanner( process.getInputStream() );
		
		try
		{
			this.fireLineRecived( scanner.nextLine() );
			writer.write( iterationsCount + "\n" );
			writer.flush();
			
			this.fireLineRecived( scanner.nextLine() );
			writer.write( lineSize + "\n" );
			writer.flush();
		}
		catch ( NoSuchElementException e )
		{
			scanner.close();
			writer.close();
			
			this.fireProgramFailed();
			
			return false;
		}
		
		try
		{
			process.waitFor();
		}
		catch ( InterruptedException e )
		{
			scanner.close();
			writer.close();
			
			this.fireProgramFailed();
			
			return false;
		}
		
		while ( scanner.hasNextLine() )
		{
			String line = null;
			
			try
			{
				line = scanner.nextLine();
			}
			catch ( NoSuchElementException e )
			{
				scanner.close();
				writer.close();
				
				this.fireProgramFailed();
				
				return false;
			}
			
			if ( line == null )
				break;
			
			this.fireLineRecived( line );
		}
		
		scanner.close();
		writer.close();
		
		this.fireProgramFinished();
		
		return true;
	}
}
