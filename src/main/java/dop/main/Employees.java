package dop.main;

public class Employees {

    double salary;
    double bonus;
    String name;
    String post;

    public Employees(double salary, String name, String post, double bonus) {
        this.salary = salary;
        this.name = name;
        this.post = post;
        this.bonus = bonus;
    }

    public String getPost() {
        return post;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", bonus='" + bonus + '\'' +
                '}';
    }
}
