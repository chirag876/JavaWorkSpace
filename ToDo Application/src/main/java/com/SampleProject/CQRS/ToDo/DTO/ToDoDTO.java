package com.SampleProject.CQRS.ToDo.DTO;

import lombok.Value;

@Value
public class ToDoDTO {
	private int taskId;
	private String TaskName;
	private String Status;
	public ToDoDTO(int taskId, String taskName, String status) {
		super();
		this.taskId = taskId;
		TaskName = taskName;
		Status = status;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
