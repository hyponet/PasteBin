package net.ihypo.code;

import java.sql.Timestamp;
import java.util.Calendar;

public class Code {
	private int id;
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
	
	public Code(String name,String title,String lang,String content){
		this.id = 1;
		this.name = clear(new StringBuffer(name));
		this.title = clear(new StringBuffer(title));
		this.lang = lang;
		this.content = clear(new StringBuffer(content));
		Calendar calendar = Calendar.getInstance();
		time = new Timestamp(calendar.getTimeInMillis());
	}
	
	public static Code getCode(long id){
		
		return null;
	}
	
	public int getId(){
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
	
	public String getTime(){
		return time.toString();
	}
	
	public Timestamp getTimestamp(){
		return time;
	}
	
	public String getContent(){
		return content;
	}
}
