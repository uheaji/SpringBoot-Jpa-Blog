package com.cos.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.test.domain.stadium.Stadium;
import com.cos.test.domain.team.Team;
import com.cos.test.service.StadiumService;
import com.cos.test.web.dto.CommonRespDto;
import com.cos.test.web.stadium.dto.StadiumSaveReqDto;
import com.cos.test.web.team.dto.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	
	private final StadiumService stadiumService;

	@GetMapping("/stadium/saveForm")
	public String saveForm() {
		return "stadium/stadiumSaveForm";
	}
	
	@GetMapping("/stadium") 
	public String findAll(Model model) {
		model.addAttribute("stadiums",stadiumService.전체찾기());
		return "stadium/stadiumList";
	}
	
	@PostMapping("/saveStadium")
	public String save(StadiumSaveReqDto stadiumSaveReqDto) {
		 Stadium stadium = stadiumSaveReqDto.toEntity();
		Stadium stadiumEntity = stadiumService.야구장등록(stadium, stadiumSaveReqDto.getTeamId());
		if (stadiumEntity == null) {
			return "stadium/stadiumSaveForm";
		} else {
			return "redirect:/stadium";
		}
		
	}
	
	@DeleteMapping("/stadium/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		stadiumService.삭제하기(id);
		return new CommonRespDto<>(1, null);
	}
}
