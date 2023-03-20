package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class BrowserHistory {
	
	private ArrayList<String> historyUrls;
	static final String[] ALLOWABLEDOMAINS = {".com", ".in", ".org"};
	boolean valueDeleted = false;
	
	public BrowserHistory() {
		historyUrls = new ArrayList<>();
	}
	
	void visit(String url) throws InvalidURLException {
		boolean endsWithAllowableDomains = false;
		for(String domains : ALLOWABLEDOMAINS) {
			if(url.endsWith(domains)) {
				endsWithAllowableDomains = true;
				break;
			}
		}
		
		if(!endsWithAllowableDomains) {
			throw new InvalidURLException("Invalid url extension");
		}
		
		historyUrls.add(url);
	}
	
	void visitAll(String[] urls) {
		historyUrls.addAll(Arrays.asList(urls));
	}
	

	
	synchronized void delete() throws InterruptedException {
		
		while(valueDeleted) {
			wait();
		}
		
		if(historyUrls.isEmpty()) {
			throw new IndexOutOfBoundsException("History data is empty");
		}
		System.out.println("Deleting url :" + historyUrls.get(0));
		historyUrls.remove(0);
		valueDeleted =true;
		notify();
	}
	
	synchronized void displayWithIndex() throws InterruptedException {
		while(!valueDeleted) {
			wait();
		}
		Iterator<String> iterator = historyUrls.iterator();
		int index = 1;
		
		while(iterator.hasNext()) {
			System.out.println(index++ + " " +  iterator.next());
		}
		valueDeleted = false;
		notify();
	}
	
}
