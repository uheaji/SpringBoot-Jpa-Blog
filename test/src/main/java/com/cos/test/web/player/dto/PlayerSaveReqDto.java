package com.cos.test.web.player.dto;

import com.cos.test.domain.player.Player;
import com.cos.test.domain.stadium.Stadium;
import com.cos.test.web.stadium.dto.StadiumSaveReqDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSaveReqDto {
	
	private String playerName;
	private String position;
	private int teamId;
	
	public Player toEntity() {
		return Player.builder()
				.playerName(playerName)
				.position(position)
				.build();
	}

}
