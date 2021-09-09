package control;

import java.util.ArrayList;
import java.util.List;

import entity.BillRecords;
import entity.Orders1;

public class GetListForStatistics {

	public static List<Orders1> listForOrders = new ArrayList<>();
	public static List<BillRecords> listFoRecords = new ArrayList<>();

	public static List<Orders1> getListForOrders() {
		return listForOrders;
	}

	public static void setListForOrders(List<Orders1> listForOrders) {
		GetListForStatistics.listForOrders = listForOrders;
	}

	public static List<BillRecords> getListFoRecords() {
		return listFoRecords;
	}

	public static void setListFoRecords(List<BillRecords> listFoRecords) {
		GetListForStatistics.listFoRecords = listFoRecords;
	}

}
