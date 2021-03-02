/* * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package main;

//Subject
public class CounterThread extends Thread{
	
	private int counter;
	private boolean isAlive;
	
	//Observer reference
	private OnCounterListener observer;
	
	public CounterThread() {
		isAlive = true;
	}
	
	
	@Override
	public void run() {
		
		while(isAlive) {
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			counter++;
			
			//On counter changed
			observer.onCounterChange(counter);
			
			//On five seconds
			if(counter == 5) {
				observer.onFiveSeconds();
			}
			
			//On ten seconds
			if(counter == 10) {
				observer.onTenSeconds();
			}
			
		}
		
	}
	
	// Subscription method
	public void setObserver(OnCounterListener observer) {
		this.observer = observer;
	}
	
	public interface OnCounterListener{
		
		// Notifications methods
		void onTenSeconds();
		void onFiveSeconds();
		void onCounterChange(int counter);
		//...
		
	}

}
