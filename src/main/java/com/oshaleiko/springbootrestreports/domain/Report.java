package com.oshaleiko.springbootrestreports.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Please, provide name for your report.")
    private String name;

    @NotNull(message = "Please, provide description for your report.")
    private String description;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedTimeStamp;

    public Report() {
    }

    public Report(String name, String description, Date updatedTimeStamp) {
        this.name = name;
        this.description = description;
        this.updatedTimeStamp = updatedTimeStamp;
    }
}
