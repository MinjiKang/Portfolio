package com.portfolio.myportfolio.service;

import java.util.List;

import com.portfolio.myportfolio.vo.Activities;
import com.portfolio.myportfolio.vo.Education;
import com.portfolio.myportfolio.vo.Experiences;
import com.portfolio.myportfolio.vo.Objective;
import com.portfolio.myportfolio.vo.PersonalInfo;
import com.portfolio.myportfolio.vo.Skills;
import com.portfolio.myportfolio.vo.Works;

public interface PortfolioService {
	
	//PersonalInfo getAllPersonalInfo(String myName) throws Exception;
	PersonalInfo getAllPersonalInfo(String myName) throws Exception;
	List<Objective> getAllObjective(int fk) throws Exception;
	List<Experiences> getAllExperiences(int fk) throws Exception;
	Education getAllEducation(int fk) throws Exception;
	List<Activities> getAllActivities(int fk) throws Exception;
	List<Skills> getAllSkills(int fk) throws Exception;
	List<Works> getAllWorks(int fk) throws Exception;

	int insertPersonalInfo(PersonalInfo insert_person) throws Exception;
	void insertObjective(Objective objective) throws Exception;
	/*int insertExperiences(Experiences experiences) throws Exception;
	void insertExperiencesContent(ExperiencesContent expcontent) throws Exception;*/
	void insertExperiences(Experiences experiences) throws Exception; //test
	void insertEducation(Education education) throws Exception;
	void insertActivities(Activities activities) throws Exception;
	void insertSkills(Skills skills) throws Exception;
	void insertWorks(Works works) throws Exception;
	
	/*int insertPersonal_Info(Personal_Info info) throws Exception;
	void insertObjective(Objective objective) throws Exception;
	void insertExperiences(Experiences experiences) throws Exception;
	void insertEducation(Education education) throws Exception;*/
}
