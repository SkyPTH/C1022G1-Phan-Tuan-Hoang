package com.example.thi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class PCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "leader")
    @NotBlank(message = "Không được để trống")
    private String leader;
    @Column(name = "employee")
    @NotBlank(message = "Không được để trống")
    private String employee;
    @Column(name = "work_description")
    @NotBlank(message = "Không được để trống")
    private String workDescription;
    @Column(name = "start_day")
    @NotBlank(message = "Không được để trống")
    private String startDay;
    @Column(name = "end_day")
    @NotBlank(message = "Không được để trống")
    private String endDay;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public PCT(int id, String leader, String employee, String workDescription, String startDay, String endDay, Type type) {
        this.id = id;
        this.leader = leader;
        this.employee = employee;
        this.workDescription = workDescription;
        this.startDay = startDay;
        this.endDay = endDay;
        this.type = type;
    }

    public PCT() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
