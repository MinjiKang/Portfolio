package com.portfolio.myportfolio.dao;


import java.util.List;

import com.portfolio.myportfolio.vo.Activities;
import com.portfolio.myportfolio.vo.Education;
import com.portfolio.myportfolio.vo.Experiences;
import com.portfolio.myportfolio.vo.Objective;
import com.portfolio.myportfolio.vo.PersonalInfo;
import com.portfolio.myportfolio.vo.Skills;
import com.portfolio.myportfolio.vo.Works;

public interface PortfolioDao {
	PersonalInfo selectPersonalInfo(String myName) throws Exception;
	List<Objective> selectObjective(int fk) throws Exception;
	List<Experiences> selectExperiences(int fk) throws Exception;
	Education selectEducation(int fk) throws Exception;
	List<Activities> selectActivities(int fk) throws Exception;
	List<Skills> selectSkills(int fk) throws Exception;
	List<Works> selectWorks(int fk) throws Exception;
	
	int insertPersonalInfo(PersonalInfo insert_person) throws Exception;
	int insertObjective(Objective insert_objective) throws Exception;
	/*int insertExperiences(Experiences insert_experiences) throws Exception;
	int insertExperiencesContent(ExperiencesContent insert_expcontent) throws Exception;*/
	int insertExperiences(Experiences insert_experiences) throws Exception; //test
	int insertEducation(Education insert_education) throws Exception;
	int insertActivities(Activities insert_activities) throws Exception;
	int insertSkills(Skills insert_skills) throws Exception;
	int insertWorks(Works insert_works) throws Exception;
	
	/*int insertPersonal_Info(Personal_Info insert_person) throws Exception;
	int insertObjective(Objective insert_objective) throws Exception;
	int insertExperiences(Experiences experiences) throws Exception;
	int insertEducation(Education education) throws Exception;*/
}
