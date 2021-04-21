package ticketStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class DailySales {
	Connection conn;
	Statement stmt;
	DecimalFormat format = new DecimalFormat("###,###");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	ReadData read = new ReadData();
	public void calDailyAndDc() throws InterruptedException {
		try {
			Class.forName(ReadData.className);
			conn = DriverManager.getConnection(ReadData.connectDB[0], ReadData.connectDB[1], ReadData.connectDB[2]);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			System.out.println();
			ResultSet all_date = stmt.executeQuery("SELECT date, "								//1
					+ "SUM(amount) "
					+ "FROM ticketing GROUP BY date ORDER BY date");
			System.out.println("============== 일자별 매출 현황 ==============");
			while (all_date.next()) {
				System.out.printf("%s: 총매출 %s 원 \n", 
						sdf.format(all_date.getDate("date")), format.format(all_date.getInt(2)));
			}
			System.out.println("----------------------------------------------\n");
			
			ResultSet allDc = stmt.executeQuery("SELECT discount, "								//1
					+ "SUM(quantity) "
					+ "FROM ticketing GROUP BY discount ORDER BY discount");
			int dcTotalQty = 0;
			System.out.println("=========== 우대권 판매 현황 ===========");
			while (allDc.next()) {
				System.out.printf("%-25s: %7d 매 \n", 
						allDc.getString("discount"), allDc.getInt(2));
				dcTotalQty += allDc.getInt(2);
			}
			System.out.printf("%-19s: %7d 매 \n", 
					"총 티켓 판매 수", dcTotalQty);
			System.out.println("----------------------------------------");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
