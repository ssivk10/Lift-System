package com.zsgs.liftsystem.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.liftsystem.models.Lift;

public class Database {
	
	static Database database;
	private List<Lift> lift;
	
	private Database() {
		lift = new ArrayList<Lift>();
		Lift li;
		
		for(int i=0;i<5;i++) {
			li = new Lift();
			li.setName("L"+(int)(i+1));
			lift.add(li);
		}
	}
	
	public static Database getInstance() {
		if(database==null) database = new Database();
		return database;
	}
	
	

	public List<Lift> getLift() {
		return lift;
	}

	public void setLift(List<Lift> lift) {
		this.lift = lift;
	}
	
	
}
