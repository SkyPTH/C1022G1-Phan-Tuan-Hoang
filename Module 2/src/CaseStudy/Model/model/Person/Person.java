package CaseStudy.Model.model.Person;

public abstract class Person implements Comparable <Person>{
private String id;
private String name;
private String birth;
private String gender;
private String cmndNumber;
private String phoneNumber;
private String eMail;

    public Person(String id, String name, String birth, String sex, String cmndNumber, String phoneNumber, String eMail) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender=sex;
        this.cmndNumber = cmndNumber;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmndNumber() {
        return cmndNumber;
    }

    public void setCmndNumber(String cmndNumber) {
        this.cmndNumber = cmndNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", sex=" + gender +
                ", cmndNumber='" + cmndNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
