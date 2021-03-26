package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.service.StadiumService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.stadium.dto.StadiumDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	private final StadiumService stadiumService;

	@GetMapping("/stadium/stadiumAdd")
	public String regForm() {
		return "stadium/stadiumAddForm";
	}

	@PostMapping("/stadium/stadiumList")
	public String save(StadiumDto stadiumDto) {
		Stadium stadiumEntity = stadiumDto.toEntity();
		stadiumService.야구장등록(stadiumEntity);
		return "redirect:/stadium/stadiumList";
	}

	@GetMapping("/stadium/stadiumList")
	public String findAll(Model model) {
		List<Stadium> stadiums = stadiumService.야구장목록();
		model.addAttribute("stadiums", stadiums);
		return "stadium/stadiumListForm";
	}

	@DeleteMapping("/stadium/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		stadiumService.야구장삭제(id);
		return new CMRespDto<>(1, null);
	}

}
