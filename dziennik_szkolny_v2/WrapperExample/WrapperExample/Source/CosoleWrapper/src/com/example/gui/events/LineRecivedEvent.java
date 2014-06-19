package com.example.gui.events;

import java.util.EventObject;

public class LineRecivedEvent extends EventObject
{
	private static final long serialVersionUID = 3981931296236920795L;
	
	private String line;
	
	public LineRecivedEvent( Object source, String line )
	{
		super( source );
		this.line = line;
	}
	
	public String getLine()
	{
		return this.line;
	}
}
