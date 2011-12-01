
public class Student extends Thread {
	private final int number;
	private final Mensa mensa;
	private final long RANDOM_MULTIPLICATOR=100;
	
	private Student(int number, Mensa mensa){
		this.number=number;
		this.mensa=mensa;
	}
	
	static Student create(int number, Mensa mensa){
		return new Student(number, mensa);
	}
	
	@Override
	public String toString(){
		return "Student Nr. "+number;
	}
	
	private void eat(){
		long eatingTime=(long) Math.random()*RANDOM_MULTIPLICATOR;
		try{
			Thread.sleep(eatingTime);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(true){
			mensa.cashPoint().queueUp(this);
			eat();
		}
	}

}
