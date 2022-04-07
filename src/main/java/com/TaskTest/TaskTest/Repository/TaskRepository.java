package com.TaskTest.TaskTest.Repository;

import com.TaskTest.TaskTest.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
