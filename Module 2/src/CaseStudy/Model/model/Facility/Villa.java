package CaseStudy.Model.model.Facility;

public class Villa extends Facility {
    private String quality;
    public String poolArea;
    public String floorNumber;
    public Villa(String name, String area, String maxPeople, String typeRent, String quality, String poolArea, String floorNumber, String price) {
        super(name, area, maxPeople, typeRent,price);
        this.quality = quality;
        this.poolArea = poolArea;

        this.floorNumber = floorNumber;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }
    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "quality='" + quality + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                "} " + super.toString();
    }
}

