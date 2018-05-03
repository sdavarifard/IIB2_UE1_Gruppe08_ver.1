package Beans;

public class Täetigkeit {
   private int tätigkeit_id;
   private String tätigkeit_name;
   
	public Täetigkeit(int tätigkeit_id, String tätigkeit_name) {
	super();
	this.tätigkeit_id = tätigkeit_id;
	this.tätigkeit_name = tätigkeit_name;
}

	public Täetigkeit() {
		// TODO Auto-generated constructor stub
	}

	public int getTätigkeit_id() {
		return tätigkeit_id;
	}

	public void setTätigkeit_id(int tätigkeit_id) {
		this.tätigkeit_id = tätigkeit_id;
	}

	public String getTätigkeit_name() {
		return tätigkeit_name;
	}

	public void setTätigkeit_name(String tätigkeit_name) {
		this.tätigkeit_name = tätigkeit_name;
	}

}
