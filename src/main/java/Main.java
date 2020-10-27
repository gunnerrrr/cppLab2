import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      ArrayList<Employee> employeeArrayList=new ArrayList<>();
      EmployeeManager employeeManager = new EmployeeManager();

      String fileName = "C:\\Users\\Admin\\Desktop\\employees.txt";
      ScanningFromFile scanningFromFile = new ScanningFromFile();
      employeeArrayList=scanningFromFile.readFromFile(fileName);

       while (true) {
          System.out.println("If you want to see 1 task press 1\n" +
                  "If you want to see 2 task press 2\n" +
                  "If you want to see 3 task press 3\n" +
                  "If you want to end press 0\n");
          Scanner scanner = new Scanner(System.in);
          int num=scanner.nextInt();

          if(num==1){
             HashMap<String, ArrayList<Employee>> firstMap= employeeManager.FirstMap(employeeArrayList);
             employeeManager.PrintFirstMap(firstMap);
          }
          if(num==2) {
             HashMap<SalaryCategory,Employee> secondMap= employeeManager.SecondMap(employeeArrayList);
             employeeManager.PrintSecondMap(secondMap);
          }
          if(num==3) {
             ArrayList < Employee> listOfEmployees = employeeManager.GetListOfEmployees();
             System.out.println(listOfEmployees);
             System.out.println("\n Enter year:");
             scanner=new Scanner(System.in);
             num=scanner.nextInt();
             listOfEmployees=employeeManager.DeleteEmployeeForYear(listOfEmployees,num);
             System.out.println(listOfEmployees);
          }
          if(scanner.nextInt()==0) {
             break;
          }
       }
    }
}


