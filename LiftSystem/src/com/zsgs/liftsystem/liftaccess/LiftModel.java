package com.zsgs.liftsystem.liftaccess;

import java.util.List;

import com.zsgs.liftsystem.datalayer.Database;
import com.zsgs.liftsystem.models.Lift;

public class LiftModel {

	LiftView liftView;
	Database database = Database.getInstance();

	LiftModel(LiftView liftView) {
		this.liftView = liftView;
	}

	void liftCurrent() {
		List<Lift> lift = database.getLift();
		for (Lift l : lift) {
			liftView.alertSameLine(l.getName());
		}
		liftView.alert("");
		for (Lift l : lift) {
			liftView.alertSameLine(l.getCurrent() + "");
		}
		liftView.alert("");
	}

	void setCapacity() {
		List<Lift> l = database.getLift();
		for (int i = 0; i < 5; i++) {
			liftView.alert("Enter capacity for lift: " + l.get(i).getName());
			int c = liftView.getData();
			l.get(i).setCapacity(c);
		}
	}

	void travel(int from, int to) {
		List<Lift> lift = database.getLift();
		int max = Math.abs(from - lift.get(4).getCurrent());
		int stops = Integer.MAX_VALUE;
		int cap = 0;
		Lift assigned = lift.get(4);
		for (int i = lift.size() - 1; i >= 0; i--) {
			Lift l = lift.get(i);
			if (l.getCapacity() != 0)
				cap++;
			else
				continue;
			if (l.getName().equals("L3") || l.getName().equals("L4")) {
				if ((from <= 5 && from >= 1) || (to <= 5 && to >= 1))
					continue;
				if (l.getCurrent() != 0) {
					if (to == 0 && l.getCurrent() - 5 < lift.get(4).getCurrent()) {
						if (l.getCurrent() - 5 < stops) {
							stops = l.getCurrent() - 5;
							assigned = l;
							continue;
						}
					}
				}
			}

			if (l.getName().equals("L1") || l.getName().equals("L2")) {
				if (from >= 6 || to >= 6) {
					continue;
				}
			}

			if (Math.abs(from - l.getCurrent()) < max) {
				assigned = l;
				max = Math.abs(from - l.getCurrent());
			} else if (Math.abs(from - l.getCurrent()) == max) {
				if (to < from && from < l.getCurrent()) {
					assigned = l;
					max = Math.abs(from - l.getCurrent());
				} else if (to > from && from > l.getCurrent()) {
					assigned = l;
					max = Math.abs(from - l.getCurrent());
				}
			}
		}
		if (cap != 5) {
			assigned.setCurrent(to);
			liftView.alert(assigned.getName() + " is assigned. ");
			assigned.setCapacity(assigned.getCapacity()-1);
			liftView.onInit();
		} else {
			liftView.alert("All lifts are overloaded.");
		}
	}

}
