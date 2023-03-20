package exercise;

public class Thread1  extends Thread{
	BrowserHistory browserHistory;
	int size;
	
	public Thread1(BrowserHistory browserHistory, int size) {
		super();
		this.browserHistory = browserHistory;
		this.size = size;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < size; i++) {
			try {
				browserHistory.delete();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
