package vu.quang.huy.services;

import java.util.List;
import java.util.Optional;

import vu.quang.huy.models.Cat;

public interface CatService {

	void saveCat(Cat cat);

	void deleteCat(int id);

	List<Cat> findAll();
	List<Cat> findByNameCat(String name);

	Optional<Cat> findCatById(int id);
	

}
