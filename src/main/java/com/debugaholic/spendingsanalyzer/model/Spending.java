package com.debugaholic.spendingsanalyzer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Spending {

    @Id
    private Integer id;

    private Double amount;

    private Date date;
}
