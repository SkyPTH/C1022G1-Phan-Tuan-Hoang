package CaseStudy.Model.model.Person;

public class Employee extends Person {
    private String level;
    private String position;
    private String salary;

    public Employee(String id, String name, String birth, String gender, String cmndNumber, String phoneNumber, String eMail, String level, String position, String salary) {
        super(id, name, birth, gender, cmndNumber, phoneNumber, eMail);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
        "id=" + this.getId()+
                ", name='" + this.getName() + '\'' +
                ", birth='" + this.getBirth() + '\'' +
                ", gender=" + this.getGender() +
                ", cmndNumber='" + this.getCmndNumber() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", eMail='" + this.geteMail() + '\'' +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
