package CaseStudy.Model.model;

public class Booking {
    private String idBooking;
    private String dayStart;
    private String dayEnd;
    private String idCustomer;
    private String serviceName;

    public Booking(String idBooking, String dayStart, String dayEnd, String idCustomer, String serviceName) {
        this.idBooking = idBooking;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.idCustomer = idCustomer;
        this.serviceName = serviceName;
    }

    public Booking() {
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", dayStart='" + dayStart + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
