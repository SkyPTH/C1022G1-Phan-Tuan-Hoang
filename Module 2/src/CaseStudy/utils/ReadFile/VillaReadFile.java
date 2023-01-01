package CaseStudy.utils.ReadFile;

import CaseStudy.Model.model.Facility.Room;
import CaseStudy.Model.model.Facility.Villa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VillaReadFile {
    public class RoomReadFile {
        public static List<Villa> villaReadFile() throws IOException {
            List<Villa> villaList = new ArrayList<>();
            FileReader fileReader = new FileReader("src/CaseStudy/utils/data/villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            Villa villa;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                String name = temp[0];
                String area = temp[1];
                String maxPeople = temp[2];
                String typeRent = temp[3];
                String price = temp[4];
                String quality = temp[5];
                String poolArea = temp[6];
                String floorNumber = temp[7];
                villa = new Villa(name, area, maxPeople, typeRent, price, quality, poolArea, floorNumber);
                villaList.add(villa);
            }
            bufferedReader.close();
            return villaReadFile();
        }

    }}
