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
		//whenever you print or get input, use these methods.
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your inputs. Tell me your name.");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(johnson.isTriggered(response)) {
				chatting = false; //exits the while loop. IMPORTANT you get graded for this!
				johnson.talk(response);
			}else{
				if(tristan.isTriggered(response)) {
					chatting = false; //exits the while loop. IMPORTANT you get graded for this!
					tristan.talk(response);
			}else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}

	}
}
