package OOP;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashCode{



    public static void main(String[] args) {
        /*** Test if two employees are the same ***/
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setId(1);
        employee2.setId(1);
        employee1.setAge(25);
        employee2.setAge(25);
        employee1.setName("A");
        employee2.setName("A");

//        System.out.println(employee1.equals(employee2));

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee1);
        employees.add(employee2);
        System.out.println(employees.toString());// fixed up override the
    }
}

class Employee{
   private long id;
   private String name;
   private int age;
   private long salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    /*** Override the equals method ***/
    @Override
    //default part
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;

        //develop the new equals logic, the important part
        Employee other = (Employee) obj;
        return (this.getId() == other.getId());

    }

    /*** Has to override the hashCode method so the hash methods won't be messed ***/
    @Override
    public int hashCode(){
//        return Objects.hash(id,name,age);
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int) this.getId();// use (int) to cast long to int
        return result;
    }

    @Override
    public String toString() {
        return "The employee id is\t" + this.id + ",whose name is\t" + this.name + "\tand his age is\t"+this.age;
    }


}
