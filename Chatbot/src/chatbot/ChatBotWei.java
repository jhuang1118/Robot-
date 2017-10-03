package chatbot;

public class ChatBotWei implements Topic {
	
	private String[] keywords;
	private String[] ingredients;
	private String[] goodPlace;
	private String[] goodFood;
	private String[] badPlace;
	private String[] badFood;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int angryLvl = 0;

	public ChatBotWei() {
		String[] temp = {"rate", "your opinion", "you rate", "you think", "your stance"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Whatever you're asking me to rate, it's probably not going to be good as my restaurant and dishes!");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1){
			
		}
		//access variables from other classes
		
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
	
	public void rateDish(String[] recipe) {
		//will take in an array with a bunch of ingredients jumbled together
		int rating = 5;
		
		for(int i = 0; i < recipe.length - 1; i++) {
			for(int j = i; j < recipe.length; j++) {
				if(/*meat and dairy*/){
					getAngry();
				}
				if(/*dairy and sauce*/) {
					getAngry();
				}
				if(/**/) {
					getAngry();
				}
				if(/**/) {
					getAngry();
				}
			}
		}
		
		System.out.print("stuff to say when done with loop");
	}
	
	public void getAngry() {
		angryLvl++;
	}

}
