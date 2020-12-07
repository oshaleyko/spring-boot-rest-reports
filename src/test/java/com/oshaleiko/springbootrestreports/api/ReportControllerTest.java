package com.oshaleiko.springbootrestreports.api;

import com.oshaleiko.springbootrestreports.domain.Report;
import com.oshaleiko.springbootrestreports.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit Testing with @WebMvcTest
 */

@RunWith(SpringRunner.class)
@WebMvcTest(ReportController.class)
public class ReportControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReportService reportService;


    @Test
    public void getAllReports() throws Exception {
        List<Report> reportList = new ArrayList<>();
        Report financialReport = new Report(
                "Financial Statement",
                "Includes detail on operating and non-operating activities", new Date());
        Report dailyReport = new Report(
                "Daily Report",
                "Includes detail on operating daily activities", new Date());
        reportList.add(financialReport);
        reportList.add(dailyReport);

        given(reportService.getAllReports()).willReturn(reportList);

        mvc.perform(get("/reports")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getReportById() throws Exception {
        Report report = new Report(
                "Financial Statement",
                "Includes detail on operating and non-operating activities", new Date());
        reportService.findReportById(2L);

        mvc.perform(get("/reports/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteReport() throws Exception {
        Report report = new Report(
                "Financial Statement",
                "Includes detail on operating and non-operating activities", new Date());
        reportService.deleteById(1L);

        mvc.perform(get("/reports/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveReport() throws Exception {
        Report report = new Report(
                "Financial Statement",
                "Includes detail on operating and non-operating activities", new Date());
        given(reportService.addReport(report)).willReturn(report);

        mvc.perform(get("/reports")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}