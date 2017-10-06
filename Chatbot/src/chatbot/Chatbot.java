package chatbot;
	
	public class Chatbot {
		public static  String username;
		private boolean chatting;
		private Topic johnson; 
		private Topic wei;
		private Topic tristan;
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
	
	public Topic getJohnson() {
		return johnson;
	}
	
	public Topic getWei() {
		return wei;
	}
	
	public Topic getTristan() {
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
	
	public static void calmDown(int decrement) {
		//decrements the anger of the bot
		if(angerLvl - decrement < 0) {
			angerLvl = 0;
		}
		else {
			angerLvl -= decrement;
		}
	}
	
	public void startChatting() {
		//whenever you print or get input, use these methods...
		ChatbotMain.print("You must have some guts to start sh*t with me. Why don't you tell me your name?");
		username = ChatbotMain.getInput();
		ChatbotMain.print(username + ", huh? Your name smells and looks RAW. What would a person like you want from me?");
	
	}
}