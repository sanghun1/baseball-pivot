package com.cos.baseball.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.StadiumService;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.team.dto.TeamDto;
import com.cos.baseball.service.StadiumService;
import com.cos.baseball.service.TeamService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class TeamController {
	private final TeamService teamService;
	private final StadiumService stadiumService;
	
	@GetMapping("/team/teamAdd")
	public String regForm(Model model) {
		List<Stadium> stadiumList = new ArrayList<>();
		List<Stadium> stadiums = stadiumService.야구장목록();
		for (Stadium stadium : stadiums) {
			if(stadium.getTeam()==null) {
				stadiumList.add(stadium);
			}
		}
		
		model.addAttribute("stadiums", stadiumList);
		return "team/teamAddForm";
	}
	
	@PostMapping("/team/teamList")
	public String save(TeamDto teamSaveReqDto) {
		Team teamEntity = teamSaveReqDto.toEntity();
		Stadium stadiumEntity = stadiumService.야구장찾기(teamSaveReqDto.getStadiumId());
		teamEntity.setStadium(stadiumEntity);
		teamService.팀등록(teamEntity);
		return "redirect:/team/teamList";
	}
	
	@GetMapping("/team/teamList")
	public String findAll(Model model) {
		List<Team> teams = teamService.팀목록();
		model.addAttribute("teams", teams);
		return "team/teamListForm";
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		teamService.팀삭제(id);
		return new CMRespDto<>(1,null);
	}
	
}
