package com.dynamic.dynamicScheduling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynamic.dynamicScheduling.model.Tasks;
import com.dynamic.dynamicScheduling.service.TaskService;

@RestController
public class TaskController {
	@Autowired
	private TaskService task;
	
		@GetMapping("/tasks")
		public List<Tasks> getAllTasks(){
			return task.getallTask();
		}
		
		@GetMapping("/tasks/{id}")
		public Tasks gettingTaskByID(@PathVariable("id") long id) {
			return task.getTaskById(id);
		}
		@PostMapping("/tasks")
		public Tasks createtask(@RequestBody Tasks ts){
			return task.createTaskIn(ts);
		}
		@PutMapping("/tasks/{id}")
		public Tasks updateTask(@PathVariable("id")long id, @RequestBody Tasks ts){
			return updateTask(id,ts);
		}
		@DeleteMapping("/tasks/{id}")
		public Tasks deleteTasks(@PathVariable("id") long id){
			return null;
		}
}
