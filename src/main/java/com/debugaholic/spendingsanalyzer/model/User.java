package com.debugaholic.spendingsanalyzer.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    private Integer id;

    private String first_name;
    private String last_name;
    private String nickname;

    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private List<Spending> spendings;
}
