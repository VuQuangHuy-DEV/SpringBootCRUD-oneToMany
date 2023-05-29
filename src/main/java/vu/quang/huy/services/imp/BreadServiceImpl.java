package vu.quang.huy.services.imp;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vu.quang.huy.Repositories.BreadRepository;
import vu.quang.huy.models.Bread;
import vu.quang.huy.services.BreadService;

@Service

public class BreadServiceImpl implements BreadService {
	@Autowired
	private BreadRepository breadRepository;

	@Override
	public void saveBread(Bread bread) {
		breadRepository.save(bread);

	}

	@Override
	public void deleteBread(int id) {
		Bread bread = breadRepository.findById(id).get();
		
		breadRepository.delete(bread);
		//breadRepository.deleteById(id);
		
	}

	@Override
	public List<Bread> findAll() {
		// TODO Auto-generated method stub
		return breadRepository.findAll();
	}

	@Override
	public Optional<Bread> findBreadById(int id) {
		// TODO Auto-generated method stub
		return breadRepository.findById(id);
	}

}
