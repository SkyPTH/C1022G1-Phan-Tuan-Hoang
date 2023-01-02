package CaseStudy.utils.ReadFile;

import CaseStudy.Model.model.Facility.Villa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VillaReadFile {

    public static Map<Villa,Integer> villaReadFile() throws IOException {
        Map<Villa,Integer> villaMap = new LinkedHashMap<>();
        FileReader fileReader = new FileReader("D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Module 2\\src\\CaseStudy\\utils\\data\\villa.csv");
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
            villaMap.put(villa,Integer.parseInt(temp[8]));
        }
        bufferedReader.close();
        return villaMap;
    }

}
