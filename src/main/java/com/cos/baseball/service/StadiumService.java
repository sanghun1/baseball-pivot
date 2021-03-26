package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.stadium.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {

	private final StadiumRepository stadiumRepository;
	
	@Transactional
	public void 야구장등록(Stadium stadium) {
		stadiumRepository.save(stadium);
	}
	
	@Transactional(readOnly = true)
	public List<Stadium> 야구장목록(){
		return stadiumRepository.findAll();
	}
	
	@Transactional
	public void 야구장삭제(int id) {
		stadiumRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Stadium 야구장찾기(int stadiumId) {
		Stadium stadiumEntity = stadiumRepository.findById(stadiumId).get();
		return stadiumEntity;
	}
	
}