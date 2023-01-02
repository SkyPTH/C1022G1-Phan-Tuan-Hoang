package CaseStudy.Model.model.Person;

public class Customer extends Person {
    private String type;
    private String address;

    public Customer(String id, String name, String birth, String gender, String cmndNumber, String phoneNumber, String eMail, String type, String address) {
        super(id, name, birth, gender, cmndNumber, phoneNumber, eMail);
        this.type = type;
        this.address = address;
    }

    public Customer(String type, String address) {
        this.type = type;
        this.address = address;
    }

    public Customer() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +"id=" + this.getId()+
                ", name='" + this.getName() + '\'' +
                ", birth='" + this.getBirth() + '\'' +
                ", gender=" + this.getGender() +
                ", cmndNumber='" + this.getCmndNumber() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", eMail='" + this.geteMail() + '\'' +
                "type='" + type + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
