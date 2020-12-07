package com.oshaleiko.springbootrestreports.api;

import com.oshaleiko.springbootrestreports.domain.Report;

import com.oshaleiko.springbootrestreports.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/reports")
public class ReportController {

    final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity addReport(@RequestBody Report report) {
        Report newReport = reportService.addReport(report);
        return ResponseEntity.status(HttpStatus.OK).body(newReport);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    ResponseEntity getReportById(@PathVariable Long id) {
        Optional<Report> report = reportService.findReportById(id);
        return ResponseEntity.status(HttpStatus.OK).body(report);
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    ResponseEntity deleteReport(@PathVariable Long id) {
        reportService.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
    }
}

