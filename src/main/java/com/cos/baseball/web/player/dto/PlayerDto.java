package com.cos.baseball.web.player.dto;

import com.cos.baseball.domain.player.Player;

import lombok.Data;

@Data
public class PlayerDto {
	private String name;
	private String position;
	private Integer teamId;
	
	public Player toEntity() {
		return Player.builder()
				.name(name)
				.position(position)
				.build();
	}
}
