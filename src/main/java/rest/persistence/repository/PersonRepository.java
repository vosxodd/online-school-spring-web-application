package rest.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest.persistence.entity.Person;
import rest.persistence.entity.Video;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM person", nativeQuery = true)
    List<Video> findAllPerson();
}

