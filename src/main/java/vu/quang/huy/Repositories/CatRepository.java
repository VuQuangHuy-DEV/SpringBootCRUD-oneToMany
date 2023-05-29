package vu.quang.huy.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vu.quang.huy.models.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer> {
 
	//List<Cat> findCatByNameLike(String cat_Name);
	//lúc tìm thì thêm % nam% vào
	
	@Query("SELECT c FROM Cat c WHERE c.cat_Name LIKE %:name%")
    List<Cat> findCatsByCatName(@Param("name") String name);
}
