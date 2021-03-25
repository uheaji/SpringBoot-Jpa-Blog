package com.cos.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.test.domain.player.Player;
import com.cos.test.service.PlayerService;
import com.cos.test.web.dto.CommonRespDto;
import com.cos.test.web.player.dto.PlayerSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;

	@GetMapping("/player/saveForm")
	public String saveForm() {
		return "player/playerSaveForm";
	}

	@GetMapping("/player")
	public String findAll(Model model) {
		model.addAttribute("players", playerService.전체찾기());
		return "player/playerList";
	}

	@PostMapping("/savePlayer")
	public String save(PlayerSaveReqDto playerSaveReqDto) {
		Player player = playerSaveReqDto.toEntity();
		Player playerEntity = playerService.선수등록(player, playerSaveReqDto.getTeamId());
		if (playerEntity == null) {
			return "player/playerSaveForm";
		} else {
			return "redirect:/player";
		}
	}
	
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		playerService.삭제하기(id);
		return new CommonRespDto<>(1, null);
	}
}
