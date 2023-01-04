package CaseStudy.Model.repository.FacilityRepository;

import CaseStudy.Model.model.Facility.Room;
import CaseStudy.Model.model.Facility.Villa;
import CaseStudy.utils.ReadFile.RoomReadFile;
import CaseStudy.utils.ReadFile.VillaReadFile;
import CaseStudy.utils.WriteFile.RoomWriteFile;
import CaseStudy.utils.WriteFile.VillaWriteFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {

    private static Map<Room, Integer> roomMap = new LinkedHashMap();
    private static Map<Villa, Integer> villaMap = new LinkedHashMap();

//    static {
//        roomMap.put(new Room("SVRO", "30m2", "2", "Day", "Massage", "500"), 1);
//        villaMap.put(new Villa("SVVL", "100m2", "7", "Month", "Deluxe", "35.4",
//                "5", "1200"), 5);
//    }


    public void addVilla(Object obj) throws IOException {
        villaMap = VillaReadFile.villaReadFile();
        villaMap.put((Villa) obj, 0);
        VillaWriteFile.villaWriteFile(villaMap);

    }


    public void addRoom(Object obj) throws IOException {
        roomMap = RoomReadFile.roomReadFile();
        roomMap.put((Room) obj, 0);
        RoomWriteFile.roomWriteFile(roomMap);
    }

    @Override
    public void addNew(Object obj) {

    }

    @Override
    public void displayList() throws IOException {
        villaMap = VillaReadFile.villaReadFile();
        roomMap = RoomReadFile.roomReadFile();
        System.out.println("-----Danh sách Villa-------");
        for (Map.Entry<Villa, Integer> entry : villaMap.entrySet()) {
            System.out.println(entry.getKey() + "- Số lần sử dụng: " + entry.getValue() + " lần");
        }
        System.out.println("-----Danh sách Room-------");
        for (Map.Entry<Room, Integer> entry : roomMap.entrySet()) {
            System.out.println(entry.getKey() + "- Số lần sử dụng: " + entry.getValue() + " lần");
        }

    }

    @Override
    public void displayMaintenanceList() throws IOException {
        roomMap = RoomReadFile.roomReadFile();
        villaMap = VillaReadFile.villaReadFile();
        System.out.println("-----Danh sách Villa cần bảo trì-----");
        for (Map.Entry<Villa, Integer> entry : villaMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + "- Số lần sử dụng: " + entry.getValue() + " lần");
            }

        }
        System.out.println("-----Danh sách Room cần bảo trì-----");
        for (Map.Entry<Room, Integer> entry : roomMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + "-" + entry.getValue() + " lần");
            }

        }
    }
}
