package com.cos.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.web.dto.PlayerPositionRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	private final EntityManager entityManager;
	
	@Transactional
	public void 선수등록(Player player) {
		playerRepository.save(player);
	}
	
	@Transactional(readOnly = true)
	public List<Player> 선수목록(){
		return playerRepository.findAll();
	}
	
	@Transactional
	public void 선수삭제(int id) {
		playerRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<PlayerPositionRespDto> 포지션별선수리스트(){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("position, ");
		sb.append("MAX(if(teamId = 10, name, \"\")) LG, ");
		sb.append("MAX(if(teamId = 11, name, \"\")) LOTTE, ");
		sb.append("MAX(if(teamId = 12, name, \"\")) SAMSUNG ");
		sb.append("from player ");
		sb.append("GROUP BY position ");
		Query q = entityManager.createNativeQuery(sb.toString());
		JpaResultMapper result = new JpaResultMapper();
		List<PlayerPositionRespDto> playerPositionRespDto = result.list(q, PlayerPositionRespDto.class);
		return playerPositionRespDto;
	}
}