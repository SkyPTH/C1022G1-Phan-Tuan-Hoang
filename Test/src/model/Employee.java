package model;

public class Employee {
    private String id;
    private String name;
    private String eMail;
    private String address;

    public Employee(String id, String name, String eMail, String address) {
        this.id = id;
        this.name = name;
        this.eMail = eMail;
        this.address = address;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
