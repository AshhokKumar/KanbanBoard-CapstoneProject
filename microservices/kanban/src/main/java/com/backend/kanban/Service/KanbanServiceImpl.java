package com.backend.kanban.Service; //Ashok has made changes

import com.backend.kanban.Exception.EmployeeAlreadyExistsException;
import com.backend.kanban.Exception.EmployeeNotFoundException;
import com.backend.kanban.Exception.TaskAlreadyExistsException;
import com.backend.kanban.Proxy.EmployeeProxy;
import com.backend.kanban.Repository.KanbanRepository;
import com.backend.kanban.Domain.Employee;
import com.backend.kanban.Domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanbanServiceImpl implements KanbanService{
    private KanbanRepository kanbanRepository;
    private EmployeeProxy employeeProxy;

    @Autowired
    public KanbanServiceImpl(KanbanRepository kanbanRepo,EmployeeProxy employeeProxy){
        this.kanbanRepository=kanbanRepository;
        this.employeeProxy = employeeProxy;
    }


    //Register new Employee
    @Override
    public Employee registerEmployee(Employee employee) throws EmployeeAlreadyExistsException{
        if(kanbanRepository.findById(employee.getEmployeeEmail()).isPresent()){
            throw new EmployeeAlreadyExistsException();
        }
        Employee saveEmployee = kanbanRepository.save(employee);
        if(!(saveEmployee.getEmployeeEmail().isEmpty())){
            ResponseEntity r = employeeProxy.saveEmployee(employee);
            System.out.println(r.getBody());
        }
        return saveEmployee;
    }
    // Get all employees
    @Override
    public List<Employee> getAllEmployees() {
        return kanbanRepository.getAllEmployees();
    }

    // Get all tasks
    @Override
    public List<Task> getAllTasks() {
        return kanbanRepository.getAllTasks();
    }

    // Create a new task
    @Override
    public Task createTask(Task task,List<Employee> listOfEmployee ) throws TaskAlreadyExistsException, EmployeeNotFoundException {

        for(int i=0;i<listOfEmployee.size();i++)
        {
            if(kanbanRepository.findById(task.getTaskId()))
            {

            }
        }
        if(kanbanRepository.findById(task.getTaskTitle()).isPresent()){
        throw new TaskAlreadyExistsException();
       }
       Task newTask = kanbanRepository.save(task);

    }

    // Update task progress and status
    @Override
    public Task updateTask(int taskId, int taskProgress, String taskStatus) {
        Optional<Task> taskOpt = kanbanRepository.findById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setTaskProgress(taskProgress);
            task.setTaskStatus(taskStatus);
            return kanbanRepository.save(task);
        }
        return null;
    }

    // Delete a task by task name
    @Override
    public Task deleteTask(int taskId) {
        List<Task> tasks = kanbanRepository.findAll();
        for (Task task : tasks) {
            if (task.getTaskTitle().equals(taskName)) {
                kanbanRepository.delete(task);
                return true;
            }
        }
        return false;
    }
}
