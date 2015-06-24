package com.indiScene.marketBoard.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indiScene.marketBoard.dto.MarketBoardDto;

@Component
public class MarketBoardDaoImpl implements MarketBoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getCount() {
		System.out.println("daoImpl");
		return sqlSession.selectOne("dao.marketBoardMapper.boardCount");
	}

	@Override
	public List<MarketBoardDto> getMarketList(int startRow, int endRow) {
		HashMap<String, Integer> hMap=new HashMap<String,Integer>();
		hMap.put("startRow",startRow);
		hMap.put("endRow", endRow);
		return sqlSession.selectList("dao.marketBoardMapper.boardList", hMap); //SelectList Dto를 자동으로 받아서 려주는 역할  
	}

	@Override
	public int insert(MarketBoardDto marketBoardDto) {
		return sqlSession.insert("dao.marketBoardMapper.boardInsert", marketBoardDto);
	}

	@Override
	public MarketBoardDto read(String boardNumber) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("dao.marketBoardMapper.boardRead", boardNumber);
	}

	@Override
	public int count(String boardNumber) {
		// TODO Auto-generated method stub
		return sqlSession.insert("dao.marketBoardMapper.readCount", boardNumber);
	}

}
