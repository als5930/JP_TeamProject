package com.biz.big.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.big.model.DeptVO;
import com.biz.big.service.DeptService;


@RequestMapping(value = "/dept")
@Controller
public class DeptController {
	
	@Autowired
	@Qualifier("deptServiceV1")
	private DeptService dService;	

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<DeptVO> deptList = dService.selectAll();
		model.addAttribute("DEPT_LIST",deptList);
		model.addAttribute("BODY","DEPT_LIST");
		return "home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public ModelAndView insert(@ModelAttribute("DEPT_VO") DeptVO deptVO) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("BODY","DEPT_WRITE");
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("DEPT_VO") DeptVO deptVO,Model model) {
		
		int ret = dService.insert(deptVO);
		return "redirect:/dept/";
	
	}
	

	@ResponseBody
	@RequestMapping(value="/get_dcode",method=RequestMethod.GET)
	public String getDCode() {

		String d_code = dService.getDCode();
		return d_code;
		
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(@RequestParam("id") String d_code, Model model) {
		
		DeptVO deptVO = dService.findByID(d_code);
		model.addAttribute("DEPT_VO",deptVO);
		model.addAttribute("BODY","DEPT_DETAIL");
		return "home";
	
	}

	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("id") String d_code) {

		dService.delete(d_code);
		return "redirect:/dept/";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("id") String d_code,
			@ModelAttribute("DEPT_VO") DeptVO deptVO, Model model) {
		
		deptVO = dService.findByID(d_code);
		model.addAttribute("DEPT_VO",deptVO);
		model.addAttribute("BODY","DEPT_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute DeptVO deptVO,Model model) {
		
		int ret = dService.update(deptVO);
	
		model.addAttribute("id",deptVO.getD_code());
		return "redirect:/dept/detail" ;// ?id=" + proVO.getP_code();
	
	}
	
	
	
		
	}


