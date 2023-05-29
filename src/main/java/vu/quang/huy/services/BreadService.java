package vu.quang.huy.services;

import java.util.List;
import java.util.Optional;

import vu.quang.huy.models.Bread;

public interface BreadService {
    void saveBread(Bread bread);
    void deleteBread (int id);
    List<Bread> findAll();
    Optional<Bread> findBreadById(int id);
    
}
