package com.cos.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.test.domain.player.Player;
import com.cos.test.domain.stadium.Stadium;
import com.cos.test.domain.stadium.StadiumRepository;
import com.cos.test.domain.team.Team;
import com.cos.test.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {

	private final StadiumRepository stadiumRepository;
	private final TeamRepository teamRepository;

	public List<Stadium> 전체찾기() {
		return stadiumRepository.findAll();
	}

	@Transactional
	public Stadium 야구장등록(Stadium stadium, int teamId) {
		Team teamEntity = teamRepository.findById(teamId).get();
		stadium.setTeam(teamEntity);
		return stadiumRepository.save(stadium);
	}

	@Transactional
	public int 삭제하기(int id) {
		Stadium stadiumEntity = stadiumRepository.findById(id).get();
		if (stadiumEntity == null) {
			return -1;
		} else {
			stadiumRepository.deleteById(id);
			return 1;
		}
	}

}
