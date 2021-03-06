package com.biz.big.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.big.model.ProductVO;
import com.biz.big.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/product")
@Controller
public class ProductController {

	@Autowired
	@Qualifier("proServiceV1")
	private ProductService proService;

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String  proHome(Model model,HttpSession httpSession) {
	
		Object obj = httpSession.getAttribute("LOGIN");
		if(obj == null) {
			model.addAttribute("BODY","LOGIN");
			model.addAttribute("MSG","로그인을 해야 합니다!!");
			return "redirect:/member/login";
		}
	
		List<ProductVO> proList = proService.selectAll();
		
		
		model.addAttribute("PRO_LIST",proList);
		model.addAttribute("BODY","PRO_HOME");
		return "home";
	
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(
			@ModelAttribute("PRO_VO") ProductVO proVO,
			Model model) {
		// return "product/product_write";
		model.addAttribute("BODY","PRO_WRITE");
		return "home";
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute ProductVO proVO) {

		log.debug("상품정보 입력 : {}" , proVO.toString());
		int ret = proService.insert(proVO);
		return "redirect:/product/";
	
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(@RequestParam("id" ) String p_code, Model model) {
		
		ProductVO proVO = proService.findByID(p_code);
		
		model.addAttribute("PRO_VO",proVO);
		model.addAttribute("BODY","PRO_DETAIL");
		return "home";
	
	}

	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("id") String p_code) {

		int ret = proService.delete(p_code);
		return "redirect:/product/";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("id") String p_code,
			@ModelAttribute("PRO_VO") ProductVO proVO, Model model) {
		
		proVO = proService.findByID(p_code);
		model.addAttribute("PRO_VO",proVO);
		model.addAttribute("BODY","PRO_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute ProductVO proVO,Model model) {
		
		int ret = proService.update(proVO);
	
		model.addAttribute("id",proVO.getP_code());
		return "redirect:/product/detail" ;// ?id=" + proVO.getP_code();
	
	}
	

}
