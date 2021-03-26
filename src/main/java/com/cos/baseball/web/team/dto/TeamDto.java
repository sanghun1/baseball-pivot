package com.cos.baseball.web.team.dto;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.team.Team;

import lombok.Data;

@Data
public class TeamDto {
	private String name;
	private Integer stadiumId;
	
	public Team toEntity() {
		return Team.builder()
				.name(name)				
				.build();
	}

}

