package project.warehouse_manager;

import java.util.Comparator;

public class UnitDataComparator implements Comparator<UnitData> {

	public int compare(UnitData unitData1, UnitData unitData2) {
		return unitData1.getPickUpDate().compareTo(unitData2.getPickUpDate());
	}

}
