package CaseStudy.Service.Facility;

import CaseStudy.Model.repository.FacilityRepository.FacilityRepository;
import CaseStudy.Model.repository.FacilityRepository.IFacilityRepository;
import CaseStudy.Service.Service;

import java.io.IOException;
import java.util.Map;

public class FacilityServiceImpl implements IFacilityService {

    IFacilityRepository facilityRepository=new FacilityRepository();
    @Override
    public void displayList() throws IOException {facilityRepository.displayList();
    }
    @Override
    public void addNew(Object obj) throws IOException {facilityRepository.addNew(obj);

    }

    @Override
    public void displayMaintenanceList() throws IOException {facilityRepository.displayMaintenanceList();}

    @Override
    public void addVilla(Object obj) throws IOException {facilityRepository.addVilla(obj);

    }

    @Override
    public void addRoom(Object obj) throws IOException {facilityRepository.addRoom(obj);

    }


}

