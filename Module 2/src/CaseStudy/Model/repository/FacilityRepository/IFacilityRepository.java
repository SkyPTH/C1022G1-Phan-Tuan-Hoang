package CaseStudy.Model.repository.FacilityRepository;

import CaseStudy.Model.model.Facility.Villa;
import CaseStudy.Model.repository.IRepository;

import java.io.IOException;

public interface IFacilityRepository extends IRepository {
    void displayMaintenanceList() throws IOException;
    void addVilla(Object obj) throws IOException;
    void addRoom(Object obj) throws IOException;
}
