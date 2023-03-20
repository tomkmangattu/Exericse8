package exercise;

public class Thread2  extends Thread{
	BrowserHistory browserHistory;
	int size;
	
	public Thread2(BrowserHistory browserHistory, int size) {
		super();
		this.browserHistory = browserHistory;
		this.size = size;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < size; i++) {
			try {
				browserHistory.displayWithIndex();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
