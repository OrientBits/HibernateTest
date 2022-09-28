package com.map.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int id;
    @Column(name = "Project_name")
    private String projectName;

    @ManyToMany(mappedBy = "projectList")
    private List<Emp> empList;

    public Project() {
    }

    public Project(int id, String projectName, List<Emp> empList) {
        this.id = id;
        this.projectName = projectName;
        this.empList = empList;
    }

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        this.id = pId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
