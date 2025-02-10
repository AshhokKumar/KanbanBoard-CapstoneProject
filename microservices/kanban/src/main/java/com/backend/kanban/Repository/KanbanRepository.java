package com.backend.kanban.Repository;

import com.backend.kanban.Domain.Employee;
import com.backend.kanban.Domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KanbanRepository extends MongoRepository<Employee,String> {
  Employee findByEmail(String employeeEmail);
}
