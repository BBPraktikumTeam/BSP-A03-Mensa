import java.util.*;


public class Mensa extends Thread {

	private final List<Student> students;
	private final List<Cashpoint> cashpoints;
	
	private Mensa(){
		this.students=new ArrayList<Student>();
		this.cashpoints=new ArrayList<Cashpoint>();
	}
	
	static Mensa create(){
		return new Mensa();
	}
	
	public void add(Cashpoint kasse){
		cashpoints.add(kasse);
	}
	public void add(Student student){
		students.add(student);
	}
	
	public Cashpoint cashPoint(){
		Cashpoint cashpoint=null;
		return cashpoint;
	}
	
	@Override
	public void start(){
		for(Student student: students){
			student.start();
		}
		this.run();
	}
	
	
	
	@Override
	public void run(){
		while(true){
			
		}
	}
	
}
