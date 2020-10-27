public class Employee {
    private String Surname;
    private String Post;
    private int yearOfBirth;
    private double salary;
    private SalaryCategory salaryCategory;
    public Employee(String surname, String post, int yearOfBirth, double salary) {
        Surname = surname;
        Post = post;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalaryCategory getSalaryCategory() {
        return salaryCategory;
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        this.salaryCategory = salaryCategory;
    }

    @Override
    public String toString() {
        return "\nEmployee post: "+ Post+ "\n surname: "+ Surname + "\n year of Birth: "+yearOfBirth
                +"\n salary: "+salary;
    }
}
