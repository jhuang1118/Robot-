package chatbot;

public class ChatBotWei implements Topic {
	private String[] keywords;
	private String[][] ingredients;
	private String[] locations;
	
	private String goodbyeKeyword;
	private String response;
	private String lastLocation;
	private String lastMainComp;
	private String lastPlace;
	private String mainComponent;
	private Topic johnson;
	private int rating;
	

	public ChatBotWei() {
		String[] temp1 = {"rate","your opinion", "opinion of", "think of", "think about", "your personal thoughts about"};
		String[] temp0 = {"london", "sydney", "new york", "los angeles", "seoul", "berlin", "paris", "tokyo"};
		
		
		keywords = temp1;
		locations = temp0;
		goodbyeKeyword = "no";
		lastLocation = "";
		lastMainComp = "";
		response = "";
		
	}

	@Override
	public void talk(String response) {
		johnson = Chatbot.getJohnson();
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1 && Chatbot.angerLvl < 15){
			for(int i = 0; i < keywords.length; i++) {
				if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
					ChatbotMain.print("A new restaurant worthy of my criticism? What is it?");
					String place = ChatbotMain.getInput();
					rateLocation(place);
					break;
				}
			}
			
			ChatbotMain.print("Anything else that you want, " + Chatbot.getUsername() + "? (y/n/ other keywords)");
			response = ChatbotMain.getInput().toLowerCase();
			
			if(response.equals("no")) {
				ChatbotMain.print("bye");
				System.exit(0);
			}
			else if(Chatbot.getTristan().isTriggered(response)) {
				Chatbot.getTristan().talk(response);
			}
			else {
				
			}
		}
		//access variables from other classes
		
		if(Chatbot.angerLvl >= 15) {
			ChatbotMain.print("There's no point in having a conversation if you're not going to listen to what I say.");
			System.exit(0);
		}
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
		rating = 5;
		
		ChatbotMain.print("Where in the world is " + place + "?");
		String location = ChatbotMain.getInput().toLowerCase();
		ChatbotMain.print("What does " + place + " specialize in?");
		String mainComp =  ChatbotMain.getInput().toLowerCase();
		
		if(detectDuplicate(location, mainComp)) {
			if(location.equals("london")) {
				if(mainComp.equals("milk")) {
					Chatbot.getAngry();
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					ChatbotMain.print("You idiot, didn't I tell you that you don't f**ing dine milk in London?!");
					adjustRating(location, mainComp);
				}
			}
			else if(location.equals("berlin")) {
				if(mainComp.equals("tuna")) {
					Chatbot.getAngry();
					ChatbotMain.print("The tuna in Berlin is TOO F**KING RAW. It's practically still alive!!");
					adjustRating(location, mainComp);
				}
			}
			else if(location.equals("seoul")) {
				if(mainComp.equals("salmon")) {
					Chatbot.getAngry();
					ChatbotMain.print("Holy s**t, if you want salmon so bad, the toilet bowl in your bathroom is a better place to look than the s**tholes in Seoul.");
					adjustRating(location, mainComp);
				}
			}
			else if(location.equals("tokyo")) {
				if(mainComp.equals("")) {
					ChatbotMain.print("");
				}
			}
			else if(location.equals("new york")) {
				if(mainComp.equals("")) {
					
				}
			}
			else if(location.equals("los angeles")) {
				
			}
			else if(location.equals("sydney")) {
				
			}
		}
		else {
			lastLocation = location;
			lastMainComp = mainComp;
			
			if(location.equals("london")){
				if(mainComp.equals("fish")){
					Chatbot.calmDown(3);
					ChatbotMain.print("That's rich, "+ Chatbot.getUsername() + ", fish in London is a delicacy Perhaps I'll go to " + place + "next time I go to London.");
				}
				else if (mainComp.equals("milk")){
					adjustRating(location, mainComp);
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					ChatbotMain.print("What are you doing with your life? Milk in London is garbage");
				}
				else{
					adjustRating(location, mainComp);
					Chatbot.calmDown(2);
					ChatbotMain.print("Really? People in London can actually make GOOD things out of " + mainComp + "?");
				}
					
			}
			else if(location.equals("seoul")) {
				if(mainComp.equals("chicken")) {
					Chatbot.calmDown(3);
					ChatbotMain.print("Quite a sharp sense of taste you have there. Chicken in Seoul boasts its spicy flavor and is among the best in the world no matter where you go.");
				}
				else if(mainComp.equals("salmon")) {
					adjustRating(location, mainComp);
					Chatbot.getAngry();
					ChatbotMain.print("Hell is wrong with you?! Salmon in Seoul tastes like salmon from my toilet bowl at home!! Salty and disgusting!!");
				}
				else {
					adjustRating(location, mainComp);
					ChatbotMain.print("A decent pick. At best, you can get the exact same thing from those pitiful free sample stands at supermarkets");
				}
			}
			else if(location.equals("berlin")) {
				if(mainComp.equals("lamb")) {
					Chatbot.calmDown(3);
					ChatbotMain.print("An excellent choice you made there. Lamb in Berlin is a gift from God himself.");
				}
				else if(mainComp.equals("tuna")) {
					Chatbot.getAngry();
					ChatbotMain.print("Berlin tuna is out-of-this world! And so will it's customers for consuming something utterly disgusting.");
					adjustRating(location, mainComp);
				}
				else {
					adjustRating(location, mainComp);
					ChatbotMain.print("I mean it's not bad. It's just that it's not the best just like a bunch of other 'restaurants'.");
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
		}
		ChatbotMain.print("Overall, I would give " + place + " a " + rating + " out of 5 rating.");
	}
	
	public boolean detectDuplicate(String location, String mainComp) {
		return location.toLowerCase().equals(lastLocation) && mainComp.toLowerCase().equals(lastMainComp);
	}
	
	public void adjustRating(String location, String mainComp) {
		if(location.equals("london")) {
			if(mainComp.equals("milk"))
			{
				rating -= 3;
			}
			else if(!mainComp.equals("fish")) {
				rating -= 2;
			}
		}
		if(location.equals("berlin")) {
			if(mainComp.equals("yogurt")) {
				rating -= 3;
			}
			else if(!mainComp.equals("cauliflower")) {
				rating -= 2;
			}
		}
		if(location.equals("new york")) {
			if(mainComp.equals("bread")) {
				rating -= 3;
			}
			else if(!mainComp.equals("beef")) {
				rating -= 2;
			}
		}
		if(location.equals("seoul")) {
			if(mainComp.equals("")) {
				rating -= 3;
			}
			else if(mainComp.equals("")) {
				rating -= 2;
			}
		}
		if(location.equals("tokyo")) {
			if(mainComp.equals("")) {
				rating -= 3;
			}
			else if(mainComp.equals("")) {
				rating -= 2;
			}
		}
		if(location.equals("los angeles")) {
			if(mainComp.equals("")) {
				rating -= 3;
			}
			else if(mainComp.equals("")) {
				rating -= 2;
			}
		}
		if(location.equals("london")) {
			if(mainComp.equals("")) {
				rating -= 3;
			}
			else if(mainComp.equals("")) {
				rating -= 2;
			}
		}
		if(location.equals("sydney")) {
			if(mainComp.equals("")) {
				rating -= 3;
			}
			else if(mainComp.equals("")) {
				rating -= 2;
			}
		}
	}	
}
