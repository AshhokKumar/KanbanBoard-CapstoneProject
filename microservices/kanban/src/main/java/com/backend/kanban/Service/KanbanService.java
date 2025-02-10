package com.backend.kanban.Service;

import com.backend.kanban.Domain.Employee;
import com.backend.kanban.Domain.Task;
import com.backend.kanban.Exception.EmployeeAlreadyExistsException;
import com.backend.kanban.Exception.EmployeeNotFoundException;
import com.backend.kanban.Exception.TaskAlreadyExistsException;

import java.util.List;

public interface KanbanService {
    Employee registerEmployee(Employee employee) throws EmployeeAlreadyExistsException;
    Employee createTask(Task task,List<String> employeeEmail) throws TaskAlreadyExistsException, EmployeeNotFoundException;
    Employee updateTask(int taskId, int taskProgress, String taskStatus);
    Employee deleteTask(int taskId);
    List<Employee> getAllEmployees();
    List<Task> getAllTasks();


}
