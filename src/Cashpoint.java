import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class Cashpoint {
	private final Semaphore semaphore;
	private final int number;
	private final List<Student> queue=new LinkedList<Student>();
	private final long paymentDuration;
	
	private Cashpoint(long paymentDuration, int number){
		this.semaphore=new Semaphore(1);
		this.number=number;
		this.paymentDuration=paymentDuration;
	}

	
	static Cashpoint create(long paymentDuration, int number){
		return new Cashpoint(paymentDuration, number);
	}
	
	public void queueUp(Student student){
	    
		queue.add(student);
		System.out.println(student + " anstellen an: " + this);
        System.out.println("Schlange von "+ this +" "+  this.queue);
		try{
			semaphore.acquire();
			Thread.sleep(paymentDuration);
		}
		catch (InterruptedException e){
			student.interrupt();
		}
		queue.remove(student);
        semaphore.release();
		System.out.println(student + " bezahlt an " + this);
		System.out.println("Schlange von "+ this +" "+  this.queue);
		
	}
	
	public int queueLength(){
		return queue.size();
	}
	
	@Override
	public String toString(){
		return "Kasse Nr. "+number;
	}
	
}
