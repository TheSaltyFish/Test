package com.runoob.test;

import java.util.*;

public class IntegerTest {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args)
	{
		try 
		{
			//int x = in.nextInt();
		}
		catch(InputMismatchException e) 
		{
			System.out.println("false!");
			throw e;
		}
		catch(Exception e) 
		{
			System.out.println("....");
			throw e;
		}
		finally
		{
			System.out.println("???");
		}
	}
}