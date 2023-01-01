package CaseStudy.utils.ReadFile;

import CaseStudy.Model.model.Facility.Room;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomReadFile {
    public static List<Room> roomReadFile() throws IOException {
        List<Room> roomList = new ArrayList<>();
        FileReader fileReader = new FileReader("src/CaseStudy/utils/data/room.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] temp;
        Room room;
        while ((line = bufferedReader.readLine()) != null) {
            temp = line.split(",");
            String name = temp[0];
            String area = temp[1];
            String maxPeople = temp[2];
            String typeRent = temp[3];
            String price = temp[4];
            String freeService = temp[5];
            room = new Room( name, area,maxPeople,typeRent,freeService,price);
            roomList.add(room);
        }
        bufferedReader.close();
        return roomReadFile();
    }
}
