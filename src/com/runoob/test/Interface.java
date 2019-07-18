package com.runoob.test;

interface Animal{
	public void eat();
	public void travel();
}
public class Interface implements Animal{
	public void eat(){
	    System.out.println("Mammal eats");
	}
	 
	public void travel(){
	    System.out.println("Mammal travels");
	} 
	 
	public int noOfLegs(){
	    return 0;
	}
	 
	public static void main(String args[]){
		Interface m = new Interface();
	    m.eat();
	    m.travel();
	}
}