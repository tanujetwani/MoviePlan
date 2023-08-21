package org.simplilearn.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer>{
	
	
	@Query(value="select g.genreId from org.simplilearn.entities.Genre g where g.genreName like %?1%")
	List<Integer> findByGenreName(String keyword);
	
	
	@Transactional
	@Modifying
	@Query(value="delete from genre g where g.genre_id=?1",nativeQuery=true)
	int deleteById(int id);
	
	
	@Transactional
	@Modifying
	@Query(value="delete from genre g where g.genre_name=?1",nativeQuery=true)
	int deleteByGenreName(String name);

	
	//@Query(value="select count(*) from genre g where g.genre-name like %?1% ",nativeQuery=true)
	//int findByGenreName(String name);
}
