package chatbot;

public class ChatBotWei implements Topic {
	
	private String[] keywords;
	private String[][] ingredients;
	private String[] locations;
	
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String mainComponent;
	private String lastLocation;

	public ChatBotWei() {
		String[] temp1 = {"rate this", "opinion of", "think of", "think about", "personal thoughts about"};
		String[] temp0 = {"london", "sydney", "new york", "los angeles", "seoul", "berlin", "paris", "tokyo"};
		String[] meat = {"salmon", "chicken", "tuna", "pork", "spare ribs", "lamb", ""};
		String[] dairy = {"milk", "cheese", "yogurt", "ice cream"};
		String[] veggies = {"carrots", "spinach", "broccoli", "cauliflower", "basil"};
		String[] fruits = {"apples", "oranges"};
		String[] flavoring  = {"salt", "pepper", "soy sauce", "vinegar"};
		String[][] temp2 = {meat, dairy, veggies, fruits, flavoring};
		
		keywords = temp1;
		ingredients = temp2;
		locations = temp0;
		goodbyeKeyword = "bye";
		secretKeyword = "roast";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Whatever you're asking me to rate, it's probably not going to be good as my restaurant and dishes!");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1){
			for(int i = 0; i < response.length(); i++) {
				
			}
		}
		//access variables from other classes
		
		ChatbotMain.chatbot.startChatting();
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	public void rateLocation(String place) {
		//will take in an array with a bunch of ingredients jumbled together
		int rating = 5;
		
		System.out.print("");
		String location = ChatbotMain.getInput();
		
		for(int i = 0; i < locations.length; i++) {
			if(locations[i].equals(location)) {
				String main = ChatbotMain.
			}		
		}
		
		System.out.print("stuff to say when done with loop");
	}
		
}
