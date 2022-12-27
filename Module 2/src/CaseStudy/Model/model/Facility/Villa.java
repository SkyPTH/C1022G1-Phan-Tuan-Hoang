package CaseStudy.Model.model.Facility;

public class Villa extends Facility {
    private String quality;
    public String poolArea;
    public String price;
    public String floorNumber;

    public Villa(String name, String area, String maxPeople, String typeRent, String quality, String poolArea, String price, String floorNumber) {
        super(name, area, maxPeople, typeRent);
        this.quality = quality;
        this.poolArea = poolArea;
        this.price = price;
        this.floorNumber = floorNumber;
    }

    public Villa() {
    }

    public Villa(String quality, String poolArea, String price, String floorNumber) {
        this.quality = quality;
        this.poolArea = poolArea;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
                ", price='" + price + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                "} " + super.toString();
    }
}

