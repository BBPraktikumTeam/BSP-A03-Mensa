


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
	
	
	private void threadSleep(String s) {
	    System.out.println(s);
	    long sleepTime=(long) (Math.random()*RANDOM_MULTIPLICATOR);
	    try{
           
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e){
            
            this.interrupt();
        }
	}
	
	public void run(){
		while(!this.isInterrupted()){
			mensa.cashPoint().queueUp(this);
			threadSleep(this + " is eating");
			threadSleep(this + " is studying");
		}
		
	}

}
