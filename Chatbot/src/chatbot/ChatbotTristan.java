package chatbot;

public class ChatbotTristan implements Topic { 
	private String[] keywords;
	private	String[] Breakfast = {"eggs", "hash browns","pancakes"};
	private	String[] Lunch = {"pizza","mac n cheese","spaghetti"};
	private	String[] Dinner = {"chicken","gnocchi","salmon"};
	private	String[] Dessert = {"tart","brownies","pie"};
	private String goodbyeKeyword; 
	private String secretKeyword; 
	private String response; 
	public ChatbotTristan() { 
		String[] temp = {"black"}; 
		keywords = temp; 
		goodbyeKeyword = "bye"; 
		secretKeyword = ""; 
		response = ""; }
	
public void talk(String response) {
	ChatbotMain.print("What do you bloody children want now?");
	response = ChatbotMain.getInput();
	while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
		//String meal = ChatbotMain.findKeyword(response, keywords, 0);
		
		if(response.equals("breakfast")) {
			ChatbotMain.print("What breakfast food in particular?");
			discussBreakfast();
		}
		
		if(response.equals("lunch")) {
			ChatbotMain.print("What lunch food in particular?");
			discussLunch();
		}
		
		if(response.equals("dinner")) {
			ChatbotMain.print("What dinner food in particular?");
			discussDinner();
		}
		
		if(response.equals("dessert")) {
			ChatbotMain.print("What dessert food in particular?");
			discussDessert();
		}
		
		else {
			ChatbotMain.print("Waste of my time." +ChatbotMain.chatbot.getUsername()+"!");
			break;
		}
	}
	ChatbotMain.print("Waste of my time." +ChatbotMain.chatbot.getUsername()+"!");
	ChatbotMain.chatbot.startChatting();

}

private void discussBreakfast() {
	response = ChatbotMain.getInput();
	if(ChatbotMain.findKeyword(response, Breakfast[0], 0) >= 0){
		ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/north-african-eggs/");
	}
	if(ChatbotMain.findKeyword(response, Breakfast[1], 0) >= 0){
		ChatbotMain.print("http://www.independent.co.uk/life-style/food-and-drink/gordon-ramsay-eggs-baked-hash-browns-bacon-recipe-ingredients-cooking-instructions-how-to-make-a7952591.html");
	}
	if(ChatbotMain.findKeyword(response, Breakfast[2], 0) >= 0){
		ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/coconut-pancakes-with-mango-slices-and-lime-syrup/");
	}
}

private void discussLunch() {
	response = ChatbotMain.getInput();
	if(ChatbotMain.findKeyword(response, Lunch[0], 0) >= 0) {
		ChatbotMain.print("This is how you make mozzarella and rosemary pizza.");
	}
	if(ChatbotMain.findKeyword(response, Lunch[1], 0) >= 0) {
		ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/macaroni-and-cauliflower-bake-with-three-cheeses/");
	}
	if(ChatbotMain.findKeyword(response, Lunch[2], 0) >= 0) {
		ChatbotMain.print("This is how you make cornish seaside sausage spaghetti");
	}
}

private void discussDinner() {
	response = "ChatbotMain.getInput";
	if(ChatbotMain.findKeyword(response, Dinner[0], 0) >= 0) {
		ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/roast-chicken-with-chickpea-stuffing-and-big-green-salad/");
	}
	if(ChatbotMain.findKeyword(response, Dinner[1], 0) >= 0) {
		ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/home-made-gnocchi/");
	}
	if(ChatbotMain.findKeyword(response, Dinner[2], 0) >= 0) {
		ChatbotMain.print("https://www.gordonramsay.com/gr/recipes/teriyaki-salmon/");
	}
}

private void discussDessert() {
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
}

public static String findKeywords(String searchString, String[] keywords, int startPsn) {
	for(int i = 0; i < keywords.length; i++) {
		if(ChatbotMain.findKeyword(searchString, keywords[i], startPsn) >= 0) {
			return keywords[i];
		}
	}
	return "";
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