package CaseStudy.Model.repository.FacilityRepository;

import CaseStudy.Model.model.Facility.Room;
import CaseStudy.Model.model.Facility.Villa;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {

    private static final Map<Room, Integer> roomMap = new LinkedHashMap();
    private static final Map<Villa, Integer> villaMap = new LinkedHashMap();

    static {
        roomMap.put(new Room("Phòng 1", "30m2", "2 triệu", "Day", "massage", "2 triệu"), 1);
        villaMap.put(new Villa("Căn 1", "100 m2", "10 triệu", "4 người", "1 ngày", "4 sao",
                "20 m2", "3 tầng"), 5);
    }


    @Override
    public void addVilla(Object obj) {

        villaMap.put((Villa) obj, 0);

    }

    @Override
    public void addRoom(Object obj) {
        roomMap.put((Room) obj, 0);

    }

    @Override
    public void displayList() {
        System.out.println("-----Danh sách Villa-------");
        for (Map.Entry<Villa, Integer> entry : villaMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("-----Danh sách Room-------");
        for (Map.Entry<Room, Integer> entry : roomMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }

    @Override
    public void displayMaintenanceList() {
        System.out.println("-----Danh sách Villa cần bảo trì-----");
        for (Map.Entry<Villa, Integer> entry : villaMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }

        }
    }
}
