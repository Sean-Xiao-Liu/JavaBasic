package CoreJava;

import java.util.Date;

public class Immutable {

    public static void main(String[] args) {
        ImmutableStudent student = new ImmutableStudent(1,"Nina",new Date());
        System.out.println(student);
    }
}

final class ImmutableStudent{ // put final before class so it won't be inheritable
    private final int id;
    private final String name;
    private final Date enrollDate;


    //constructor
    public ImmutableStudent(int id, String name, Date enrollDate) { // make constructor private to ensure no unplanned construction
        this.id = id;
        this.name = name;
        this.enrollDate = new Date(enrollDate.getTime());// date should be mutable to change as time may varies
    }

//    //Factory method
//    public static ImmutableStudent createStudent(int id, String name, Date enrollDate){
//        return new ImmutableStudent(id,name,enrollDate);
//    }

    //provide no setter method

    //getter methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getEnrollDate() {
        return new Date(enrollDate.getTime());
    }

    @Override
    public String toString(){
        return "The student is\t" + this.name + ", whose student id is\t" + this.id + ", with the enroll date is\t" + this.enrollDate;
    }

}