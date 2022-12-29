package CaseStudy.Model.model.Facility;

public abstract class Facility {
    private String name;
    private String area;
    private String maxPeople;
    private String typeRent;
    public String price;

    public Facility(String name, String area, String maxPeople, String typeRent, String price) {
        this.name = name;
        this.area = area;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
        this.price = price;
    }

    public Facility() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", maxPeople='" + maxPeople + '\'' +
                ", typeRent='" + typeRent + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
