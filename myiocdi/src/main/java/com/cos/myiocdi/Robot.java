package com.cos.myiocdi;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
// @Component // IoC(제어의 역전)
//@Configuration  // IoC
//@Service
//@Repository
public class Robot {
	
	private String name = "건담";

}
