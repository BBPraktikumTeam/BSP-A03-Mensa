
public class Simulation {

	/**
	 * @param args
	 */
	private static final long SIMULATION_TIME=10000;
	private static final long PAYMENT_DURATION=1000;
	private static final int NUMBER_OF_STUDENTS=10;
	private static final int NUMBER_OF_CASHPOINTS=3;

	
	public static void main(String[] args) {
		Mensa mensa=Mensa.create();
		for(int i=1; i<=NUMBER_OF_STUDENTS;i++){
			mensa.add(Student.create(i, mensa));
		}
		for(int i=1; i<=NUMBER_OF_CASHPOINTS;i++){
			mensa.add(Cashpoint.create(PAYMENT_DURATION, i));
		}
		System.out.println("------Mensa eröffnet-------");
		mensa.start();
		try{
		    
			Thread.sleep(SIMULATION_TIME);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("------Mensa geschlossen-------");
		mensa.interrupt();
		
		
		
	}

}
