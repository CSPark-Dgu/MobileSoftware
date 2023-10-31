import java.util.Scanner;
import java.util.ArrayList;

class Employee{
    String myName;
    int myWage;
    public Employee(String n, int w) {
        myName = n;
        myWage = w;
    }
}

public class ThirdProblem {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        for(int i=0;i<5;i++){
            System.out.println("Enter employee name : ");
            String name = scan.nextLine();
            System.out.println("Enter employee wage : ");
            int wage = Integer.parseInt(scan.nextLine());

            Employee employee = new Employee(name, wage);
            employees.add(employee);
        }
        Employee highestEmployee = findEmployee(employees);
        System.out.println("Employee with the highest wage is " + highestEmployee.myName);
    }

    public static Employee findEmployee(ArrayList<Employee> employees){
        if(employees.isEmpty()) return null;
        Employee target = employees.get(0);
        for(Employee employee : employees){
            if(employee.myWage>target.myWage){
                target=employee;
            }
        }

        return target;
    }
}
