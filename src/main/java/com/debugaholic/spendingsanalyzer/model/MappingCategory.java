package com.debugaholic.spendingsanalyzer.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="mapping_category")
public class MappingCategory {

    @Id
    private Integer id;

    private String mapper;

    @OneToMany
    @JoinColumn(name="mapper_id", referencedColumnName = "id")
    private List<Spending> spendings;
}
