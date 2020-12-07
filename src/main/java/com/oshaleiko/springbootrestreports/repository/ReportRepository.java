package com.oshaleiko.springbootrestreports.repository;

import com.oshaleiko.springbootrestreports.domain.Report;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {

}
