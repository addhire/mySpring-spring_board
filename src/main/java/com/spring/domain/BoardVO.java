package com.spring.domain;

import java.sql.Date;

import lombok.Data;

@Data			// 요고 하나로 이거저거 다 만들어냄
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}
