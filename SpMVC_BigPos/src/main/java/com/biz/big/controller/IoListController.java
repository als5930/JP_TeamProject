package com.biz.big.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.big.model.IoListVO;
import com.biz.big.service.IoListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/iolist")
public class IoListController {
	
	@Autowired
	@Qualifier("ioServiceV1")
	private IoListService ioService;

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String  proHome(Model model,HttpSession httpSession) {
	
		Object obj = httpSession.getAttribute("LOGIN");
		if(obj == null) {
			model.addAttribute("BODY","LOGIN");
			model.addAttribute("MSG","로그인을 해야 합니다!!");
			return "redirect:/member/login";
		}
	
		List<IoListVO> ioList = ioService.selectAll();
		
		
		model.addAttribute("IOLIST_LIST",ioList);
		model.addAttribute("BODY","IOLIST_HOME");
		return "home";
	
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(
			@ModelAttribute("IO_VO") IoListVO iolistVO,
			Model model) {
		// return "product/product_write";
		
		
		LocalDateTime ldt = LocalDateTime.now();
		String cd = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
		String ct = DateTimeFormatter.ofPattern("HH:mm:ss").format(ldt);
		
		
		
		
		IoListVO ioVO = IoListVO.builder()
				.io_date(cd)
				.io_time(ct)
				.build();
		
		
		
		
		
		model.addAttribute("IOLIST_VO", ioVO);
		model.addAttribute("BODY","IO_WRITE");
		return "home";
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute IoListVO ioVO) {

		log.debug("상품정보 입력 : {}" , ioVO.toString());
		ioService.insert(ioVO);
		return "redirect:/iolist/iolist_list";
	
	}
	
	@ResponseBody
	@RequestMapping(value="/get_icode",method=RequestMethod.GET)
	public String getICode() {

		String io_dcode = ioService.getICode();
		return io_dcode;
		
	}

}
