package com.example.gui.events;

import java.util.EventListener;

public interface WrapperListener extends EventListener
{
	public void programStarted();
	
	public void programFailed();
	
	public void lineRecived( LineRecivedEvent e );
	
	public void programFinished();
}
