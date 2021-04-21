package ticketStats;

public class ReadData {
	public static final String adding = "INSERT INTO `ticketing` "
			+ "(`date`, `ticket_type`, `age`, `quantity`, `amount`, `disocunt`) VALUES "; 
	public static final String className = "com.mysql.cj.jdbc.Driver";
	public static final String[] connectDB = {"jdbc:mysql://127.0.0.1:3306/testdb", 
									"root",
									"99164123"};
}
