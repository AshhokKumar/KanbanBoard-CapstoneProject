package com.backend.kanban.Domain;

import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.List;

public class Task {
    @Id
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskPriority;
    private String taskStatus;
    private int taskProgress;
    private List<String> taskComments;

    public Task() {
    }

    public Task(int taskId, String taskTitle, String taskDescription, String taskPriority, String taskStatus, int taskProgress,  List<String> taskComments) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.taskProgress = taskProgress;
        this.taskComments = taskComments;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(int taskProgress) {
        this.taskProgress = taskProgress;
    }

    public List<String> getTaskComments() {
        return taskComments;
    }

    public void setTaskComments(List<String>taskComments) {
        this.taskComments = taskComments;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskPriority='" + taskPriority + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskProgress=" + taskProgress +
                ", taskComments=" + taskComments +
                '}';
    }
}
