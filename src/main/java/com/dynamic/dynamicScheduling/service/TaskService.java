package com.dynamic.dynamicScheduling.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dynamic.dynamicScheduling.model.Tasks;
import com.dynamic.dynamicScheduling.repository.TaskRepository;

@Component
public class TaskService {
		
	private TaskRepository taskRepo;
	
	final static Logger logger = LoggerFactory.getLogger(TaskService.class);
	
	@Scheduled(cron= "#{@getCronExpressionFromDb}")
	public void scheduledTask() {
		logger.info("TaskService is executed at {}", LocalDateTime.now());
		
	}
	
	@Bean
	public String getCronExpressionFromDb() {
		//in future dynamic pass with string variable
		Tasks ts = taskRepo.getTaskByName("TaskService");
		
		return ts.getExpression();
	}
	//--------------------------------------------------------------
	//gettinng all task
	public List<Tasks> getallTask(){
		return taskRepo.findAll();
	}
	
	
	
	//save the task
	public Tasks createTaskIn(Tasks ts) {
		return taskRepo.save(ts);
	}
	//getting by id
	public Tasks getTaskById(long id) {
		
		return taskRepo.getById(id);
	}
	
	//update it is impleneted further
	public Tasks  updateTask(long id, Tasks ts) {
		return null;
	}
	
	//delete
	public void deteleTasks(long id) {
		 taskRepo.deleteById(id);
	}
	
}
