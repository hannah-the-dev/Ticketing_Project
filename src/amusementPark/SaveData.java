package amusementPark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SaveData {
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	// save type: numbers, return string 
	private String date; 
	private TicketType ticket_Type;
	private AgeGroup age;
	private int quantity;
	private long amount;
	private Date birthDay;
	private Discount discount;
	private static Date today = Calendar.getInstance().getTime();
	static String adding = "INSERT INTO `ticketing` "
			+ "(`date`, `ticket_type`, `age`, `quantity`, `amount`, `discount`) VALUES "; 
	static String className = "com.mysql.cj.jdbc.Driver";
	static String[] connectDB = {"jdbc:mysql://192.168.23.17:3306/kopoctc", 
									"root",
									"kopoctc"};
	
	public static int[] ID_NUM = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};		// calculates ages 
	
	public TicketType getTicketType() {
		return ticket_Type;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticket_Type = ticketType;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public AgeGroup getAge() {
		return age;
	}

	public void setAge(AgeGroup ageGroup) {
		this.age = ageGroup;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int qty) {
		this.quantity = qty;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String[] getAnyList() {
		String[] anyList = new String[] {
			getDate(),
			getTicketType().name(),
			getAge().name(),
			getQuantity()+"",
			getAmount()+"",
			getDiscount().name()
		};
		return anyList;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String bDay) {
		try {
			this.birthDay = sdf.parse(bDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Date getToday() {
		return today;
	}
}