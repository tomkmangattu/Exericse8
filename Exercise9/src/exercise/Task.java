package exercise;

public class Task {
	
	static BrowserHistory browserHistory;
	
	public static void main(String[] args) {
		
		browserHistory = new BrowserHistory();
		String[] urlLiStrings = { "zoho.com","google.com", "fb.com", "apple.com", "tw.com"};
		browserHistory.visitAll(urlLiStrings);
		
		Thread thread1 = new Thread1(browserHistory, urlLiStrings.length);
		
		Thread thread2 = new Thread2(browserHistory, urlLiStrings.length);
		
		thread2.start();
		thread1.start();
		
	}
}
