package amusementPark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class IO_DBTicketSales {
	ArrayList<SaveData> savingList;
	Connection conn;
	Statement stmt;
	
	public IO_DBTicketSales(ArrayList<SaveData> savingList) {
		this.savingList = savingList;
	}
	
	public void outToDBSales() throws InterruptedException {
		try {
			Class.forName(SaveData.className);
			conn = DriverManager.getConnection(SaveData.connectDB[0], SaveData.connectDB[1], SaveData.connectDB[2]);
			stmt = conn.createStatement();
			
			
			for (SaveData x: savingList) {
			
				stmt.execute(SaveData.adding + String.format("('%s', '%s', '%s', '%s', '%s', '%s');",
								x.getDate(), 			//now() = if want to use writing time. this program uses saved date and time.
								x.getTicketType().name(), 
								x.getAge().name(), 
								x.getQuantity(), 
								x.getAmount(), 
								x.getDiscount().name()));   
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
