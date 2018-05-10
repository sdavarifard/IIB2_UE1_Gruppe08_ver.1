package Beans;

import java.time.LocalDate;

public class Message {
	private int message_id;
	private LocalDate message_datum;
	private String message_text;
	private int message_user_id;
	private int message_flag;
	
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public LocalDate getMessage_datum() {
		return message_datum;
	}
	public void setMessage_datum(LocalDate message_datum) {
		this.message_datum = message_datum;
	}
	public String getMessage_text() {
		return message_text;
	}
	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}
	public int getMessage_user_id() {
		return message_user_id;
	}
	public void setMessage_user_id(int message_user_id) {
		this.message_user_id = message_user_id;
	}
	public int getMessage_flag() {
		return message_flag;
	}
	public void setMessage_flag(int message_flag) {
		this.message_flag = message_flag;
	}


}
