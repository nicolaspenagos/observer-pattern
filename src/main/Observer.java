/* * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 * * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package main;

//Observer class
public class Observer implements CounterThread.OnCounterListener{
	
	private CounterThread counter;
	
	public Observer() {
		
	}
	
	public void startCounter() {
		
		counter = new CounterThread();
		counter.setObserver(this);
		counter.start();
		
	}
	
	@Override
	public void onTenSeconds() {
		// TODO Auto-generated method stub
		System.out.println("Do action on ten seconds");
	}

	@Override
	public void onFiveSeconds() {
		// TODO Auto-generated method stub
		System.out.println("Do action on five seconds");
	}

	@Override
	public void onCounterChange(int counter) {
		// TODO Auto-generated method stub
		
		System.out.println(""+counter);
	}
	
}
