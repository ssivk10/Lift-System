package com.zsgs.liftsystem.liftaccess;

import java.util.Scanner;

public class LiftView {
	
	LiftModel liftModel;
	Scanner sc = new Scanner(System.in);

	public LiftView() {
		this.liftModel = new LiftModel(this);
	}
	
	public void setCapacity() {
		System.out.println("Enter the capacity for each of the lifts: ");
		liftModel.setCapacity();
		onInit();
	}
	
	public void onInit() {
		
		System.out.println("--------------------------------------------------------");
		System.out.println("This is the lift: ");
		liftModel.liftCurrent();
		System.out.println("--------------------------------------------------------");
		System.out.println("What would you like to do?\n1. Use Lift\n2. Terminate\nEnter your choice: ");
		int ch = sc.nextInt();
		sc.nextLine();
		switch(ch) {
		case 1:
			go();
			break;
		case 2:
			System.out.println("Thank you!");
			break;
		case 3:
			
			break;
		default: 
			System.out.println("Invalid input.");
			onInit();
		}
	}
	
	void go() {
		System.out.println("Enter current floor: ");
		int from;
		do {
			from = sc.nextInt();
		}while(from<0 || from>10);
		System.out.println("Enter destination: ");
		int to ;
		do {
			to = sc.nextInt();
			if(to==from) System.out.println("You are on the same floor as your destination.");
			if(to<0 || to>10) System.out.println("Invalid floor number.");
		}while(to==from || to<0 || to>10);
		
		liftModel.travel(from, to);
	}
	
	public void alert(String s) {
		System.out.println(s);
	}
	
	public int getData() {
		int x = sc.nextInt();
		return x;
	}
	
	public void alertSameLine(String s) {
		System.out.printf("| %-2s |",s);
	}
}
