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

import com.biz.big.model.IoListVO;
import com.biz.big.model.IpriceVO;
import com.biz.big.service.IpriceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/iprice")
public class IpriceController {

	
	@Autowired
	@Qualifier("ipServiceV1")
	private IpriceService ipService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String  proHome(Model model,HttpSession httpSession) {
	
		Object obj = httpSession.getAttribute("LOGIN");
		if(obj == null) {
			model.addAttribute("BODY","LOGIN");
			model.addAttribute("MSG","로그인을 해야 합니다!!");
			return "redirect:/member/login";
		}
	
		List<IpriceVO> ipList = ipService.selectAll();
		
		
		model.addAttribute("IPRICE_LIST",ipList);
		model.addAttribute("BODY","IPRICE_HOME");
		return "home";
	
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(
			@ModelAttribute("IP_VO") IpriceVO ipriceVO,
			Model model) {
		// return "product/product_write";
		
		
		LocalDateTime ldt = LocalDateTime.now();
		String cd = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
	
		
		
		
		IpriceVO ipVO = IpriceVO.builder()
				.io_date(cd)
				.build();
		
		
		
		
		
		model.addAttribute("IPRICE_VO", ipVO);
		model.addAttribute("BODY","IP_WRITE");
		return "home";
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute IpriceVO ipVO) {

		log.debug("상품정보 입력 : {}" , ipVO.toString());
		ipService.insert(ipVO);
		return "redirect:/iprice/iprice_list";
	
	}
	
	
}
