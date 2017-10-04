package chatbot;
	
	public class Chatbot {
		private String username;
		private boolean chatting;
		private Topic johnson; 
		private Topic wei;
		private Topic tristan;
		
	public Chatbot() {
		johnson = new ChatbotJohnson();
		tristan = new ChatbotTristan();
		wei = new ChatBotWei();
		username = "Unknown User";
		chatting = true;
	}
	
	public String getUsername() {
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
	
	public void startChatting() {
		//whenever you print or get input, use these methods...
		ChatbotMain.print("You must have some guts to start sh*t with me. Why don't you tell me your name?");
		username = ChatbotMain.getInput();
		ChatbotMain.print(username + ", huh? Your name smells and looks RAW. What would a person like you want from me?");
		while(chatting) {
			String response = ChatbotMain.getInput();
			if(johnson.isTriggered(response)) {
				chatting = false;
				johnson.talk(response);
			}
			else if(tristan.isTriggered(response)) {
				chatting = false;
				tristan.talk(response);
			}
			else if(wei.isTriggered(response)){
				chatting = false;
				wei.talk(response);
			}
			else {
				ChatbotMain.print("Listen, I don't talk to people who ask me of half-baked things. Ask me something that I can relate to.");
			}	
		}
		ChatbotMain.print("");
	}
}

	
	

