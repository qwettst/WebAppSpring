package dev.qwett.service.impl;

import dev.qwett.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface StoreRepository extends JpaRepository<Store, Integer> {
    /**
     * Поиск записей по имени адреса
     *
     * @param address имя искомого адреса в сущности
     */
    @Query("select main from Store main where lower(main.address) like lower(concat( '%',:address,'%'))")
    List<Store> findByAddress(@Param("address") String address);
}
