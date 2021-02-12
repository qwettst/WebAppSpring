package dev.qwett.webappspring.services.impl;

import dev.qwett.webappspring.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface StoreRepository extends JpaRepository<Store, Integer> {
    /**
     * Поиск записей по address
     *
     * @param address
     */
    @Query("select main from Store main where lower(main.address) like lower(concat( '%',:address,'%'))")
    List<Store> findByAddress(@Param("address") String address);
}
