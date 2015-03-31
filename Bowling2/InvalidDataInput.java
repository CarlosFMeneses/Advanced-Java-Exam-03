/*
Carlos F. Meneses
03/30/2015
Bergen Community College
Advanced Java Programming

Exam 3, Part 2
*/
/**
InvalidDataInput.java: Creates excpetion class for Bowling2.java
*/

public class InvalidDataInput extends Exception
{
	public InvalidDataInput()
	{
		super("Invalid score. Please try again...");
	}

}
