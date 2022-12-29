package CaseStudy.Model.model.Facility;

public class Room extends Facility{
    private String freeService;

    public Room(String name, String area, String maxPeople, String typeRent, String freeService, String price) {
        super(name, area, maxPeople, typeRent,price);
        this.freeService = freeService;
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +"name='" + this.getName() + '\'' +
                ", area=" + this.getArea() +
                ", maxPeople=" + this.getMaxPeople() +
                ", typeRent='" + this.getTypeRent() + '\'' +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
