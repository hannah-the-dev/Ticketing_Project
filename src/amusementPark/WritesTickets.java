package amusementPark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

public class WritesTickets {
	ArrayList<ArrayList<Object>> savingList;
	TicketConstant constant = new TicketConstant();
	public BufferedWriter bw = null;
	File file = new File(constant.getFilePath());
	public WritesTickets(ArrayList<ArrayList<Object>> savingList) {
		this.savingList = savingList;
	}
	public void writingSales() throws Exception	{
//		writing title -> change to csv writer instead of print
		CSVWriter writer = new CSVWriter(new FileWriter(file, true));			
		//writing title
		String[] titleTemp = new String[WritingTitle.values().length];
		if (file.length() < 10) {
			for (WritingTitle x : WritingTitle.values()) {
				titleTemp[x.ordinal()] = x.name();
			}
			writer.writeNext(titleTemp);
		}
		
//		writing contents
		for(ArrayList<Object> x: savingList) {					
			String[] contentTemp = new String[WritingTitle.values().length];
			x.forEach((y) -> {
				contentTemp[x.indexOf(y)] = y+""; 
			}) ;
			writer.writeNext(contentTemp);
			}
		writer.close();
	}
}
