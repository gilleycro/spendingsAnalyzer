package com.debugaholic.spendingsanalyzer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Spending {

    @Id
    private Integer id;

    private Integer amount;

    private Date date;
}
