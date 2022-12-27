package CaseStudy.Service.Facility;

import CaseStudy.Service.Service;

public interface IFacilityService extends Service {
    @Override
    void displayList();
    void displayMaintenanceList();

}
