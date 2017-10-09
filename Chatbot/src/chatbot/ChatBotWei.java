package chatbot;

public class ChatBotWei implements Topic {
	private String[] keywords;
	private String[][] ingredients;
	private String[] locations;
	
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String lastLocation;
	private String lastMainComp;
	private String mainComponent;

	public ChatBotWei() {
		String[] temp1 = {"rate","your opinion", "opinion of", "think of", "think about", "your personal thoughts about"};
		String[] temp0 = {"london", "sydney", "new york", "los angeles", "seoul", "berlin", "paris", "tokyo"};
		String[] rice = {"fried", "stirred", "white", "brown", "yellow"};
		String[] snacks = {"oreo", "chips", "pretzel", "m&m", "sprinkles", "icing"};
		String[] meat = {"salmon", "chicken", "tuna", "pork", "spare ribs", "lamb"};
		String[] dairy = {"milk", "cheese", "yogurt", "ice cream"};
		String[] veggies = {"carrots", "spinach", "broccoli", "cauliflower", "basil"};
		String[] fruits = {"apples", "oranges"};
		String[] flavoring  = {"salt", "pepper", "soy sauce", "vinegar"};
		String[][] temp2 = {meat, dairy, veggies, fruits, flavoring, rice, snacks};
		
		keywords = temp1;
		ingredients = temp2;
		locations = temp0;
		goodbyeKeyword = "bye";
		secretKeyword = "roast";
		lastLocation = "";
		lastMainComp = "";
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
			
			ChatbotMain.print("Anything else that you would like me to criticize, " + "?");
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
		int rating = 5;
		
		ChatbotMain.print("Where in the world is " + place + "?");
		String location = ChatbotMain.getInput().toLowerCase();
		ChatbotMain.print("What does " + place + " specialize in?");
		String mainComp =  ChatbotMain.getInput().toLowerCase();
		
		for(int j = 0; j < ingredients.length; j++) {
			for(int k = 0; k < ingredients[j].length; k++) {
				
			}
		}
		
		if(detectDuplicate(location, mainComp)) {
			if(location.equals("london")) {
				if(mainComp.equals("milk")) {
					Chatbot.getAngry();
					ChatbotMain.print("You idiot, didn't I tell you that you don't f**ing dine milk in London?!");
				}
			}
			else if(location.equals("berlin")) {
				
			}
			else if(location.equals("seoul")) {
				
			}
		}
		
		if(location.equals("london")){
			if(mainComp.equals("fish")){
				Chatbot.calmDown(3);
				ChatbotMain.print("That's rich, "+ Chatbot.getUsername()  + ", fish in London is a delicacy Perhaps I'll go to " + place + "next time I go to London.");
			}
			else if (mainComp.equals("milk")){
				rating -= 3;
				ChatbotMain.print("What are you doing with your life? Milk in London is garbage");
			}
			else{
				rating -= 2;
				Chatbot.calmDown(2);
				ChatbotMain.print("Really? People in London can actually make GOOD things out of " + mainComp + "?");
			}
				
		}
		else if(location.equals("seoul")) {
			if(mainComp.equals("")) {
				
			}
		}
		else if(location.equals("berlin")) {
			if(mainComp.equals("")) {
				
			}
			
		}
		else if(location.equals("new york")) {
			if(mainComp.equals("")) {
				
			}
			else if(mainComp.equals("")) {
				
			}
		}
		else {
			rating = 0;
			ChatbotMain.print("If I've never been there, then the food there's gotta be pretty f**ing sh*tty.");
		}
		ChatbotMain.print("Overall, I would give " + place + " a " + rating + " out of 5 rating.");
	}
	
	public boolean detectDuplicate(String location, String mainComp) {
		return location.toLowerCase().equals(lastLocation) && mainComp.toLowerCase().equals(lastMainComp);
	}
		
}
