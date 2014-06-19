package com.example.console;

import java.util.Scanner;

public class ConsoleProgram
{
	private static Scanner scanner = new Scanner( System.in );
	
	private static int readInt()
	{
		int number = scanner.nextInt();
		scanner.nextLine();
		
		return number;
	}
	
	public static void main( String[] args )
	{
		System.out.println("Type number of iterations:");
		int iterationsCount = readInt();
		
		System.out.println("Type line size:");
		int lineSize = readInt();
		
		for ( int i = 0; i < iterationsCount; ++i )
		{
			for ( int j = 0; j < lineSize; ++j )
				System.out.print( "x" );
			
			System.out.println();
		}
	}
}
