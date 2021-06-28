package Propuestos.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void main(String[] args)  throws IOException, InterruptedException {
        List<Employee> employeeList = loadEmployees();

        
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  

        System.out.println("Empleados con una letra específica en el apellido.");
        for (Employee e: EmployeeUtil.getEmployeesByFirstLetterLastname(employeeList, "S")) {
            System.out.println(e);
        }

        System.out.println("\nEmpleado más viejo y empleado más joven.");
        Map<String, Employee> oldYoungMap = EmployeeUtil.getEmployeesOldYoung(employeeList);
        oldYoungMap.forEach((k,v) -> System.out.println(k +
                ":\nEmpleado: " + v.getName() + " " + v.getLastname() +
                " - Edad: " + v.getAge()));

        System.out.println("\nEmpleado con mejor y peor salario.");
        Map<String, Employee> bestPoorSalariesMap = EmployeeUtil.getEmployeesBestPoorSalary(employeeList);
        bestPoorSalariesMap.forEach((k,v) -> System.out.println(k +
                ":\nEmpleado: " + v.getName() + " " + v.getLastname() +
                " - Salario: " + v.getSalary()));
    }


    public static List<Employee> loadEmployees() {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String[] employee;
        List<Employee> employeeList = new ArrayList<>();

        try {
            file = new File("src/Propuestos/Employees/employees.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                employee = line.split(",");
                employeeList.add(new Employee(employee[0], employee[1], employee[2], employee[3]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (null != fileReader)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return employeeList;
    }
}
