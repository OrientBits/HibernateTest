package com.map.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Emp {
    @Id
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "emp_learn",
            joinColumns = {@JoinColumn(name = "eid")},
            inverseJoinColumns = {@JoinColumn(name = "pid")}
    )
    private List<Project> projectList;


    public Emp() {
    }

    public Emp(int id, String name, List<Project> projectList) {
        this.id = id;
        this.name = name;
        this.projectList = projectList;
    }

    public int geteId() {
        return id;
    }

    public void setId(int eId) {
        this.id = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
