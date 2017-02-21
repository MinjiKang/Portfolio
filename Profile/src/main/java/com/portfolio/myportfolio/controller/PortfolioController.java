package com.portfolio.myportfolio.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.myportfolio.service.PortfolioService;
import com.portfolio.myportfolio.vo.Experiences;
import com.portfolio.myportfolio.vo.Objective;
import com.portfolio.myportfolio.vo.PersonalInfo;


@Controller
public class PortfolioController {

	@Autowired
	PortfolioService portfolioService;
	
	private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);
	
	@RequestMapping("/Intro")
	public String introPage(Locale locale, Model model) throws Exception {
		return "portfolio/SearchPerson";
	}
	
	//프로필 조회
	@RequestMapping("/schPerson")
	public String searchName(String myname, Model model) throws Exception{
		//model.addAttribute(" vo����")
		PersonalInfo per = portfolioService.getAllPersonalInfo(myname);
		model.addAttribute("Personal_Info", per );
		model.addAttribute("Objective", portfolioService.getAllObjective(per.getPerson_no()));
		model.addAttribute("exp", portfolioService.getAllExperiences(per.getPerson_no()));
		model.addAttribute("Education", portfolioService.getAllEducation(per.getPerson_no()));
		model.addAttribute("Activities", portfolioService.getAllActivities(per.getPerson_no()));
		model.addAttribute("Skills", portfolioService.getAllSkills(per.getPerson_no()));
		model.addAttribute("Works", portfolioService.getAllWorks(per.getPerson_no()));
	
		return "portfolio/index";
	}	
	
	@RequestMapping("/edit")
	public String edit(Locale locale, Model model) throws Exception {
		return "portfolio/AddForm";
	}
	
	@RequestMapping("/insert")
	public String insertPersonal_Info(HttpServletRequest req, PersonalInfo info, Objective obj, Experiences exp, Model model) throws Exception{
		
		int seq_no = portfolioService.insertPersonalInfo(info);
		/*exp.setPerson_no(seq_no);
		int exp_seq_no = portfolioService.insertExperiences(exp);*/
		/*exp.setExp_no(exp_no);*/
		int count = Integer.parseInt(req.getParameter("count")); //경험1
		int count1 = Integer.parseInt(req.getParameter("count1")); //경험2
		
		System.out.println(count);
		System.out.println(count1);
	
		/*obj.setPerson_no(seq_no);
		portfolioService.insertObjective(obj);*/
		
		String[] expContent1 = exp.getExp_content().split(",");
		
		for(int i=0; i<count; i++){
			
			exp.setPerson_no(seq_no);
			exp.setExp_place(req.getParameter("exp_place"));
			exp.setExp_date(req.getParameter("exp_date"));
			exp.setExp_content(expContent1[i]);
			
			portfolioService.insertExperiences(exp);
			
		}
		if(count1 != 0)
		{
			/*Expnew expContentOne = new Expnew();  */
			for(int j=0; j<count1; j++){
				
				exp.setPerson_no(seq_no);
				exp.setExp_place(req.getParameter("exp_place1"));
				exp.setExp_date(req.getParameter("exp_date1"));
				exp.setExp_content(req.getParameter("exp_content1"));
				
				portfolioService.insertExperiences(exp);
				
			}
		}
		
		/*for(int i=0; i<count1; i++){
			
			expnew.setPerson_no(seq_no);
			expnew.setExp_place(req.getParameter("exp_place"));
			expnew.setExp_date(req.getParameter("exp_date"));
			expnew.setExp_content(expContent1[i]);
			
			portfolioService.insertExpNew(expnew);
			
		}*/

		
		/*expnew.setPerson_no(seq_no);
		portfolioService.insertExpNew(expnew);
		*/
		return "redirect:Intro";
	}
	
	
	/*@RequestMapping("/add")
	public String addPerson(){
		return "portfolio/PersonAdd";
	}*/
	
	/*@RequestMapping("/insert") //PersonAdd.jsp���� <form action='insert' method='post'>
	public String insertPersonal_Info(Personal_Info info, Objective obj, Experiences exp, Education edu, Model model) throws Exception{
		int seq_no = portfolioService.insertPersonal_Info(info);
		obj.setSeq_fk(seq_no);
		portfolioService.insertObjective(obj);
		exp.setSeq_fk(seq_no);
		portfolioService.insertExperiences(exp);
		edu.setSeq_fk(seq_no);
		portfolioService.insertEducation(edu);
		return "redirect:Intro";	
	}*/
	
	/*@RequestMapping("/portfolio")
	public String portfolioList(Locale locale, Model model) throws Exception {
		
		model.addAttribute("Personal_Info", portfolioService.getAllPersonal_Info()); //model.addAttribute(" vo����")
		model.addAttribute("Objective", portfolioService.getAllObjective(portfolioService.getAllPersonal_Info().getSeq_No()));
		model.addAttribute("Experiences", portfolioService.getAllExperiences(portfolioService.getAllPersonal_Info().getSeq_No()));
		model.addAttribute("Education", portfolioService.getAllEducation(portfolioService.getAllPersonal_Info().getSeq_No()));
		model.addAttribute("Activities", portfolioService.getAllActivities(portfolioService.getAllPersonal_Info().getSeq_No()));
		model.addAttribute("Skills_Language", portfolioService.getAllSkills_Language(portfolioService.getAllPersonal_Info().getSeq_No()));
		return "portfolio/portfolioList";
	
	}*/
	
	
	//controller->service->dao
}
