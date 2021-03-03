package CoreJava;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableExample{

    // the comparator doesn't need to be with the class
    public static Comparator<Student> ageComparator = ((o1, o2) -> o2.getAge() - o1.getAge());

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(1);
        s1.setAge(1);
        s1.setName("xyz");

        Student s2 = new Student();
        s2.setId(2);
        s2.setAge(2);
        s2.setName("abc");

        Student s3 = new Student();
        s3.setId(3);
        s3.setAge(0);
        s3.setName("jkl");

        Student[] students = new Student[3];
        students[0] = s3;
        students[1] = s2;
        students[2] = s1;

        // print the info of students in their default order
        System.out.println("The default order is" + Arrays.toString(students));

        // use comparable interface, sort by natural order of id
        Arrays.sort(students);
        System.out.println("By comparable interface" + Arrays.toString(students));

        // use comparator interface, sort by name
        Arrays.sort(students,Student.nameComparator);
        System.out.println("By name comparator interface" + Arrays.toString(students));

        // use comparator interface, sort by age
        Arrays.sort(students,ageComparator);
        System.out.println("By age comparator interface" + Arrays.toString(students));

        // use comparator interface, sort by id
        Arrays.sort(students,Student.idComparator);
        System.out.println("By id comparator interface" + Arrays.toString(students));

        //lambda expression
        Arrays.sort(students,(o1,o2)->o2.getId()-o1.getId());
    }
}

class Student implements Comparable<Student>{

    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        return this.getId() -o.getId();
    }

    //id comparator
    // smaller id comes first
    public static Comparator<Student> idComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId()-o2.getId();
        }
    };

    //name comparator
    public static Comparator<Student> nameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    // age comparator with lambda expression
    // comparator is functional interface, can apply lambda expression
    // o2 - o1 means larger object comes first
    public static Comparator<Student> ageComparator = ((o1, o2) -> o2.getAge() - o1.getAge());


    @Override
    public String toString(){
    return "The student name is "+ this.getName() + " whose age is "+this.getAge() + " with id " + this.getId();
    }

}
