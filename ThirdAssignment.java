import java.util.ArrayList;
import java.util.Vector;

abstract class Person {
    String personName;
    String birthDate;
    String homeAddress;

    public Person(String name, String date, String address) {
        this.personName = name;
        this.birthDate = date;
        this.homeAddress = address;
    }

    public String getName() {
        return personName;
    }

    public String getBirthDate() {
        return birthDate;
    }
}

class Employee extends Person {
    String employeeID;
    int monthlySalary;

    public Employee(String name, String date, String address, int salary, String id) {
        super(name, date, address);
        this.employeeID = id;
        this.monthlySalary = salary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }
}

class Student extends Person {
    String studentID;
    double GPA;

    public Student(String name, String date, String address, double gpa, String id) {
        super(name, date, address);
        this.studentID = id;
        this.GPA = gpa;
    }

    public double getGPA() {
        return GPA;
    }
}

public class ThirdAssignment {
     public static void main(String[] args) {
        Vector<Person> people = new Vector<Person>();

        // Employee instances
        people.add(new Employee("Kim", "1999/04/15", "Gangnam, Seoul", 5500, "10001000"));
        people.add(new Employee("Lee", "1999/03/21", "Jeju, Jeju Island", 6000, "20002000"));
        people.add(new Employee("Park", "2001/12/05", "Suwon, Gyeonggi", 5000, "30003000"));
        people.add(new Employee("Choi", "2000/02/10", "Haewoondae, Busan", 8000, "40004000"));
        people.add(new Employee("Jung", "2002/07/29", "Nowon, Seoul", 9000, "50005000"));

        // Student instances
        people.add(new Student("ParkChangsu", "1999/03/23", "Anyang, Gyeonggi", 3.8, "2019112163"));
        people.add(new Student("JoChangUk", "1999/03/06", "Gwanak, Seoul", 4.5, "2019112174"));
        people.add(new Student("LeeEunJi", "2000/01/14", "Seodaemun, Seoul", 3.7, "2018113172"));
        people.add(new Student("SongYoungJun", "1999/05/27", "Jongro, Seoul", 3.6, "4567890123"));
        people.add(new Student("KimYoonSeong", "1999/01/08", "Suwon, Gyeonggi", 3.8, "2021112149"));

        for (Person person : people) {
            System.out.println("Name: " + person.getName());
        }
    }
}
