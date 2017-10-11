package chatbot;
	
	public class Chatbot {
		public static  String username;
		private boolean chatting;
		public static Topic johnson; 
		private static Topic wei;
		private static Topic tristan;
		public static int angerLvl;
		
	public Chatbot() {
		johnson = new ChatbotJohnson();
		tristan = new ChatbotTristan();
		wei = new ChatBotWei();
		username = "Unknown User";
		chatting = true;
		angerLvl = 0;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static Topic getJohnson() {
		return johnson;
	}
	
	public static Topic getWei() {
		return wei;
	}
	
	public static Topic getTristan() {
		return tristan;
	}
	
	public static int getAngerLvl() {
		return angerLvl;
	}
	
	public static void getAngry() {
		//increments the anger of the bot
		if(angerLvl + 3 > 15) {
			angerLvl = 15;
		}
		else {
			angerLvl += 3;
		}
	}
	
	public static void calmDown() {
		//decrements the anger of the bot
		if(angerLvl - 3 < 0) {
			angerLvl = 0;
		}
		else {
			angerLvl -= 3;
		}
	}
	
	public void startChatting() {
		//whenever you print or get input, use these methods...
		ChatbotMain.print("You must have some guts to start sh*t with me. Why don't you tell me your name?");
		username = ChatbotMain.getInput();
		johnson.talk("");
	}
	
	public static void continueChatting(String response) {
		if(wei.isTriggered(response)) {
			wei.talk(response);
		}
		else if (tristan.isTriggered(response)){
			tristan.talk(response);
		}
		else if(johnson.isTriggered(response)){
			johnson.talk(response);
		}
		else {
			ChatbotMain.print("Wanna talk like a normal person with a normal brain and say something that I can understand?");
			response = ChatbotMain.getInput();
			continueChatting(response);
		}
	}
}