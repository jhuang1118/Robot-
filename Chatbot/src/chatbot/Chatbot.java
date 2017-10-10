package chatbot;
	
	public class Chatbot {
		public static  String username;
		private boolean chatting;
		private static Topic johnson; 
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
		johnson.talk("");
	}
}