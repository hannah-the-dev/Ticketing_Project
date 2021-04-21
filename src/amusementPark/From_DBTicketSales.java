package amusementPark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class From_DBTicketSales {
	public static void main(String[] args) throws InterruptedException {
		getDBSales get = new getDBSales();
		get.getFromDBSales();
	}
}
class getDBSales {
	Connection conn;
	Statement stmt;
	DecimalFormat format = new DecimalFormat("###,###");
	
	public void getFromDBSales() throws InterruptedException {
		try {
			Class.forName(SaveData.className);
			conn = DriverManager.getConnection(SaveData.connectDB[0], SaveData.connectDB[1], SaveData.connectDB[2]);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			
			ResultSet rAll = stmt.executeQuery("SELECT * FROM `ticketing`");
			while (rAll.next()) {
				System.out.printf("%3d: %16.16s %-10s %-10s %2s %8s %12s\n", 
						rAll.getRow(), 
						rAll.getString("date"),
						rAll.getString("ticket_type"),
						rAll.getString("age"),
						rAll.getString("quantity"),
						format.format(rAll.getInt("amount")),
						rAll.getString("disocunt"));
			}
//			ResultSet rAmount = stmt.executeQuery("SELECT SUM(amount) FROM `ticketing`");
//			if (rAmount.next())
//				System.out.println("Sum amount is: " + format.format(rAmount.getLong(1)));
//			//stats of daytime tickets
//			ResultSet daySum = stmt.executeQuery("SELECT SUM(quantity) FROM `ticketing` WHERE ticket_type=\"DAYTIME\"");
//			if (daySum.next())
//				System.out.println("Day ticket count is: " + format.format(daySum.getLong(1)));
//			ResultSet day_age = stmt.executeQuery("SELECT * FROM `ticketing` WHERE ticket_type=\"DAYTIME\" GROUP BY `age`;");
//			while (day_age.next()) {
//				System.out.printf("%s %s, ", day_age.getString("age"), day_age.getString("quantity"));
//			}
			System.out.println();
//			ResultSet night_age = stmt.executeQuery("SELECT * FROM `ticketing` WHERE ticket_type=\"NIGHTTIME\" GROUP BY age;");
			ResultSet all_age = stmt.executeQuery("SELECT age, "					//1
					+ "SUM(CASE WHEN ticket_type = 'DAYTIME' THEN quantity ELSE 0 END), "		//2
					+ "SUM(CASE WHEN ticket_type = 'DAYTIME' THEN amount ELSE 0 END), "			//4
					+ "SUM(CASE WHEN ticket_type = 'NIGHTTIME' THEN quantity ELSE 0 END), "		//3
					+ "SUM(CASE WHEN ticket_type = 'NIGHTTIME' THEN amount ELSE 0 END) "
					+ "FROM ticketing GROUP BY age ORDER BY age");
			// SELECT SUM(CASE WHEN ticket_type = \'NIGHTTIME\' THEN quantity ELSE 0 END) FROM ticketing GROUP BY age;
			int dayTotalQty = 0;
			int dayTotalAmt = 0;
			int nightTotalQty = 0;
			int nightTotalAmt = 0;
			while (all_age.next()) {
				System.out.printf("%s %d  ", all_age.getString("age"), all_age.getInt(2));
				dayTotalQty += all_age.getInt(2);
				dayTotalAmt += all_age.getDouble(3);
			}
			System.out.println();
			System.out.println("주간권 수량: "+dayTotalQty+"원");
			System.out.println("주간권 금액 합계: "+dayTotalAmt+"원");
			System.out.println();
			all_age.beforeFirst();
			while (all_age.next()) {
				System.out.printf("%s %d  ", all_age.getString("age"), all_age.getInt(4));
				nightTotalQty += all_age.getInt(4);
				nightTotalAmt += all_age.getDouble(5);
			}
			System.out.println();
			System.out.println("야간권 수량: "+nightTotalQty+"원");
			System.out.println("야간권 금액 합계: "+nightTotalAmt+"원");
			
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
