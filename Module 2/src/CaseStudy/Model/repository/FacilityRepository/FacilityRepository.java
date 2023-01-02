package CaseStudy.Model.repository.FacilityRepository;

import CaseStudy.Model.model.Booking;
import CaseStudy.Model.model.Facility.Facility;
import CaseStudy.Model.model.Facility.Room;
import CaseStudy.Model.model.Facility.Villa;
import CaseStudy.utils.ReadFile.RoomReadFile;
import CaseStudy.utils.ReadFile.VillaReadFile;
import CaseStudy.utils.WriteFile.VillaWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {

    private static Map<Room, Integer> roomMap = new LinkedHashMap();
    private static Map<Villa, Integer> villaMap = new LinkedHashMap();

    static {
        roomMap.put(new Room("Phòng 1", "30m2", "2 triệu", "Day", "massage", "2 triệu"), 1);
        villaMap.put(new Villa("Căn 1", "100 m2", "10 triệu", "4 người", "1 ngày", "4 sao",
                "20 m2", "3 tầng"), 5);
    }



    public void addVilla(Object obj) throws IOException {
        villaMap=VillaReadFile.villaReadFile() ;
      villaMap.put((Villa) obj,0);
        VillaWriteFile.villaWriteFile(villaMap);

    }


    public void addRoom(Object obj) throws IOException {
        roomMap= RoomReadFile.roomReadFile();
        roomMap.put((Room) obj,0);
        VillaWriteFile.villaWriteFile(villaMap);
    }

    @Override
    public void addNew(Object obj) {

    }

    @Override
    public void displayList() throws IOException {
        villaMap=VillaReadFile.villaReadFile() ;
        roomMap= RoomReadFile.roomReadFile();
        System.out.println("-----Danh sách Villa-------");
        for (Map.Entry<Villa, Integer>entry: villaMap.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue()+" lần");
        }
        System.out.println("-----Danh sách Room-------");
        for (Map.Entry<Room, Integer>entry: roomMap.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue()+" lần");
        }

    }
    @Override
    public void displayMaintenanceList () throws IOException {
        roomMap= RoomReadFile.roomReadFile();
        villaMap=VillaReadFile.villaReadFile() ;
        System.out.println("-----Danh sách Villa cần bảo trì-----");
        for (Map.Entry<Villa, Integer>entry: villaMap.entrySet()) { if (entry.getValue()>=5){

        }
            System.out.println(entry.getKey()+"-"+entry.getValue()+" lần");
    }
        System.out.println("-----Danh sách Room cần bảo trì-----");
        for (Map.Entry<Room, Integer>entry: roomMap.entrySet()) { if (entry.getValue()>=5){
        }
            System.out.println(entry.getKey()+"-"+entry.getValue()+" lần");
        }
}}
