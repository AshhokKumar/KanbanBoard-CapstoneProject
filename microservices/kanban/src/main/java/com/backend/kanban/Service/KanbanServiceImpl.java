package com.backend.kanban.Service;

import com.backend.kanban.Exception.EmployeeAlreadyExistsException;
import com.backend.kanban.Exception.EmployeeNotFoundException;
import com.backend.kanban.Exception.TaskAlreadyExistsException;
import com.backend.kanban.Exception.TaskNotFoundException;
import com.backend.kanban.Repository.EmployeeRepository;
import com.backend.kanban.Repository.TaskRepository;
import com.backend.kanban.Domain.Employee;
import com.backend.kanban.Domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanbanServiceImpl implements KanbanService {
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public KanbanServiceImpl(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    // Register new Employee
    @Override
    public Employee registerEmployee(Employee employee) throws EmployeeAlreadyExistsException {
        if (employeeRepository.findById(employee.getEmployeeEmail()).isPresent()) {
            throw new EmployeeAlreadyExistsException();
        }
        return employeeRepository.save(employee);
    }

    // Get all employees
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get an employee by email
    @Override
    public Employee getEmployeeByEmail(String email) throws EmployeeNotFoundException {
        return employeeRepository.findById(email)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    // Assign a task to an employee
    @Override
    public Employee assignTaskToEmployee(String employeeEmail, int taskId) throws EmployeeNotFoundException, TaskNotFoundException {
        Employee employee = employeeRepository.findById(employeeEmail)
                .orElseThrow(EmployeeNotFoundException::new);

        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);

        List<Task> taskList = employee.getTaskList();
        if (!taskList.contains(task)) {
            taskList.add(task);
            employee.setTaskList(taskList);
            return employeeRepository.save(employee);
        }
        return employee; // Task is already assigned, return the employee as-is.
    }

    // Get all tasks
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get a task by ID (fixed exception)
    @Override
    public Task getTaskById(int taskId) throws TaskNotFoundException {
        return taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
    }

    // Create a new task with assigned employees
    @Override
    public Task createTask(Task task, List<Employee> assignedEmployees) throws TaskAlreadyExistsException {
        if (taskRepository.findById(task.getTaskId()).isPresent()) {
            throw new TaskAlreadyExistsException();
        }

        // Assign employees to the task
        task.setAssignedEmployees(assignedEmployees);
        return taskRepository.save(task);
    }

    // Update task progress and status (fixed exception)
    @Override
    public Task updateTask(int taskId, int taskProgress, String taskStatus) throws TaskNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);

        task.setTaskProgress(taskProgress);
        task.setTaskStatus(taskStatus);
        return taskRepository.save(task);
    }

    // Delete a task by task ID
    @Override
    public boolean deleteTask(int taskId) throws TaskNotFoundException {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException();
        }
        taskRepository.deleteById(taskId);
        return true;
    }
}
