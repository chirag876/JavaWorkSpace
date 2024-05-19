package com.SampleProject.CQRS.ToDo.event;

import lombok.Data;

@Data
public class CreateToDoEvent {
	
	private final int taskId;
	private final String TaskName;
	private final String Status;
	public CreateToDoEvent(int taskId, String taskName, String status) {
		super();
		this.taskId = taskId;
		TaskName = taskName;
		Status = status;
	}
	public int getTaskId() {
		return taskId;
	}

	public String getTaskName() {
		return TaskName;
	}

	public String getStatus() {
		return Status;
	}


	
}
