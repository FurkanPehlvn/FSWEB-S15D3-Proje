package org.example;


import org.example.entity.Employee;

import java.util.*;

import static org.example.WordCounter.calculatedWord;


public class Main {

    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;



    public static void main(String[] args) {


        System.out.println("Hello World!");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ahmet", "Can"));
        employees.add(new Employee(1, "Ahmet", "Can"));
        employees.add(new Employee(2, "Mehmet", "Sahin"));
        employees.add(new Employee(3, "Mahmut", "Oyku"));
        employees.add(new Employee(4, "Murtaza", "Kara"));
        employees.add(new Employee(5, "Ayşe", "Teyze"));
        employees.add(new Employee(5, "Ayşe", "Teyze"));
        employees.add(new Employee(6, "Fatma", "Abla"));
        System.out.println(findDuplicates(employees));
        System.out.println(findUniques(employees));


        System.out.println(calculatedWord());
    }


    public static List<Employee> findDuplicates(List<Employee> employees) {

        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {

            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null kayit");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {

                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){

        employeeMap = new HashMap<>();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {

            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null kayit");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {

                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;

    }

    public static List<Employee> removeDuplicates(List<Employee> employees){

      List<Employee> duplicates= findDuplicates(employees);
       Map<Integer,Employee> uniques= findUniques(employees);
       List<Employee> onlyUnique= new LinkedList<>(uniques.values());

       onlyUnique.removeAll(duplicates);

       return onlyUnique;
    }











}