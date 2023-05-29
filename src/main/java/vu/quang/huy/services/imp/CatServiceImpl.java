package vu.quang.huy.services.imp;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vu.quang.huy.Repositories.BreadRepository;
import vu.quang.huy.Repositories.CatRepository;
import vu.quang.huy.models.Cat;
import vu.quang.huy.services.CatService;
@Service
public class CatServiceImpl implements CatService{
	
	@Autowired
	private CatRepository catRepository;
	@Autowired
	private BreadRepository breadRepository;

	@Override
	public void saveCat(Cat cat) {
		catRepository.save(cat);
		
	}

	@Override
	public void deleteCat(int id) {
		Cat cat = catRepository.findById(id).get();
		
		breadRepository.findById(cat.getBread().getBread_Id()).get().getCats().remove(cat);
		
		catRepository.delete(cat);
		
		
	}

	@Override
	public List<Cat> findAll() {
		// TODO Auto-generated method stub
		return catRepository.findAll();
	}

	@Override
	public Optional<Cat> findCatById(int id) {
		// TODO Auto-generated method stub
		return catRepository.findById(id);
	}

	@Override
	public List<Cat> findByNameCat(String name) {
		
		return catRepository.findCatsByCatName(name);
	}

}
