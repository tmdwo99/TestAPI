package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {
	
	@RequestMapping("/doA")
	public void doA() 
	{
		log.info("doA called...");
	}
	
	@RequestMapping("/doB")
	public String doB(@ModelAttribute("msg") String msg) 
	{
		log.info("doB called...");
		return "result";
	}
	
	@RequestMapping("/doC")
	public String doC(Model model) 
	{
		log.info("doC called...");
		
		ProductVO product = new ProductVO("BANANA", 5000);
		model.addAttribute("product", product);
		
		return "productDetail";
	}
	
	@RequestMapping("/home")
	public String index()
	{
		log.info("index called...");
		return "index";
	}
	
	@RequestMapping("/redi")
	public String other()
	{
		log.info("redirect called...");
		return "redirect:/home";		
	}
	
	@RequestMapping("/forw")
	public String home() 
	{
		log.info("forward called...");
		return "forward:/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String send(@RequestParam("id1") String id,Model model) {
		model.addAttribute("msg","Hello "+id+" !");
		model.addAttribute("id2", id);
		return "login";
	}
	
	@RequestMapping("/doJSON")
	@ResponseBody
	public ProductVO doJSON() {
		ProductVO vo = new ProductVO("MELON",50000);
		return vo;
	}
}
