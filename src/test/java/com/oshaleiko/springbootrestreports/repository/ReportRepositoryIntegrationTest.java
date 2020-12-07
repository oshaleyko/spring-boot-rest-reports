package com.oshaleiko.springbootrestreports.repository;

import com.oshaleiko.springbootrestreports.domain.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration Testing with @DataJpaTest
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReportRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReportRepository reportRepository;

    @Test
    public void findById() {
        // given
        Report financialReport = new Report(
                "Financial Statement", "Formal records of the financial activities", new Date());
        entityManager.persist(financialReport);
        entityManager.flush();
        // when
        Optional<Report> report = reportRepository.findById(financialReport.getId());
        // then
        assertThat(report)
                .isEqualTo(Optional.of(financialReport));
    }
}