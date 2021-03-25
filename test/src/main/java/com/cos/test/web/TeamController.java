package com.cos.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.test.domain.team.Team;
import com.cos.test.service.TeamService;
import com.cos.test.web.dto.CommonRespDto;
import com.cos.test.web.team.dto.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	
	@GetMapping("/team/saveForm")
	public String saveForm() {
		return "team/teamSaveForm";
	}
	
	@GetMapping("/team") 
	public String findAll(Model model) {
		model.addAttribute("teams",teamService.팀찾기());
		return "team/teamList";
	}
	
	@PostMapping("/saveTeam")
	public String save(TeamSaveReqDto teamSaveReqDto) {
		Team team = teamSaveReqDto.toEntity();
		Team teamEntity = teamService.팀등록(team);
		if (teamEntity == null) {
			return "team/teamSaveForm";
		} else {
			return "redirect:/team";
		}
		
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		teamService.삭제하기(id);
		return new CommonRespDto<>(1, null);
	}
}

