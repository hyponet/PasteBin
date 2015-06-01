package net.ihypo.code;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import net.ihypo.db.CodeDrive;

public class Code {
	private long id;
	private String name;
	private String title;
	private String lang;
	private Timestamp time;
	private String content;
	
	private String clear(StringBuffer content){
		int index = -1;
		while((index = content.indexOf("<")) != -1){
			content.replace(index,index + 1, "&lt;");
		}
		while((index = content.indexOf(">")) != -1){
			content.replace(index,index + 1, "&gt;");
		}
		return content.toString();
	}
	
	public Code(String name,String title,String lang,String content) throws ClassNotFoundException, SQLException{
		this.id = CodeDrive.getNextId();
		this.name = clear(new StringBuffer(name));
		this.title = clear(new StringBuffer(title));
		this.lang = lang;
		this.content = clear(new StringBuffer(content));
		Calendar calendar = Calendar.getInstance();
		time = new Timestamp(calendar.getTimeInMillis());
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getLang() {
		return lang;
	}
	
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public String getTime(){
		return time.toLocaleString();
	}
	
	public Timestamp getTimestamp(){
		return time;
	}
	
	public String getContent(){
		return content;
	}
}
