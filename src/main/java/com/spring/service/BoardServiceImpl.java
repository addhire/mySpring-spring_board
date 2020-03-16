package com.spring.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.domain.BoardVO;
import com.spring.persistence.BoardDAO;

@Component("service")
public class BoardServiceImpl implements BoardService {
	
	@Inject
	//@Autowired
	private BoardDAO dao;
	
	@Override
	public boolean insertBoard(BoardVO vo) {
		
		return dao.insert(vo)>0?true:false;
	}

}
