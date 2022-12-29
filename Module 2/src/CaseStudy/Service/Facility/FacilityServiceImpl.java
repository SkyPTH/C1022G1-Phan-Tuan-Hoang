package CaseStudy.Service.Facility;

import CaseStudy.Model.repository.FacilityRepository.FacilityRepository;
import CaseStudy.Model.repository.FacilityRepository.IFacilityRepository;
import CaseStudy.Service.Service;

import java.util.Map;

public class FacilityServiceImpl implements IFacilityService {

    IFacilityRepository facilityRepository=new FacilityRepository();
    @Override
    public void displayList() {facilityRepository.displayList();
    }
    @Override
    public void addNew(Object obj) {facilityRepository.addNew(obj);

    }

    @Override
    public void displayMaintenanceList() {facilityRepository.displayMaintenanceList();}

    @Override
    public void addVilla(Object obj) {facilityRepository.addVilla(obj);

    }

    @Override
    public void addRoom(Object obj) {facilityRepository.addRoom(obj);

    }


}

