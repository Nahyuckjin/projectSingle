package com.indiScene.marketBoard.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.indiScene.marketBoard.dao.MarketBoardDao;
import com.indiScene.marketBoard.dto.MarketBoardDto;


@Component
public class MarketBoardServiceImpl implements MarketBoardService {
	final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private MarketBoardDao marketBoardDao;
	
	@Override
	public void enterBoard(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null) pageNumber="1";
		int currentPage=Integer.parseInt(pageNumber);
		logger.info("currentPage:" +currentPage);
		
		//전체 레코드수, 현재 번호의 시작번호, 끝번호 -->
		int count=marketBoardDao.getCount();
		logger.info("count:"+ count);

		
		int boardSize=3;
		int startRow=(currentPage-1) * boardSize +1;
		int endRow=currentPage*boardSize;
		logger.info("startRow:" + startRow + ",endRow" + endRow);
		
		List<MarketBoardDto> marketList=null;
		
		if(count >0) {
			marketList=marketBoardDao.getMarketList(startRow,endRow);
			logger.info("marketList" + marketList.size());
		}
		
		
		mav.addObject("list", marketList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage",currentPage);
		
		mav.setViewName("marketBoard/enterBoard");
		
	}

	@Override
	public void write(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map=mav.getModelMap();
		MarketBoardDto marketBoardDto=(MarketBoardDto)map.get("marketBoardDto");
		Date date=new Date();
	

		marketBoardDto.setRegister_date(date);
		System.out.println(marketBoardDto.getContent());
		System.out.println(marketBoardDto.getRegister_date());
		int check=marketBoardDao.insert(marketBoardDto);
		logger.info("check" + check);
		
		mav.addObject("check", check);
		mav.setViewName("marketBoard/writeOk");
	}

	@Override
	public void read(ModelAndView mav) {
		// TODO Auto-generated method stub
		logger.info("readService----------------------");
		Map<String, Object>map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String boardNumber=(request.getParameter("board_num"));
		String currentPage=(request.getParameter("pageNumber"));
		MarketBoardDto marketBoardDto=marketBoardDao.read(boardNumber);
		
		int countCheck=0;
		if(marketBoardDto !=null){
			countCheck=marketBoardDao.count(boardNumber);
			
		}
		logger.info("marketBoardDto:" + marketBoardDto);
		logger.info("countCheck" + countCheck);
		
		mav.addObject("marketBoard",marketBoardDto);
		mav.addObject("pageNumber",currentPage);
		
		mav.setViewName("marketBoard/read");
	
	}
	
	
	
	
	
	
}
