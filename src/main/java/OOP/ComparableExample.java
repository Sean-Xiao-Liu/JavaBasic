package OOP;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ComparableExample{




    public static void main(String[] args) {
//        int[] a = {3,5,2,6,10};
//        Arrays.sort(a);// use Arrays.sort to sort an array
//        for(int i:a){
//            System.out.println(i);
//        }

        Student s1 = new Student();
        s1.setId(1);
        s1.setAge(1);
        s1.setName("xyz");

        Student s2 = new Student();
        s2.setId(2);
        s2.setAge(2);
        s2.setName("abc");

        Student[] students = new Student[2];
        students[0] = s2;
        students[1] = s1;

        // use comparable interface, sort by natural order of id
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // use comparator interface, sort by name
        Arrays.sort(students,Student.NameComparator);
        System.out.println(Arrays.toString(students));
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
    public static Comparator<Student> IdComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId()-o2.getId();
        }
    };

    //name comparator
    public static Comparator<Student> NameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    @Override
    public String toString(){
    return "The student name is "+ this.name + " whose age is "+this.age;
    }

}
