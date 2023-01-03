package CaseStudy.utils.WriteFile;

import CaseStudy.Model.model.Facility.Room;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RoomWriteFile {
    public static void roomWriteFile(Map<Room,Integer> roomMap) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Module 2\\src\\CaseStudy\\utils\\data\\room.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(Map.Entry<Room,Integer> entry:roomMap.entrySet())
        bufferedWriter.write(entry.getKey().getName() + ',' + entry.getKey().getArea() + ',' + entry.getKey().getMaxPeople() + ','
                + entry.getKey().getTypeRent() + ',' + entry.getKey().getFreeService() + ',' + entry.getKey().getPrice());
        bufferedWriter.close();
    }
}
