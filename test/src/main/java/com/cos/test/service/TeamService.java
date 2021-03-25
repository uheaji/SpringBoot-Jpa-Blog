package com.cos.test.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.test.domain.player.Player;
import com.cos.test.domain.team.Team;
import com.cos.test.domain.team.TeamRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamRepository teamRepository;

	public List<Team> 팀찾기() {
		return teamRepository.findAll();
	}
	
	@Transactional
	public Team 팀등록(Team team) {
		return teamRepository.save(team);
	}
	
	@Transactional
	public int 삭제하기(int id) {
		Team teamEntity = teamRepository.findById(id).get();
		if (teamEntity == null) {
			return -1;
		} else {
			teamRepository.deleteById(id);
			return 1;
		}
	}

}
