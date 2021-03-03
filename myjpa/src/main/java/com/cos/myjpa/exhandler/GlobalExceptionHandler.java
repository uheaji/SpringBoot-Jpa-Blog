package com.cos.myjpa.exhandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.web.dto.CommonRespDto;

@RestController // 데이터를 리턴한다.
@ControllerAdvice   //모든 exception을 낚아챔.
public class GlobalExceptionHandler {

	// 그 중 DataIntegrityViolationException이 발생하면 해당 함수 실행 됨.
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public CommonRespDto<?> dataIntegrityViolationException(Exception e) { // e는 오류정보를 다 가지고 있다.
		return new CommonRespDto<>(-1, e.getMessage(), null);
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public CommonRespDto<?> illegalArgumentException(Exception e) { // e는 오류정보를 다 가지고 있다.
		return new CommonRespDto<>(-1, e.getMessage(), null);
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public CommonRespDto<?> emptyResultDataAccessException (Exception e) { // e는 오류정보를 다 가지고 있다.
		return new CommonRespDto<>(-1, e.getMessage(), null);
	}
}
