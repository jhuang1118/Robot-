package chatbot;

public class ChatbotTristan implements Topic { 
	private String[] keywords;
	
	private	String[] Breakfast = {"eggs", "hash browns","pancakes"};
	private	String[] Lunch = {"pizza","mac n cheese","spaghetti"};
	private	String[] Dinner = {"chicken","gnocchi","salmon"};
	private	String[] Dessert = {"tart","brownies","pie"};
	
	private String goodbyeKeyword; 
	private String response; 
	
	public ChatbotTristan() { 
		String[] temp = {"cooking","cook","recipes","recipe",}; 
		keywords = temp; 
		goodbyeKeyword = "bye"; 
		response = ""; 
		}
	
	public void talk(String response) {
		
		ChatbotMain.print("What do you want?");
		response = ChatbotMain.getInput().toLowerCase();
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1 && Chatbot.angerLvl < 15) {
			
			if(response.equals("breakfast")) {
				discussBreakfast(response);
			}
			
			if(response.equals("lunch")) {
				discussLunch(response);
			}
			
			if(response.equals("dinner")) {
				discussDinner(response);
			}
			
			if(response.equals("dessert")) {
				discussDessert(response);
			}
		}
		ChatbotMain.print("Waste of my time." + Chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
		
		if(Chatbot.angerLvl >= 15) {
			ChatbotMain.print("There's no point in having a conversation if you're not going to listen to what I say.");
			System.exit(0);
		}
		
		if(response.equals("no")) {
			ChatbotMain.print("bye");
			System.exit(0);
		}
		else if(Chatbot.getTristan().isTriggered(response)) {
			Chatbot.getTristan().talk(response);
		}
		else {
			Chatbot.continueChatting(response);
		}
	
	}
	
	private void discussBreakfast(String response) {
		ChatbotMain.print("What breakfast food in particular?");
		response = ChatbotMain.getInput().toLowerCase();
		
		if(ChatbotMain.findKeyword(response, Breakfast[0], 0) >= 0){
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/north-african-eggs/");
		}
		if(ChatbotMain.findKeyword(response, Breakfast[1], 0) >= 0){
			ChatbotMain.print("http://www.independent.co.uk/life-style/food-and-drink/gordon-ramsay-eggs-baked-hash-browns-bacon-recipe-ingredients-cooking-instructions-how-to-make-a7952591.html");
		}
		if(ChatbotMain.findKeyword(response, Breakfast[2], 0) >= 0){
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/coconut-pancakes-with-mango-slices-and-lime-syrup/");
		}
		else {
			ChatbotMain.print("Sorry, we don't serve garbage here. For breakfast, I could show you EGGS, HASH BROWNS, or PANCAKES.");
		}
	}
	
	private void discussLunch(String response) {
		ChatbotMain.print("What lunch food in particular?");
		response = ChatbotMain.getInput().toLowerCase();
		
		if(ChatbotMain.findKeyword(response, Lunch[0], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/mozzarella-and-rosemary-pizza/");
		}
		if(ChatbotMain.findKeyword(response, Lunch[1], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/macaroni-and-cauliflower-bake-with-three-cheeses/");
		}
		if(ChatbotMain.findKeyword(response, Lunch[2], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/cornish-seaside-sausage-spaghetti/");
		}
		else {
		ChatbotMain.print("Sorry, we don't serve garbage here. Or you can't spell. For lunch, I have time to teach PIZZA, MAC N CHEESE, or SPAGHETTI.");
		}
	}
	
	private void discussDinner(String response) {
		ChatbotMain.print("What dinner food in particular?");
		response = ChatbotMain.getInput().toLowerCase();
		
		if(ChatbotMain.findKeyword(response, Dinner[0], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/roast-chicken-with-chickpea-stuffing-and-big-green-salad/");
		}
		if(ChatbotMain.findKeyword(response, Dinner[1], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/home-made-gnocchi/");
		}
		if(ChatbotMain.findKeyword(response, Dinner[2], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/teriyaki-salmon/");
		}
		else {
			ChatbotMain.print("Sorry, we don't serve garbage here. Maybe you can't speak english. For dinner, we could do CHICKEN, GNOCCHI, or SALMON.");
		}
	}
	
	private void discussDessert(String response) {
		ChatbotMain.print("What dessert food in particular?");
		response = "ChatbotMain.getInput";
		if(ChatbotMain.findKeyword(response, Dessert[0], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/indulgent-mini-chocolate-tarts-with-peanut-brittle/");
		}
		if(ChatbotMain.findKeyword(response, Dessert[1], 0) >= 0) {
			ChatbotMain.print("https://www.gordonramsayrestaurants.com/recipes/worlds-best-brownies/");
		}
		if(ChatbotMain.findKeyword(response, Dessert[2], 0) >= 0) {
			ChatbotMain.print("This is how you make ");
		}
		else {
			ChatbotMain.print("Sorry, we don't serve garbage here. Or you're just stupid. For dinner, we could do CHICKEN, GNOCCHI, or SALMON.");
		}
	}
	
	public static String findKeywords(String searchString, String[] keywords, int startPsn) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(searchString, keywords[i], startPsn) >= 0) {
				return keywords[i];
			}
		}
		return "";
	}
	
	public void flipOut() {
		((ChatbotJohnson)Chatbot.getJohnson()).throwInsult();
		Chatbot.getAngry();
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}
}