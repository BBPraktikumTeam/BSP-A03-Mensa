


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
	   
		long eatingTime=(long) (Math.random()*RANDOM_MULTIPLICATOR);
		try{
		    System.out.println(this.toString() + " is eating for " + eatingTime);
			Thread.sleep(eatingTime);
		}
		catch (InterruptedException e){
		    System.out.println("EAT INTERRUPT BY: " + this);
			this.interrupt();
		}
	}
	
	private void study() {
	    long studyTime=(long) (Math.random()*RANDOM_MULTIPLICATOR);
	    try {
	        System.out.println(this + " is studying for " + studyTime);
            Thread.sleep(studyTime);
        } catch (InterruptedException e) {
            System.out.println("STUDY INTERRUPT BY: " + this);
            this.interrupt();
        }
	}
	
	public void run(){
		while(!this.isInterrupted()){
			mensa.cashPoint().queueUp(this);
			eat();
			study();
		}
	}

}
