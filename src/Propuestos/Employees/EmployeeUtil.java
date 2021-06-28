package Propuestos.Employees;
import java.util.*;

public abstract class EmployeeUtil {


    public static List<Employee> getEmployeesByFirstLetterLastname(List<Employee> employees, String letter) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (letter.equalsIgnoreCase(String.valueOf(employee.getLastname().charAt(0))))
                employeeList.add(employee);
        }

        return employeeList;
    }


    public static Map<String, Employee> getEmployeesOldYoung(List<Employee> employees) {
        Map<String, Employee> employeesMap = new HashMap<>();
        employees.sort(Comparator.comparing(Employee::getAge));

        employeesMap.put("joven", employees.get(0));
        employeesMap.put("viejo", employees.get(employees.size() - 1));
        return employeesMap;
    }


    public static Map<String, Employee> getEmployeesBestPoorSalary(List<Employee> employees) {
        Map<String, Employee> employeesMap = new HashMap<>();
        employees.sort(Comparator.comparing(Employee::getSalary));

        employeesMap.put("peor", employees.get(0));
        employeesMap.put("mejor", employees.get(employees.size() - 1));
        return employeesMap;
    }

}
