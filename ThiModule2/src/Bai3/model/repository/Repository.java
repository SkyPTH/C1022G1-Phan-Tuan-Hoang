package model.repository;

import Bai3.model.Model.SoTietKiem;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Repository implements model.repository.IRepository {
    private static Map<SoTietKiem, Integer> soTietKiemIntegerMap=new LinkedHashMap<>();
    @Override
    public void dangkySTK(SoTietKiem soTietKiem) throws IOException {
        soTietKiemIntegerMap= model.ReadWriteFile.ReadWrite.readFile();
        soTietKiemIntegerMap.put(soTietKiem,0);
        model.ReadWriteFile.ReadWrite.writeFile(soTietKiemIntegerMap);

    }
}
