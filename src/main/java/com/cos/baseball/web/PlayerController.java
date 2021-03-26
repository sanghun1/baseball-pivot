package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.dto.PlayerPositionRespDto;
import com.cos.baseball.web.player.dto.PlayerDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	private final PlayerService playerService;
	private final TeamService teamSerivce;
	
	@GetMapping("/player/playerAdd")
	public String regForm(Model model) {
		List<Team> teams = teamSerivce.팀목록();
		model.addAttribute("teams", teams);
		return "player/playerAddForm";
	}
	
	@PostMapping("/player/playerList")
	public String save(PlayerDto playerDto) {
		Player playerEntity = playerDto.toEntity();
		Team teamEntity = teamSerivce.팀찾기(playerDto.getTeamId());
		playerEntity.setTeam(teamEntity);
		playerService.선수등록(playerEntity);
		return "redirect:/player/playerList";
	}
	
	@GetMapping("/player/playerList")
	public String findAll(Model model) {
		List<Player> players = playerService.선수목록();
		model.addAttribute("players", players);
		return "player/playerListForm";
	}
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		playerService.선수삭제(id);
		return new CMRespDto<>(1,null);
	}
	
	@GetMapping("/player/positionList")
	public String positionList(Model model) {
		List<PlayerPositionRespDto> dtos = playerService.포지션별선수리스트();
		model.addAttribute("dtos", dtos);
		return "player/positionList";
	}
	
}
