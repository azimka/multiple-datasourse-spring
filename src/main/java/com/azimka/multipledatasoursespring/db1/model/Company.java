package com.azimka.multipledatasoursespring.db1.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Company {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date foundationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }
}
