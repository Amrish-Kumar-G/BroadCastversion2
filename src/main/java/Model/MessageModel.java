package Model;

public class MessageModel {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private int id;
	private String username;
	private String message;
	public MessageModel(String string, String string2) {
		this.username=string;
		this.message=string2;
	}
	public MessageModel(int int1,String string, String string2) {
		this.id=int1;
		this.username=string;
		this.message=string2;
	}
}
