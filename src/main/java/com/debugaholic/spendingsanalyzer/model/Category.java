package com.debugaholic.spendingsanalyzer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {

    @Id
    private Integer id;

    @OneToMany
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private List<MappingCategory> mappingCategories;

    private String category;
}
