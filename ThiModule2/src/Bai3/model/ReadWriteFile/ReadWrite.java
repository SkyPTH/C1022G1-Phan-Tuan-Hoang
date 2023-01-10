package model.ReadWriteFile;

import Bai3.model.Model.SoTietKiem;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class ReadWrite {
    public static Map<SoTietKiem,Integer> readFile() throws IOException {
        Map<SoTietKiem,Integer> soTietKiemIntegerMap=new TreeMap<>();
        FileReader fileReader1=new FileReader("D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\ThiModule2\\src\\Bai3\\model\\ReadWriteFile\\data.csv");
        BufferedReader bufferedReader1=new BufferedReader(fileReader1);
        String line;
        String [] temp;
        SoTietKiem soTietKiem;
        while ((line= bufferedReader1.readLine())!=null){
            temp=line.split(",");
            String idSTK= temp[1];
            String idKH= temp[2];
            String soTien= temp[3];
            String kyHan= temp[4];
            String laiSuat= temp[5];
            SoTietKiem soTietKiem1=new SoTietKiem(idSTK,idKH,soTien,kyHan,laiSuat);
            soTietKiemIntegerMap.put(soTietKiem1,Integer.parseInt(temp[0]));
        }
        bufferedReader1.close();
        return soTietKiemIntegerMap;
    }
    public static void writeFile(Map<SoTietKiem,Integer> soTietKiemIntegerMap) throws IOException {

        FileWriter fileWriter=new FileWriter("D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\ThiModule2\\src\\Bai3\\model\\ReadWriteFile\\data.csv");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for (Map.Entry<SoTietKiem,Integer> entry1: soTietKiemIntegerMap.entrySet()){
            bufferedWriter.write(entry1.getValue()+','+entry1.getKey().getIdSTK()+','+entry1.getKey().getIdKH()+
                    ','+entry1.getKey().getSoTien()+entry1.getKey().getKyHan()+entry1.getKey().getLaiSuat());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    }




