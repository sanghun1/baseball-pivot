package com.cos.baseball.web.stadium.dto;

import com.cos.baseball.domain.stadium.Stadium;

import lombok.Data;

@Data
public class StadiumDto {
	private String name;
	
	public Stadium toEntity() {
		return Stadium.builder()
				.name(name)
				.build();
	}
}

