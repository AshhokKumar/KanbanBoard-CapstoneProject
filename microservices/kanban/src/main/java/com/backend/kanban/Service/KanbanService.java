package com.backend.kanban.Service;

import com.backend.kanban.Domain.Employee;
import com.backend.kanban.Domain.Task;
import com.backend.kanban.Exception.EmployeeAlreadyExistsException;
import com.backend.kanban.Exception.EmployeeNotFoundException;
import com.backend.kanban.Exception.TaskAlreadyExistsException;
import com.backend.kanban.Exception.TaskNotFoundException;

import java.util.List;

public interface KanbanService {

    // Register a new employee
    Employee registerEmployee(Employee employee) throws EmployeeAlreadyExistsException;

    // Create a new task and assign employees to it
    Task createTask(Task task, List<Employee> assignedEmployees)
            throws TaskAlreadyExistsException, EmployeeNotFoundException, EmployeeAlreadyExistsException;

    // Update task progress and status
    Task updateTask(int taskId, int taskProgress, String taskStatus) throws TaskNotFoundException;

    // Delete a task by ID
    boolean deleteTask(int taskId) throws TaskNotFoundException;

    // Get all employees
    List<Employee> getAllEmployees();

    // Get all tasks
    List<Task> getAllTasks();

    // Get an employee by email
    Employee getEmployeeByEmail(String employeeEmail) throws EmployeeNotFoundException;

    // Get a task by ID
    Task getTaskById(int taskId) throws TaskNotFoundException;

    // Assign an existing task to an employee
    Employee assignTaskToEmployee(String employeeEmail, int taskId)
            throws EmployeeNotFoundException, TaskNotFoundException;
}
