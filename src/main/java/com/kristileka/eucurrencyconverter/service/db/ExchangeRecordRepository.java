package com.kristileka.eucurrencyconverter.service.db;

import com.kristileka.eucurrencyconverter.service.db.entities.ExchangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExchangeRecordRepository extends JpaRepository<ExchangeRecord, Long>, JpaSpecificationExecutor<ExchangeRecord> {
    List<ExchangeRecord> findAll();

    List<ExchangeRecord> findAllByDate(LocalDate date);

    ExchangeRecord findByDateAndCurrency(LocalDate date, String currency);

    List<ExchangeRecord> findAllByCurrency(String currency);

}

