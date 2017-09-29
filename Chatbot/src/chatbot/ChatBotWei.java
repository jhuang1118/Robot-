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
		ChatBotMain.print("Ugh another conversation. Well just make it quick I've got a game to get back into");
		response = ChatBotMain.getInput();
		while(ChatBotMain.findKeyword(response, goodbyeKeyword, 0) == -1){
			if(ChatBotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatBotMain.print("What are pugs again lol");
				response = ChatBotMain.getInput();
			}
			else {
				ChatBotMain.print("Yawn cool. Can I get back in my game now if you have nothing else to say?");
				response = ChatBotMain.getInput();
			}
		}
		//access variables from other classes
		ChatBotMain.print("Thank god I can get back into my game. Talk to you later, " + ChatBotMain.chatbot.getUsername() + "!");
		ChatBotMain.chatbot.startChatting();
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatBotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}
