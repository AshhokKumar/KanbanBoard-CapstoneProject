package com.backend.kanban.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Employee {
    @Id
    private String employeeEmail;
    private String employeeName;
    private String employeeRole;
    private List<Task> taskList;



    public Employee(String employeeName, String employeeRole,String employeeEmail,List<Task> taskList) {
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.employeeEmail = employeeEmail;
        this.taskList = taskList;
    }

    public Employee(){

    };

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeEmail='" + employeeEmail + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
