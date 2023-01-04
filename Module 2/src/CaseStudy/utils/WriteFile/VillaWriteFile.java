package CaseStudy.utils.WriteFile;

import CaseStudy.Model.model.Facility.Villa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VillaWriteFile {
    public static void villaWriteFile(Map<Villa,Integer> villaMap) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Module 2\\src\\CaseStudy\\utils\\data\\villa.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(Map.Entry<Villa,Integer> entry: villaMap.entrySet()){
        bufferedWriter.write(entry.getKey().getName() + ',' + entry.getKey().getArea() + ',' + entry.getKey().getMaxPeople()
                + ',' + entry.getKey().getTypeRent() + ',' + entry.getKey().getQuality()
                + ',' + entry.getKey().getFloorNumber() + ',' + entry.getKey().getPoolArea()+
                ',' + entry.getKey().getPrice()+','+entry.getValue());
        bufferedWriter.newLine();
        };
        bufferedWriter.close();
    }
}
