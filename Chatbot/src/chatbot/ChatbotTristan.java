package chatbot;

public class ChatbotTristan implements Topic { 
	private String[] keywords;
	private	String[] Breakfast = {""};
	private	String[] Lunch = {"pizza","mac n cheese"};
	private	String[] Dinner = {"chicken"};
	private	String[] Dessert = {"breakfast", "tart"};
	private String goodbyeKeyword; 
	private String secretKeyword; 
	private String response; 
	public ChatbotTristan() { 
		String[] temp = {""}; 
		keywords = temp; 
		goodbyeKeyword = "bye"; 
		secretKeyword = ""; 
		response = ""; }
}

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
	ChatbotMain.print("What breakfast in particular?");
	response = ChatbotMain.getInput();
	if(ChatbotMain.findKeyword(response, Breakfast[1], 0) >= 0){
		ChatbotMain.print("This is how you make eggs");
	}
}

private void discussLunch() {
	ChatbotMain.print("What lunch in particular?");
	response = "ChatbotMain.getInput";
	if(ChatbotMain.findKeyword(response, Lunch[1], 0) >= 0) {
		ChatbotMain.print("This is how you make mozzarella and rosemary pizza.");
	}
	if(ChatbotMain.findKeyword(response, Lunch[2], 0) >= 0) {
		ChatbotMain.print("This is how you make macaroni cheese and cauliflower bake.");
	}
}

private void discussDinner() {
	ChatbotMain.print("What dinner in particular?");
	response = "ChatbotMain.getInput";
	if(ChatbotMain.findKeyword(response, Dinner[5], 0) >= 0) {
		ChatbotMain.print("This is how you make roasted chicken.");
	}
}

private void discussDessert() {
	ChatbotMain.print("What dessert in particular?");
	response = "ChatbotMain.getInput";
	if(ChatbotMain.findKeyword(response, Dessert[1], 0) >= 0) {
		ChatbotMain.print("This is how you make mini chocolate tarts with peanut brittle");
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