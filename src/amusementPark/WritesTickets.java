package amusementPark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

public class WritesTickets {
	ArrayList<SaveData> savingList;
	TicketConstant constant = new TicketConstant();
	public BufferedWriter bw = null;
	String dynamicPath = constant.getDirName()+"\\Desktop"+File.separator+constant.getFileName();
	File file = new File(dynamicPath);
	
	public WritesTickets(ArrayList<SaveData> savingList) {
		this.savingList = savingList;
	}
	
	public void writingSales() throws InterruptedException {
		System.out.println(dynamicPath);
		CSVWriter writer;
		while (true) {			// if error, wait 5 sec and try again
			try {
				writer = new CSVWriter(new FileWriter(file, true));
			//writing title
				String[] titleTemp = new String[WritingTitle.values().length];
				if (file.length() < 10) {
					for (WritingTitle x : WritingTitle.values()) {
						titleTemp[x.ordinal()] = x.name();
					}
					writer.writeNext(titleTemp);
				}
				
		//		writing contents
				for(SaveData x: savingList) {
					String[] contentTemp = x.getAnyList();
					writer.writeNext(contentTemp);
				}
				writer.close();
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Another program is using the file. Program will retry in 5 seconds.");
				Thread.sleep(5000);
					
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}