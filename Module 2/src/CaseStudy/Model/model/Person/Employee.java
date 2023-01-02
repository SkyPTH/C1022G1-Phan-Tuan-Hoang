package CaseStudy.Model.model.Person;

public class Employee extends Person {
    private String level;
    private String position;
    private String wage;

    public Employee(String id, String name, String birth, String gender, String cmndNumber, String phoneNumber, String eMail, String level, String position, String wage) {
        super(id, name, birth, gender, cmndNumber, phoneNumber, eMail);
        this.level = level;
        this.position = position;
        this.wage = wage;
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

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
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
                ", wage=" + wage +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
