package chatbot;

public class ChatBotWei implements Topic {
	private String[] keywords;
	private String[][] ingredients;
	private String[] locations;
	
	private String goodbyeKeyword;
	private String response;
	private String lastLocation;
	private String lastMainComp;
	private Topic johnson;
	private int rating;
	

	public ChatBotWei() {
		String[] temp1 = {"rate","your opinion", "opinion of", "think of", "think about", "your personal thoughts about"};
		String[] temp0 = {"london", "sydney", "new york", "los angeles", "seoul", "berlin", "paris", "tokyo"};
		
		
		keywords = temp1;
		locations = temp0;
		goodbyeKeyword = "bye";
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
			
			if(Chatbot.angerLvl >= 15) {
				ChatbotMain.print("There's no point in having a conversation if you're not going to listen to what I say.");
				System.exit(0);
			}
			
			if(response.equals("no")) {
				ChatbotMain.print("Very well, you've wasted my time long enough time to go catch my flight!");
				System.exit(0);
			}
			else if(Chatbot.getTristan().isTriggered(response)) {
				Chatbot.getTristan().talk(response);
			}
			else {
				Chatbot.continueChatting(response);
			}
		}
		//access variables from other classes
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
			
			FoodReply[] foods = 
				{
					new FoodReply("london","milk","You idiot, didn't I tell you that you don't f**ing dine milk in London?!"),
					new FoodReply("berlin", "tuna", "Maybe tuna is good for you!! It'll help your f**king goldfish memory!!"),
					new FoodReply("paris", "fish", "Don't make me repeat myself, go fish for an answer yourself if you do!"),
					new FoodReply("seoul", "salmon", "Holy sh*t if you really want salmon, go fish it out of your toilet bowl, it's better for you!!"),
					new FoodReply("tokyo", "bread", "What is with you and dull bread?! Are dull things just naturally attracted to eachother?!"),
					new FoodReply("new york", "chicken", "Birdbrain, I told you not to get chicken in New York!!"),
					new FoodReply("los angeles", "pretzals", "Did your brain dry up or something? I told you not to get pretzals in LA!"),
					new FoodReply("sydney", "rice", "Didn't I tell you not to get rice in Sydney?! Go stick your head inside a kangaroos pouch and beg the joey to get a better brain!!")
				};
			
			for(int i = 0; i < foods.length; i++) {
				if(location.equals(foods[i].getLocation())) {
					if(mainComp.equals(foods[i].getFood())) {
						flipOut();
						lowerRate(foods[i].getLocation(), foods[i].getFood(), foods[i].getReply());
					}
					break;
				}
			}
		}
		else {
			lastLocation = location;
			lastMainComp = mainComp;
			
			if(location.equals("london")){
				if(mainComp.equals("fish")){
					Chatbot.calmDown();
					ChatbotMain.print("That's rich, "+ Chatbot.getUsername() + ", fish in London is a delicacy Perhaps I'll go to " + place + "next time I go to London.");
				}
				else if (mainComp.equals("milk")){
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "What are you doing with your life? Milk in London is garbage");
				}
				else{
					lowerRate(location, mainComp, "Really? People in London can actually make GOOD things out of " + mainComp + "?");
				}
			}
			else if(location.equals("paris")) {
				if(mainComp.equals("bread")) {
					Chatbot.calmDown();
					ChatbotMain.print("Bread in Paris? Are you a tourist or something? Either way, good pick there!");
				}
				else if(mainComp.equals("fish")) {
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "Of all the things you can eat in Paris, you had to choose their abominable fish?!");
				}
				else {
					lowerRate(location, mainComp, "Yeah, you definitely are a tourist aren't you?");
				}
			}
			else if(location.equals("seoul")) {
				if(mainComp.equals("chicken")) {
					Chatbot.calmDown();
					ChatbotMain.print("Quite a sharp sense of taste you have there. Chicken in Seoul boasts its spicy flavor and is among the best in the world no matter where you go.");
				}
				else if(mainComp.equals("salmon")) {
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "Hell is wrong with you?! Salmon in Seoul tastes like salmon from my toilet bowl at home!! Salty and disgusting!!");
				}
				else {
					lowerRate(location, mainComp, "A decent pick. At best, you can get the exact same thing from those pitiful free sample stands at supermarkets");
				}
			}
			else if(location.equals("tokyo")) {
				if(mainComp.equals("sushi")) {
					Chatbot.calmDown();
					ChatbotMain.print("The superior item to get, essential for every location to have.");
				}
				else if(mainComp.equals("bread")) {
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "Bread in Japan?! What are you doing?!");
				}
				else {
					lowerRate(location, mainComp, "It's OK. I can't comment more on something so mediocre without making it look bad.");
				}
			}
			else if(location.equals("berlin")) {
				if(mainComp.equals("lamb")) {
					Chatbot.calmDown();
					ChatbotMain.print("An excellent choice you made there. Lamb in Berlin is a gift from God himself.");
				}
				else if(mainComp.equals("tuna")) {
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "Tuna in Berlin? Try the sewers, they've got loads of them.");
				}
				else {
					lowerRate(location, mainComp, "A regular place, could be better.");
				}
				
			}
			else if(location.equals("new york")) {
				if(mainComp.equals("beef")) {
					Chatbot.calmDown();
					ChatbotMain.print("Normally, I don't eat American food, but beef from New York is almost on point!");
				}
				else if(mainComp.equals("chicken")) {
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "Do you even know how dirty the birds are in New York?");
				}
				else {
					lowerRate(location, mainComp, "Other than beef and chicken, everything else in New York is like the rest of America. Mediocre at best.");
				}
			}
			else if(location.equals("los angeles")) {
				if(mainComp.equals("hot dogs")) {
					Chatbot.calmDown();
					ChatbotMain.print("As garbage as food in America is, I can tolerate hot dogs in LA");
				}
				else if(mainComp.equals("pretzals")) {
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "This isn't New York, LA's pretzals are drier than your overcooked steak!");
				}
				else {
					lowerRate(location, mainComp, "Don't really like the place, well, never liked LA much in the first place");
				}
			}
			else if(location.equals("sydney")) {
				if(mainComp.equals("fish")) {
					Chatbot.calmDown();
					ChatbotMain.print("The seafood near Sydney is exquisite. Not top grade, but exquisite nonetheless.");
				}
				else if(mainComp.equals("rice")) {
					((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
					Chatbot.getAngry();
					lowerRate(location, mainComp, "The water in the rice in Sydney is practically nonexistant, I'd advise you don't go there.");
				}
				else {
					lowerRate(location, mainComp, "OK at best, could be better");
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
	
	public void lowerRate(String location, String mainComp, String responseTxt) {
		adjustRating(location, mainComp);
		ChatbotMain.print(responseTxt);
	}
	
	public void flipOut() {
		((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
		Chatbot.getAngry();
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
			else if(!mainComp.equals("lamb")) {
				rating -= 2;
			}
		}
		if(location.equals("new york")) {
			if(mainComp.equals("chicken")) {
				rating -= 3;
			}
			else if(!mainComp.equals("beef")) {
				rating -= 2;
			}
		}
		if(location.equals("seoul")) {
			if(mainComp.equals("salmon")) {
				rating -= 3;
			}
			else if(!mainComp.equals("chicken")) {
				rating -= 2;
			}
		}
		if(location.equals("tokyo")) {
			if(mainComp.equals("bread")) {
				rating -= 3;
			}
			else if(!mainComp.equals("sushi")) {
				rating -= 2;
			}
		}
		if(location.equals("los angeles")) {
			if(mainComp.equals("hot dogs")) {
				rating -= 3;
			}
			else if(mainComp.equals("pretzals")) {
				rating -= 2;
			}
		}
		if(location.equals("paris")) {
			if(mainComp.equals("fish")) {
				rating -= 3;
			}
			else if(!mainComp.equals("bread")) {
				rating -= 2;
			}
		}
		if(location.equals("sydney")) {
			if(mainComp.equals("rice")) {
				rating -= 3;
			}
			else if(!mainComp.equals("fish")) {
				rating -= 2;
			}
		}
	}	
}
