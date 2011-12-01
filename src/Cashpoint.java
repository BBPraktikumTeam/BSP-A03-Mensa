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
		try{
			semaphore.acquire();
			Thread.sleep(paymentDuration);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		queue.remove(student);
	}
	
	public int queueLength(){
		return queue.size();
	}
	
	@Override
	public String toString(){
		return "Kasse Nr. "+number;
	}
	
}
