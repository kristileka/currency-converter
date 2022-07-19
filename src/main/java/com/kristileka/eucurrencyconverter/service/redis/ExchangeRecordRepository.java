package com.kristileka.eucurrencyconverter.service.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRecordRepository extends CrudRepository<ExchangeRecord, String> {
    List<ExchangeRecord> findAllByDate();
}
