import java.util.*;

public class Mensa extends Thread {

    private final List<Student> students;
    private final List<Cashpoint> cashpoints;

    private Mensa() {
        this.students = new ArrayList<Student>();
        this.cashpoints = new ArrayList<Cashpoint>();
    }

    static Mensa create() {
        return new Mensa();
    }

    public void add(Cashpoint kasse) {
       
        cashpoints.add(kasse);
    }

    public void add(Student student) {
       
        students.add(student);
    }

    public Cashpoint cashPoint() {
       
        Cashpoint result = null;
        int minQueue = Integer.MAX_VALUE;
        synchronized (this) {
        for (Cashpoint cashpoint : cashpoints) {
            if (cashpoint.queueLength() < minQueue) {
                result = cashpoint;
                minQueue = cashpoint.queueLength();
            }
        }  }
        return result;
      
    }

    @Override
    public void start() {

        for (Student student : students) {
  
            student.start();
        }
       
        super.start();
        System.out.println("Start the Action");
    }

   
    public void interrupt() {
        synchronized (this) {
            System.out.println("INTERUPT MENSA!!!!");
            for (Student s : students) {
                System.out.println("INTERUPT Stundent " + s);
                s.interrupt();
            }
            super.interrupt();
        }
    }

}
