package com.cqrs.demo.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindCarQuery {
	
	private int Id;


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	

}
