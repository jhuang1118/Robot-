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
		String[] temp1 = {"rate", "opinion of", "think of", "think about", "personal thoughts about"};
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
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1){
			for(int i = 0; i < keywords.length; i++) {
				if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
					ChatbotMain.print("A new restaurant worthy of my criticism? What is it?");
					String place = ChatbotMain.getInput();
					rateLocation(place);
				}
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
		
		ChatbotMain.print("Where in the world is " + place + "?");
		String location = ChatbotMain.getInput().toLowerCase();
		ChatbotMain.print("What does " + place + " specialize in?");
		String mainComp =  ChatbotMain.getInput().toLowerCase();
		
		for(int i = 0; i < ingredients.length; i++) {
			for(int j = 0; j < ingredients[i].length; i++) {
				if(mainComp.equals(ingredients[i][j])) {
					
				}
			}
		}
		
		System.out.print("");
	}
		
}
