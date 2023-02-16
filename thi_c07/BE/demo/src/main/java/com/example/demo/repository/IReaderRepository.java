package com.example.demo.repository;

import com.example.demo.model.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IReaderRepository extends JpaRepository<Reader, Long> {

    @Query(value = "select * from reader where delete_reader = 0 ", nativeQuery = true)
    Page<Reader> findAll(Pageable pageable);

    @Modifying
    @Query(value = " update reader set delete_reader = 1 where id = :id ", nativeQuery = true)
    @Transactional
    void delete(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update demo_book.reader set name = :name , year_old = :yearOld , id_book = :idBook where (id = :id)", nativeQuery = true)
    void update(
            @Param("name") String name,
            @Param("yearOld") int yearOld,
            @Param("idBook") long idBook,
            @Param("id") long id);
}
