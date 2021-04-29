package ticketStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class From_DBTicketSales {
	static String adding = "INSERT INTO `ticketing` "
			+ "(`date`, `ticket_type`, `age`, `quantity`, `amount`, `disocunt`) VALUES "; 
	static String className = "com.mysql.cj.jdbc.Driver";
	static String[] connectDB = {"jdbc:mysql://127.0.0.1:3306/testdb", 
									"root",
									"99164123"};
	Connection conn;
	Statement stmt;
	DecimalFormat format = new DecimalFormat("###,###");
	ResultSet rAll;
	
	public ResultSet getFromDBSales() throws InterruptedException {
		try {
			Class.forName(ReadData.className);
			conn = DriverManager.getConnection(ReadData.connectDB[0], ReadData.connectDB[1], ReadData.connectDB[2]);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rAll = stmt.executeQuery("SELECT * FROM `ticketing`");
			System.out.println("=============================== report ===============================");
			while (rAll.next()) {
				System.out.printf("%3d: %16.16s %-10s %-10s %2s %8s  %-12s\n", 
						rAll.getRow(), 
						rAll.getString("date"),
						rAll.getString("ticket_type"),
						rAll.getString("age"),
						rAll.getString("quantity"),
						format.format(rAll.getInt("amount")),
						rAll.getString("discount"));
			}
			System.out.println("----------------------------------------------------------------------");
			ResultSet all_age = stmt.executeQuery("SELECT age, "								//1
					+ "SUM(CASE WHEN ticket_type = 'DAYTIME' THEN quantity ELSE 0 END), "		//2
					+ "SUM(CASE WHEN ticket_type = 'DAYTIME' THEN amount ELSE 0 END), "			//4
					+ "SUM(CASE WHEN ticket_type = 'NIGHTTIME' THEN quantity ELSE 0 END), "		//3
					+ "SUM(CASE WHEN ticket_type = 'NIGHTTIME' THEN amount ELSE 0 END) "
					+ "FROM ticketing GROUP BY age ORDER BY age");
			int dayTotalQty = 0;
			int dayTotalAmt = 0;
			int nightTotalQty = 0;
			int nightTotalAmt = 0;
			System.out.println("===================== 권종 별 판매 현황 =====================");
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
			System.out.println("-------------------------------------------------------------");
			
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rAll;
	}
}
