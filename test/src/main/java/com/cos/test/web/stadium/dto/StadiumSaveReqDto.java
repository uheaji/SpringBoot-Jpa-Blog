package com.cos.test.web.stadium.dto;

import com.cos.test.domain.stadium.Stadium;
import com.cos.test.domain.team.Team;
import com.cos.test.web.team.dto.TeamSaveReqDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StadiumSaveReqDto {
	private String stadiumName;
	private int teamId;
	
	public Stadium toEntity() {
		return Stadium.builder()
				.stadiumName(stadiumName)
				.build();
	}
}
