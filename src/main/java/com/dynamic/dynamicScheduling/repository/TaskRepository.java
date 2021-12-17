package com.dynamic.dynamicScheduling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dynamic.dynamicScheduling.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
	
	Tasks getTaskByName(String name);
	Tasks getTaskById(Long id);
	
}
