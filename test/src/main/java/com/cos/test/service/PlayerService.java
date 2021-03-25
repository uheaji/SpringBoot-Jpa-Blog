package com.cos.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.test.domain.player.Player;
import com.cos.test.domain.player.PlayerRepository;
import com.cos.test.domain.stadium.Stadium;
import com.cos.test.domain.team.Team;
import com.cos.test.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	
	public List<Player> 전체찾기() {
		return playerRepository.findAll();
	}
	
	@Transactional
	public Player 선수등록(Player player, int teamId) {
		Team teamEntity = teamRepository.findById(teamId).get();
		player.setTeam(teamEntity);
		return playerRepository.save(player);
	}
	
	@Transactional
	public int 삭제하기(int id) {
		Player playerEntity = playerRepository.findById(id).get();
		if (playerEntity == null) {
			return -1;
		} else {
			playerRepository.deleteById(id);
			return 1;
		}
	}
	
}
