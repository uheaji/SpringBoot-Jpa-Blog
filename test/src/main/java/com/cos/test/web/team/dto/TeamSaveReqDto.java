package com.cos.test.web.team.dto;

import com.cos.test.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamSaveReqDto {
	private String teamName;
	
	public Team toEntity() {
		return Team.builder()
				.teamName(teamName)
				.build();
	}
}
