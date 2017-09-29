package chatbot;

public class ChatBotWei implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;

	public ChatBotWei() {
		String[] temp = {"sutff","things","whatever","nothing"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Ugh another conversation. Well just make it quick I've got a game to get back into");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1){
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("What are pugs again lol");
				response = ChatbotMain.getInput();
			}
			else {
				ChatbotMain.print("Yawn cool. Can I get back in my game now if you have nothing else to say?");
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Thank god I can get back into my game. Talk to you later, " + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
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

}
