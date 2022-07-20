package com.kristileka.eucurrencyconverter.service.db;

import com.kristileka.eucurrencyconverter.service.db.entities.CurrencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyRecord, Long>, JpaSpecificationExecutor<CurrencyRecord> {
    List<CurrencyRecord> findAll();

    List<CurrencyRecord> findAllByDate(LocalDate date);

    @Query(value = """
            SELECT *
            FROM currency_record
            WHERE amount = (SELECT MIN(amount)
                            FROM currency_record
                            where amount != 0 and currency =  :currency and
                            date between :startDate and :endDate )
             and currency = :currency
             and date between :startDate and :endDate ;
            """, nativeQuery = true)
    CurrencyRecord findRecordRate(@Param("currency") String currency,
                                  @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = """
            SELECT AVG(amount)
                            FROM currency_record
                            where amount != 0
                              and currency = :currency
                              and date between :startDate and :endDate
              """, nativeQuery = true)
    Double findAverageRate(@Param("currency") String currency,
                            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    CurrencyRecord findByDateAndCurrency(LocalDate date, String currency);

    List<CurrencyRecord> findAllByCurrency(String currency);

}

