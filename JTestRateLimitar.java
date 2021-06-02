package com.cognizant.swift.processchef.webhelper;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class JTestRateLimitar
{
	@Test
	public void testvalidateReasonCode()
	{
		try
		{ 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date w_date = new Date();
		    System.out.println("starttime:" +w_date);
		    System.out.println(formatter.format(w_date));  
		   
			long w_startTime = w_date.getTime();
			int w_startTimeIcSec = (int) System.currentTimeMillis();
			for(int i=1; i<6; i++)
			{
				rateLimiter2(i,w_startTime);
				Thread.sleep(1000);
			}
			Date w_date2 = new Date();
			System.out.println("endtime: "+w_date2);
		}
		catch (Exception a_ex) 
		{
			assertFalse(a_ex.getMessage(), true);
		}
	}
	
	public static void rateLimiter2(int a_reqcount, long a_startTime) throws InterruptedException
	{
		int w_hitCount = 0;
		int w_count = 0;
		int w_nonHitCount = 0;
		boolean w_isMaxLimitReached =  false;
		                          
		Date w_date = new Date();
		long w_currenttime = w_date.getTime();
		//long w_startTime1 = w_startTime;
		int currentimeInSec = (int) System.currentTimeMillis();
		
	
		if((w_currenttime - a_startTime) <= 3000L)
		{
			if (w_count < 3)
			{
				w_count++;
				System.out.println("Called for count: " + a_reqcount );
			}
			else
			{
				System.out.println(w_currenttime - a_startTime);
				Thread.sleep(3000L - (w_currenttime - a_startTime));
				System.out.println("MaxLimitReached");
			}
		}
		else 
		{
			
		}
	}
}
