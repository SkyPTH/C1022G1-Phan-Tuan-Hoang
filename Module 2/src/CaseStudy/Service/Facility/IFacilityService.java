package CaseStudy.Service.Facility;

import CaseStudy.Service.IService;

public interface IFacilityService extends IService {
    @Override
    void displayList();
    void displayMaintenanceList();

}
