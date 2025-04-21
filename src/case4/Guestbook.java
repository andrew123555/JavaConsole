package case4;

import java.util.Date;

public class Guestbook {
	
	private String message;
	private Date date;
	
	public Guestbook(String message  ) {
		
		this.message = message;
		this.date = new Date();
		
	}

	/**
	 * @return the userName
	 */
	public String getmessage() {
		return message;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Guestbook [message=" + message + ", date=" + date + "]";
	}
	

}
