package ticketStats;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.opencsv.CSVWriter;

public class WritesStats {
	WritingConstant constant = new WritingConstant(); 
	public BufferedWriter bw = null;

	public void dailySales() throws InterruptedException {  // gets amount by date
		String query = "SELECT date, SUM(amount) FROM ticketing GROUP BY date ORDER BY date";
		write("DailySales", query, "Date", "Revenue");
	}
	
	public void ageSales() throws InterruptedException {    // gets amount by age groups
		String query = "SELECT age, SUM(amount) FROM ticketing GROUP BY age ORDER BY age";
		write("AgeSales", query, "Age", "Revenue");
	}
	
	public void ageSalesByTime() throws InterruptedException {  // gets amount age & ticket type
		String query = "SELECT age, "
				+ "SUM(CASE WHEN ticket_type = 'DAYTIME' THEN amount ELSE 0 END), "
				+ "SUM(CASE WHEN ticket_type = 'NIGHTTIME' THEN amount ELSE 0 END) "
				+ "FROM ticketing GROUP BY age ORDER BY age";
		write("AgeByTimeSales", query, "Age", "Day", "Night");
	}
	
	public void discountSalesByTime() throws InterruptedException {  // gets amount by discount options
		String query = "SELECT discount, "
				+ "SUM(CASE WHEN ticket_type = 'DAYTIME' THEN amount ELSE 0 END), "
				+ "SUM(CASE WHEN ticket_type = 'NIGHTTIME' THEN amount ELSE 0 END) "
				+ "FROM ticketing GROUP BY discount ORDER BY discount";
		write("DiscountByTimeSales", query, "Discount", "Day", "Night");
	}
	// takes information needed from database and writes to csv files 
	// various number of title can be adopted but needs to be consistent with the query statement 
	public void write(String filename, String query, String... titles) throws InterruptedException {
		constant.setFileName(filename);	
		constant.setDynamicPath();			// set the file path dynamically
		System.out.println(constant.setDynamicPath());
		CSVWriter writer;
		while (true) {			// if error, wait 5 sec and try again
			try {
				writer = new CSVWriter(new FileWriter(constant.setFile(), false));
				writer.writeNext(titles);		// Variadic arguments is naturally in array
				Class.forName(ReadData.className);
				constant.conn = DriverManager.getConnection(
						ReadData.connectDB[0], ReadData.connectDB[1], ReadData.connectDB[2]);
				constant.stmt = constant.conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
				ResultSet result = constant.stmt.executeQuery(query);	
				String[] contentTemp = new String[titles.length];
				//		writing contents
				for (String x: titles)
					System.out.printf("    %-11.11s ", x);
				while(result.next()) {
					contentTemp[0] = result.getString(1);
					for (int i = 2; i <= titles.length; i++) {
						contentTemp[i-1] = result.getString(i);
						}
					System.out.println();
					for (String y: contentTemp)
						System.out.printf("%15.15s ", y);
					writer.writeNext(contentTemp);
				}
				System.out.println();
				System.out.println();
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
