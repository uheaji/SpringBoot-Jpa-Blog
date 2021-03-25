package com.cos.test.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {

	private String playerName;
	private String position;
	private String teamId;
	private String team1;
	private String team2;
	private String team3;
	
	
}
