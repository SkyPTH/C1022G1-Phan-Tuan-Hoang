package CaseStudy.Model.repository.FacilityRepository;

import CaseStudy.Model.model.Facility.Villa;
import CaseStudy.Model.repository.IRepository;

public interface IFacilityRepository extends IRepository {
    void displayMaintenanceList();
    void addVilla(Object obj);
    void addRoom(Object obj);
}
