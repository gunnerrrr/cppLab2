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
                sort(Comparator.comparing(Employee::getSurname)));

        return postListOfEmployees;
    }

    public void PrintFirstMap(Map<String, ArrayList<Employee>> employeeMap) {
        employeeMap.entrySet().forEach(pair -> {
            System.out.println("\n Post is: " + pair.getKey());
            System.out.println("\n Oldest employee in this post is: " + pair.getValue().get(0));
            System.out.println("\n Youngest employee in this post is: " + pair.getValue().get(pair.getValue().size() - 1));
        });
    }
//2 task
    public HashMap<SalaryCategory,Employee> SecondMap (ArrayList<Employee> employeeArrayList) {
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
                employee.setSalaryCategory(SalaryCategory.hight);
            }
        }

        HashMap <SalaryCategory,Employee> mapForTask2=new HashMap<>();
        for(Employee employee:employeeArrayList) {
            mapForTask2.put(employee.getSalaryCategory(),employee);
        }
    return mapForTask2;
    }
    public void PrintSecondMap(Map<SalaryCategory, Employee> employeeMap) {
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
                if(employee.getYearOfBirth()!=year) {
                    newList.add(employee);
                }
            }
            return newList;
        }
    }




