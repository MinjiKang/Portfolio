package com.portfolio.myportfolio.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.myportfolio.vo.Activities;
import com.portfolio.myportfolio.vo.Education;
import com.portfolio.myportfolio.vo.Experiences;
import com.portfolio.myportfolio.vo.Objective;
import com.portfolio.myportfolio.vo.PersonalInfo;
import com.portfolio.myportfolio.vo.Skills;
import com.portfolio.myportfolio.vo.Works;

@Repository
public class PortfolioDaoImpl implements PortfolioDao{
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public PersonalInfo selectPersonalInfo(String myName) throws Exception{
		
		return sqlSession.selectOne("PortfolioDao.selectPersonal", myName);
		//(namespace.id) PortfolioSql.xml
	}
	
	public List<Objective> selectObjective(int fk) throws Exception{
		
		return sqlSession.selectList("PortfolioDao.selectObjective", fk);
	}
	
	public List<Experiences> selectExperiences(int fk) throws Exception{
		
		return sqlSession.selectList("PortfolioDao.selectExperiences", fk);
	}
	
	public Education selectEducation(int fk) throws Exception{
		
		return sqlSession.selectOne("PortfolioDao.selectEducation", fk);
	}
	
	public List<Activities> selectActivities(int fk) throws Exception{
		
		return sqlSession.selectList("PortfolioDao.selectActivities", fk);
	}
	
	public List<Skills> selectSkills(int fk) throws Exception{
		
		return sqlSession.selectList("PortfolioDao.selectSkills", fk);
	}

	public List<Works> selectWorks(int fk) throws Exception{
		
		return sqlSession.selectList("PortfolioDao.selectWorks", fk);
	}

	public int insertPersonalInfo(PersonalInfo insert_person) throws Exception{

		sqlSession.insert("PortfolioDao.InsertPersonal", insert_person);
		int p_seq = insert_person.getPerson_no();
		return p_seq;
	}
	
	public int insertObjective(Objective insert_objective) throws Exception{
		
		return sqlSession.insert("PortfolioDao.InsertObjective", insert_objective);
	}
	
	public int insertExperiences(Experiences insert_experiences) throws Exception{
		return sqlSession.insert("PortfolioDao.InsertExperiences", insert_experiences);
	} 
	
	public int insertEducation(Education insert_education) throws Exception{
		return sqlSession.insert("PortfolioDao.InsertEducation", insert_education);
	}
	
	public int insertActivities(Activities insert_activities) throws Exception{
		return sqlSession.insert("PortfolioDao.InsertActivities", insert_activities);
	}
	
	public int insertSkills(Skills insert_skills) throws Exception{
		return sqlSession.insert("PortfolioDao.InsertSkills", insert_skills);
	}
	
	public int insertWorks(Works insert_works) throws Exception{
		return sqlSession.insert("PortfolioDao.InsertWorks", insert_works);
	}
	
	/*public int insertExperiences(Experiences insert_experiences) throws Exception{
	
	sqlSession.insert("PortfolioDao.InsertExperiences", insert_experiences);
	int e_seq = insert_experiences.getExp_no();
	return e_seq;
}

public int insertExperiencesContent(ExperiencesContent insert_expcontent) throws Exception{
	
	return sqlSession.insert("PortfolioDao.InsertExperiencesContent", insert_expcontent);
}*/
}
