package chatbot;

public class FoodReply {
	private String location;
	private String food;
	private String reply;
	
	public FoodReply(String l, String f , String r) {
		location = l;
		food = f;
		reply = r;
	}

	public String getLocation() {
		return location;
	}

	public String getFood() {
		return food;
	}

	public String getReply() {
		return reply;
	}
}
