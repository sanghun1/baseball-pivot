package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamRepository teamRepository;
	
	@Transactional
	public void 팀등록(Team team) {
		teamRepository.save(team);
	}
	
	@Transactional(readOnly = true)
	public List<Team> 팀목록(){
		return teamRepository.findAll();
	}
	
	@Transactional
	public void 팀삭제(int id) {
		teamRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Team 팀찾기(int id) {
		Team teamEntity = teamRepository.findById(id).get();
		return teamEntity;
	}
	
}