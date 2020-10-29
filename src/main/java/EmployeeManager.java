
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
    

public class EmployeeManager {
//first task
    public HashMap<String, ArrayList<Employee>> FirstMap(List<Employee> employeesList) {
        HashMap<String, ArrayList<Employee>> postListOfEmployees = new HashMap<>();
        for (Employee employee : employeesList) {
            ArrayList<Employee> value = postListOfEmployees.get(employee.getPost());
            if (value == null) {
                postListOfEmployees.put(employee.getPost(), new ArrayList<Employee>() {
                            {
                                add(employee);
                            }
                        }
                );
            } else {
                value.add(employee);
            }
        }
        postListOfEmployees.forEach((key, value) -> value.
                sort(Comparator.comparing(Employee::getYearOfBirth)));

        return postListOfEmployees;
    }

    public void PrintFirstMap(Map<String, ArrayList<Employee>> employeeMap) {
        employeeMap.forEach((key, value) -> {
            System.out.println("\n Post is: " + key);
            System.out.println("\n Oldest employee in this post is: " + value.get(0));
            System.out.println("\n Youngest employee in this post is: " + value.get(value.size() - 1));
        });
    }
//2 task
    public HashMap<SalaryCategory, ArrayList<Employee>> SecondMap (ArrayList<Employee> employeeArrayList) {
        Optional<Employee> maxSalaryEmployee= employeeArrayList.stream().max(Comparator.comparing(Employee::getSalary));
        Optional<Employee> minSalaryEmployee= employeeArrayList.stream().min(Comparator.comparing(Employee::getSalary));
        double maxSalary=maxSalaryEmployee.get().getSalary();
        double minSalary=minSalaryEmployee.get().getSalary();
        double middleSalary=(maxSalary+minSalary)/2;

        for(Employee employee:employeeArrayList) {
            if(employee.getSalary()<(middleSalary/1.5)) {
                employee.setSalaryCategory(SalaryCategory.low);
            }
            else if(employee.getSalary()<(middleSalary*1.5) && employee.getSalary()>(middleSalary/1.5)) {
                employee.setSalaryCategory(SalaryCategory.medium);
            }
            else{
                employee.setSalaryCategory(SalaryCategory.high);
            }
        }
        ArrayList<Employee> lowSalEmp=new ArrayList<>();
        ArrayList<Employee> medSalEmp=new ArrayList<>();
        ArrayList<Employee> highSalEmp=new ArrayList<>();


        HashMap <SalaryCategory, ArrayList<Employee>> mapForTask2=new HashMap<>();
        for(Employee employee:employeeArrayList) {
            if(employee.getSalaryCategory()==SalaryCategory.low) {
                lowSalEmp.add(employee);
            }
            if(employee.getSalaryCategory()==SalaryCategory.medium) {
                medSalEmp.add(employee);
            }
            if(employee.getSalaryCategory()==SalaryCategory.high) {
                highSalEmp.add(employee);
            }
        }
        mapForTask2.put(SalaryCategory.low,lowSalEmp);
        mapForTask2.put(SalaryCategory.medium,medSalEmp);
        mapForTask2.put(SalaryCategory.high,highSalEmp);

        return mapForTask2;
    }
    public void PrintSecondMap(Map<SalaryCategory, ArrayList<Employee>> employeeMap) {
        employeeMap.forEach((key, value) -> {
            System.out.println("\n Salary Category is:" + key);
            System.out.println("\n Information about employee: " + value);
        });
    }
//3 task
    public  ArrayList<Employee> GetListOfEmployees () throws IOException {
            ScanningFromFile scanningFromFile = new ScanningFromFile();
            ArrayList<Employee> firstEmployeeList;
            ArrayList<Employee> secondEmployeeList;
            String firstFileName = "C:\\Users\\Admin\\Desktop\\employees1.txt";
            String secondFileName = "C:\\Users\\Admin\\Desktop\\employees2.txt";
            firstEmployeeList = scanningFromFile.readFromFile(firstFileName);
            secondEmployeeList = scanningFromFile.readFromFile(secondFileName);

            List<Employee> allEmployeeList = new ArrayList<>();
            allEmployeeList.addAll(firstEmployeeList);
            allEmployeeList.addAll(secondEmployeeList);

            return new ArrayList<>(allEmployeeList.stream()
                    .collect(Collectors
                            .toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getSurname)))));
        }
        public ArrayList<Employee> DeleteEmployeeForYear(ArrayList<Employee> employeeArrayList, int year) {
        ArrayList<Employee> newList=new ArrayList<>();
            for (Employee employee:employeeArrayList) {
                if(employee.getYearOfBirth()>=year) {
                    newList.add(employee);
                }
            }
            return newList;
        }
    }




