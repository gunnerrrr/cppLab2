import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanningFromFile {
    public ArrayList<Employee> readFromFile (String fileName) throws IOException {

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            Employee emp = parseCSVLine(scanner.next());
            employeeArrayList.add(emp);
        }
        scanner.close();
        return  employeeArrayList;
    }
    public  Employee parseCSVLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*,\\s*");
        String surname = scanner.next();
        String post = scanner.next();
        int yearOfBirth = scanner.nextInt();
        String s_salary=scanner.next();
        double salary=Double.parseDouble(s_salary);
        return new Employee(surname,post ,yearOfBirth,salary);
    }
}
