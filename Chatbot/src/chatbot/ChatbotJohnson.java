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
		String[] temp0 = {"0","","","",""};
		String[] temp3 = {"3","","","",""};
		String[] temp6 = {"6","","","",""};
		String[] temp9 = {"9","","","",""};
		String[] temp12 = {"12","","","",""};
		String[] temp15 = {"15","","","",""};
		
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
		
		wei = new ChatBotWei();
		tristan = new ChatbotTristan();
	}

	
	
	public void talk(String response) {
		ChatbotMain.print("What do you want? I'm busy, I have to catch my plane to cook for the Nigerian Prince!");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			isTriggered(response);
			for(int i = 0; i < toTrist.length; i++) {
				if(ChatbotMain.findKeyword(response, toTrist[i], 0) >= 0) {
					tristan.talk(response);
					response = ChatbotMain.getInput();
				}
			} 
			for(int i = 0; i < toWei.length; i++) {
				if(ChatbotMain.findKeyword(response, toWei[i], 0) >= 0) {
					wei.talk(response);
					response = ChatbotMain.getInput();
				}
			} 
			angLvl += 3;
			ChatbotMain.print("Stop talking about things I don't know! Talk about cooking or rating restaurants");
			response = ChatbotMain.getInput();
			throwInsult();	
			if(angLvl == 15) {
				ChatbotMain.print("You are so stupid! I don't want to talk to you anymore!");
				ChatbotMain.chatbot.startChatting();
			}
			
		}
		//access variables from other classes
		ChatbotMain.print("Sayonara, sucker!");
		ChatbotMain.chatbot.startChatting();
		}
	
	
	
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
	for(int i = 0; i < angWords.length; i++) {
		//IMPORTANT (on the rubric)
		if(ChatbotMain.findKeyword(response, angWords[i], 0) >= 0) {
			
			return true;
			
		}
	}
	return false;
	}
}
