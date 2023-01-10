package model.repository;

import Bai3.model.Model.SoTietKiem;

import java.io.IOException;

public interface IRepository {
    void dangkySTK(SoTietKiem soTietKiem) throws IOException;
}
