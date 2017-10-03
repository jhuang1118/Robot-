package chatbot;

public class ChatbotTristan implements Topic {
	private String[] keywords;
    private	String[] meals = {"breakfast", "lunch", "dinner"};
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	public ChatbotTristan() {
		String[] temp = {"pizza","things","steak","chicken","butter chicken",};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "";
		response = "";
	}
	//hi
	@Override
	public void talk(String response) {
		ChatbotMain.print("What foods do you bloody children want now?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			String meal = findKeywords(response, keywords, 0);
			if(meal.equals("breakfast")) {
				ChatbotMain.print("What food in particular?");
				discussBreakfast();
			}
			
			if(meal.equals("lunch")) {
				discussLunch();
			}
			
			if(meal.equals("dinner")) {
				ChatbotMain.print("What food in particular?");
				discussDinner();
			}
			
			else {
				ChatbotMain.print("Bye");
				break;
			}
		}
		ChatbotMain.print("Waste of my time." +ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();

	}

	private void discussDinner() {
		ChatbotMain.print("What dinner in particular?");
		if(ChatbotMain.findKeyword(response, keywords[5], 0) >= 0) {
			ChatbotMain.print("This is how you make butter chicken.");
		}
	}
	
	private void discussLunch() {
		ChatbotMain.print("What lunch in particular?");
		response = "ChatbotMain.getInput";
		if(ChatbotMain.findKeyword(response, keywords[1], 0) >= 0) {
			ChatbotMain.print("This is how you make my mozzarella and rosemary pizza.");
		}
	}
	
	private void discussBreakfast() {
		ChatbotMain.print("What breakfast in particular?");
	}
	public static String findKeywords(String searchString, String[] keywords, int startPsn) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(searchString, keywords[i], startPsn) >= 0) {
				return keywords[i];
			}
		}
		return "";
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}
	//i 
}
