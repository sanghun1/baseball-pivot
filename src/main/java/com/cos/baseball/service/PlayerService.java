package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	
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
	
}