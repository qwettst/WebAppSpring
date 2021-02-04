package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {

    @Query("select main from Consumer main where lower(main.firstName) like lower(concat( '%',:name,'%')) or lower(main.lastName) like lower(concat( '%',:name,'%'))")
    List<Consumer> findByName(@Param("name") String name);

}
