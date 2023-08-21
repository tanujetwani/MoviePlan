package org.simplilearn.repositories;

import java.util.List;

import org.simplilearn.entities.Movie2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Movie2Repository extends JpaRepository<Movie2,Integer>{
	
	
	@Query(value="select * from movie2 m where m.name like %?1% OR m.language like %?1% OR  m.description like %?1% or m.show_date like %?1%  "
			    		+ " OR m.show_time like %?1% OR CONCAT(m.ticketprice, ' ') like %?1%",nativeQuery=true)
	List<Movie2> findByKeyword(String keyword);
	
	
	@Query(value="select * from movie2 m where m.genre_id In (:listofid)", nativeQuery=true)
	List<Movie2> findByGenreId(@Param ("listofid") List<Integer> listofid);
	
	@Query(value="select * from movie2 m where m.movie_id=?1",nativeQuery=true)
	Movie2 findByName(String name);
	

}
