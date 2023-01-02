package CaseStudy.Service.Facility;

import CaseStudy.Service.IService;

import java.io.IOException;

public interface IFacilityService extends IService {
    @Override
    void displayList() throws IOException;
    void displayMaintenanceList() throws IOException;
    void addVilla(Object obj) throws IOException;
    void addRoom(Object obj) throws IOException;

}
