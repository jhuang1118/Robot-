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
		
		ChatbotMain.print("What meal " + Chatbot.getUsername() + "?");
		response = ChatbotMain.getInput().toLowerCase();
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1 && Chatbot.angerLvl < 15) {
			
			if(response.equals("breakfast")) {
				ChatbotMain.print("What breakfast food in particular?");
				discussBreakfast(response);
			}
			
			else if(response.equals("lunch")) {
				ChatbotMain.print("What lunch food in particular?");
				discussLunch(response);
			}
			
			else if(response.equals("dinner")) {
				ChatbotMain.print("What dinner food in particular?");
				discussDinner(response);
			}
			
			else if(response.equals("dessert")) {
				ChatbotMain.print("What dessert food in particular?");
				discussDessert(response);
			}
			else {
				flipOut();
				ChatbotMain.print("I can do breakfast, lunch, dinner, or dessert. Stupid child.");
			}
		}
		
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
		response = ChatbotMain.getInput().toLowerCase();
		
		if(response.equals("eggs")){
			System.out.println("https://www.gordonramsay.com/gr/recipes/north-african-eggs/");
		}
		else if(ChatbotMain.findKeyword(response, Breakfast[1], 0) >= 0){
			System.out.println("http://www.independent.co.uk/life-style/food-and-drink/gordon-ramsay-eggs-baked-hash-browns-bacon-recipe-ingredients-cooking-instructions-how-to-make-a7952591.html");
		}
		else if(ChatbotMain.findKeyword(response, Breakfast[2], 0) >= 0){
			System.out.println("https://www.gordonramsay.com/gr/recipes/coconut-pancakes-with-mango-slices-and-lime-syrup/");
		}
		else {
			System.out.println("Sorry, we don't serve garbage here. For breakfast, I could show you EGGS, HASH BROWNS, or PANCAKES.");
		}
		
		needHelp();
		
		}
	
	
	private void discussLunch(String response) {
		response = ChatbotMain.getInput().toLowerCase();
		
		if(ChatbotMain.findKeyword(response, Lunch[0], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/mozzarella-and-rosemary-pizza/");
		}
		else if(ChatbotMain.findKeyword(response, Lunch[1], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/macaroni-and-cauliflower-bake-with-three-cheeses/");
		}
		else if(ChatbotMain.findKeyword(response, Lunch[2], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/cornish-seaside-sausage-spaghetti/");
		}
		else {
			System.out.println("Sorry, we don't serve garbage here. Or you can't spell. For lunch, I have time to teach PIZZA, MAC N CHEESE, or SPAGHETTI.");
		}
		
		needHelp();
		
		}
	
	
	private void discussDinner(String response) {
		response = ChatbotMain.getInput().toLowerCase();
		
		if(ChatbotMain.findKeyword(response, Dinner[0], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/roast-chicken-with-chickpea-stuffing-and-big-green-salad/");
		}
		else if(ChatbotMain.findKeyword(response, Dinner[1], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/home-made-gnocchi/");
		}
		else if(ChatbotMain.findKeyword(response, Dinner[2], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/teriyaki-salmon/");
		}
		else {
			System.out.println("Sorry, we don't serve garbage here. Maybe you can't speak english. For dinner, we could do CHICKEN, GNOCCHI, or SALMON.");
		}
		
		needHelp();
		
		}
	
	
	private void discussDessert(String response) {
		response = "ChatbotMain.getInput";
		if(ChatbotMain.findKeyword(response, Dessert[0], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/indulgent-mini-chocolate-tarts-with-peanut-brittle/");
		}
		else if(ChatbotMain.findKeyword(response, Dessert[1], 0) >= 0) {
			System.out.println("https://www.gordonramsayrestaurants.com/recipes/worlds-best-brownies/");
		}
		else if(ChatbotMain.findKeyword(response, Dessert[2], 0) >= 0) {
			System.out.println("https://www.gordonramsay.com/gr/recipes/cranberry-mince-pies/");
		}
		else {
			System.out.println("Sorry, we don't serve garbage here. Or you're just stupid. For dessert I can do TART, BROWNIES, or PIE");
		}
		
		needHelp();
		
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
	
	public void needHelp() {
		ChatbotMain.print("Do you still need my assistance?");
		response = ChatbotMain.getInput().toLowerCase();
		if(response.equals("no")) {
			ChatbotMain.print("Waste of my time.");
			System.exit(0);
		}
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