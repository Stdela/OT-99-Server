package com.alkemy.ong.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
public class CategoryDtoGetAll {
	
	private String name;

	public CategoryDtoGetAll(String name) {
		this.name=name;
	}

	

}
