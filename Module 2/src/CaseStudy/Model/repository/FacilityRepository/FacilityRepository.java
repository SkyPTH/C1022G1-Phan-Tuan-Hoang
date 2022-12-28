package CaseStudy.Model.repository.FacilityRepository;

import CaseStudy.Model.model.Booking;
import CaseStudy.Model.model.Facility.Facility;
import CaseStudy.Model.model.Facility.Room;
import CaseStudy.Model.model.Facility.Villa;

import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository{
    private static List<Room> roomList=new ArrayList<>();
    private static List<Villa> villaList=new ArrayList<>();
    static {
        roomList.add(new Room());
        villaList.add(new Villa());
    }

    @Override
    public void addNew(Object obj) {

    }

    @Override
    public void displayList() {

    }
}
