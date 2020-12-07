package com.oshaleiko.springbootrestreports.service;

import com.oshaleiko.springbootrestreports.domain.Report;
import com.oshaleiko.springbootrestreports.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@ComponentScan
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;
    
    public Report addReport(Report report) {
        reportRepository.save(report);
        return report;
    }

    public Optional<Report> findReportById(Long id) {
        return reportRepository.findById(id);
    }

    public List<Report> getAllReports() {
        List<Report> reportList = new ArrayList<>();
        reportRepository.findAll().forEach(reportList::add);
        return reportList;
    }

    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
}