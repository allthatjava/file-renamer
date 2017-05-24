package org.iceup.app.filerenamer.util;

public class StringUtil 
{
	public static boolean isNullOrEmpty(String input)
	{
		boolean result = false;
		if( input == null )
			result = false;
		else if( input.trim().length() > 0 )
			result = true;
		
		return result;
	}
}
