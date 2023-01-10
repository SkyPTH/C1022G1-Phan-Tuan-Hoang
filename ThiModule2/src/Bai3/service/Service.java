package Bai3.service;

import Bai3.model.Model.SoTietKiem;
import model.repository.Repository;

import java.io.IOException;

public class Service implements IService{
    model.repository.IRepository repository=new Repository();
    @Override
    public void dangkySTK(SoTietKiem soTietKiem) throws IOException { repository.dangkySTK(soTietKiem);
    }
}
