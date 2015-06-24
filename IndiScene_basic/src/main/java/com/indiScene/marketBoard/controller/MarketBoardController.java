package com.indiScene.marketBoard.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.indiScene.marketBoard.dto.MarketBoardDto;
import com.indiScene.marketBoard.service.MarketBoardService;





@Controller
public class MarketBoardController  {
	final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private MarketBoardService marketBoardService;
	
	
	@RequestMapping(value="/marketBoard/enterBoard.do", method=RequestMethod.GET)
	public ModelAndView enterBoard(HttpServletRequest request, HttpServletResponse response){
	logger.info("MarketBoardWrite------------------------------");
	
	ModelAndView mav=new ModelAndView();
	mav.addObject("request",request);
	marketBoardService.enterBoard(mav);
	
	
	return mav;
	
	}
	
	@RequestMapping(value="/marketBoard/write.do", method=RequestMethod.GET)
	public ModelAndView write(HttpServletRequest request){
		logger.info("MarketBoardWrite------------------------------");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("marketBoard/write");
		
		return mav;
		
	}
	
	@RequestMapping(value="/marketBoard/write.do", method=RequestMethod.POST)
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response, MarketBoardDto marketBoardDto){
		logger.info("MarketBoardWriteOk");
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		mav.addObject("marketBoardDto",marketBoardDto);
		marketBoardService.write(mav);
		
		return mav;
		
	}
	
	@RequestMapping(value="/marketBoard/read.do", method=RequestMethod.GET)
	public ModelAndView read(HttpServletRequest request){
		logger.info("MarketBoardRead");
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		marketBoardService.read(mav);
		return mav;
		
	}
	
	
	
		
}
