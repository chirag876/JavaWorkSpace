package com.SampleProject.CQRS.ToDo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
public class ToDo {
	@javax.persistence.Id
	private int taskId;
	private String TaskName;
	private String Status;
	public ToDo(int taskId, String taskName, String status) {
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
