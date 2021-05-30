package ticketStats;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;

public class WritingConstant {
	private String dirName = System.getProperty("user.home");
	private String fileName;
	
	private String dynamicPath;

	private File file;
	
	static String adding = "INSERT INTO `ticketing` "
			+ "(`date`, `ticket_type`, `age`, `quantity`, `amount`, `disocunt`) VALUES "; 
	static String className = "com.mysql.cj.jdbc.Driver";
	static String[] connectDB = {"jdbc:mysql://192.168.23.17:3306/kopoctc", 
								"root",
								"kopoctc"};
	Connection conn;
	Statement stmt;
	
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirPath) {
		this.dirName = dirPath;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName + "_" + Calendar.getInstance().getTime().getTime() + ".csv";
	}

	public String setDynamicPath() {
		this.dynamicPath = getDirName()+File.separator+"Desktop"+File.separator+getFileName();
		return dynamicPath;
	}

	public File setFile() {
		this.file = new File(setDynamicPath());
		return file;
	}
}
