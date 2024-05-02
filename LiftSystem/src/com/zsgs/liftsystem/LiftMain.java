package com.zsgs.liftsystem;

import com.zsgs.liftsystem.liftaccess.LiftView;

public class LiftMain {
	
	private static LiftMain liftMain;
	
	private LiftMain() {
		
	}
	
	public static LiftMain getInstance() {
		if(liftMain==null) liftMain = new LiftMain();
		return liftMain;
	}

	public static void main(String[] args) {
		LiftMain.getInstance().onInit();
	}
	
	public void onInit() {
		LiftView liftView = new LiftView();
		liftView.setCapacity();
	}

}
