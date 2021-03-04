package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
    /**
     * Поиск записей по firstName и lastName
     *
     * @param name имя или фамилия по которой идет поиск в сущности
     * @return все найденные сущности
     */
    @Query("select main from Consumer main where lower(main.firstName) like lower(concat( '%',:name,'%')) or lower(main.lastName) like lower(concat( '%',:name,'%'))")
    List<Consumer> findByName(@Param("name") String name);
}
