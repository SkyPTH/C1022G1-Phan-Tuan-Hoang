package CaseStudy.Model.model.Facility;

public abstract class Facility {
    private String name;
    private String area;
    private String maxPeople;
    private String typeRent;

    public Facility(String name, String area, String maxPeople, String typeRent) {
        this.name = name;
        this.area = area;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
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

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", maxPeople=" + maxPeople +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }
}
