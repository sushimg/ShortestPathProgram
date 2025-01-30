package main;

public class CityNotFoundException extends RuntimeException 
{
	//Constructor
    public CityNotFoundException(String message) 
    {
        super(message);
    }
}