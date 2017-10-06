package chatbot;

public class ChatbotJohnson implements Topic {
	
	private String[] insults0;
	private String[] insults3;
	private String[] insults6;
	private String[] insults9;
	private String[] insults12;
	private String[] insults15;
	
	private String[][] allInsults;
	private String[] toTrist;
	private String[] toWei;
	
	private String[] angWords;
	
	private int angLvl;
	
	private String goodbyeKeyword;
	
	private String response;
	
	private Topic wei;
	private Topic tristan;
	
	public ChatbotJohnson() {
		String[] temp0 = {"0","You suck!","Stop acting like an idiot!","You're garbage!","You don't deserve to breathe!"};
		String[] temp3 = {"3","","","",""};
		String[] temp6 = {"6","","","",""};
		String[] temp9 = {"9","","","",""};
		String[] temp12 = {"12","My grandma can cook better than you and she's dead!","Just jump in the oven! It would make my life a lot easier!","Hey panini head, are you listening to me?","You're a disgrace!"};
		String[] temp15 = {"15","What are you? An idiot sandwich!","You surprise me. I'm surprised at how bad you are!","You freakin donkey!","Get the hell out of my sight!"};
		
		insults0 = temp0;
		insults3 = temp3;
		insults6 = temp6;
		insults9 = temp9;
		insults12 = temp12;
		insults15 = temp15;
		
		String[][] tempAll = {insults0,insults3,insults6,insults9,insults12,insults15};
		allInsults = tempAll;
		
		String[] tempTrist = {"recipe","how to cook","breakfast","lunch","dinner"};
		toTrist = tempTrist;
		
		String[] tempWei = {"rating","rate","restaurant","good food", "bad food"};
		toWei = tempWei;
		
		String[] tempAng = {"forgot","too much","too little","don't have"};
		angWords = tempAng;
		
		angLvl = 0;
		
		goodbyeKeyword = "bye";
		response = "";
		
	}

	
	
	public void talk(String response) {
		ChatbotMain.print("What do you want? I'm busy, I have to catch my plane to cook for the Nigerian Prince!");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			isTriggered(response);
			if(tristan.isTriggered(response)) {
				tristan.talk(response);
			}
			if(wei.isTriggered(response)) {
				wei.talk(response);
			}
		} 
			angLvl += 3;
			ChatbotMain.print("Stop talking about things I don't know! Talk about cooking or rating restaurants");
			response = ChatbotMain.getInput();
			throwInsult();	
			if(angLvl > 15) {
				ChatbotMain.print("You are so stupid! I don't want to talk to you anymore!");
				ChatbotMain.chatbot.startChatting();
				return;
			}
			
		}
		//access variables from other classes
		ChatbotMain.print("How about a thank you, you miserable sucker!");
		ChatbotMain.chatbot.startChatting();
		
	
	
	
	public void throwInsult() {
		if(isTriggered(response)) {
			int choose = (int)(Math.random() * 4) + 1;
			String lvl = String.valueOf(angLvl);
			for (int i = 0; i < allInsults.length; i++ ) {
				if(allInsults[i][0].equals(lvl)){
					ChatbotMain.print(allInsults[i][choose]);
					angLvl += 3;
				}
			}
		}
	}
	public void triggerInsult(){
		throwInsult();
	}
	public boolean isTriggered(String response) {
		wei = ChatbotMain.chatbot.getWei();
		
		tristan = ChatbotMain.chatbot.getTristan();
		return true;
//	for(int i = 0; i < angWords.length; i++) {
//		//IMPORTANT (on the rubric)
//		if(ChatbotMain.findKeyword(response, angWords[i], 0) >= 0) {
//			
//			return true;
//			
//		}
//	}
//	return false;
	}
}
