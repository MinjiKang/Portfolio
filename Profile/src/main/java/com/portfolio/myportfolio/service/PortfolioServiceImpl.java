package com.portfolio.myportfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.portfolio.myportfolio.dao.PortfolioDao;
import com.portfolio.myportfolio.vo.Activities;
import com.portfolio.myportfolio.vo.Education;
import com.portfolio.myportfolio.vo.Experiences;
import com.portfolio.myportfolio.vo.Objective;
import com.portfolio.myportfolio.vo.PersonalInfo;
import com.portfolio.myportfolio.vo.Skills;
import com.portfolio.myportfolio.vo.Works;
@Service
public class PortfolioServiceImpl implements PortfolioService{
	
	@Autowired
	private PortfolioDao portfolioDao;
	
	public PersonalInfo getAllPersonalInfo(String myName) throws Exception{
		return portfolioDao.selectPersonalInfo(myName);
	}
	
	public List<Objective> getAllObjective(int fk) throws Exception{
		List<Objective>rtnList = portfolioDao.selectObjective(fk);

		return rtnList;
	}
	
	public List<Experiences> getAllExperiences(int fk) throws Exception{
		List<Experiences> rtnList1 = portfolioDao.selectExperiences(fk);
		return rtnList1;
		/*ArrayList<Experiences> result = new ArrayList<Experiences>();
		String old_date = "";
		String old_place = "";
		String old_topic = "";
		
		String sumContent="";

		Experiences rst = null;

		for(int i =0; i < rtnList1.size(); i++){
			
			
			if ( i == 0 ){
				old_date = rtnList1.get(i).getExperiencedate();
				old_place = rtnList1.get(i).getPlace();
				old_topic = rtnList1.get(i).getTopic();
				sumContent = rtnList1.get(i).getExp_contents();
			}
			else{
				if ( old_date.equals(rtnList1.get(i).getExperiencedate()) &&
					 old_place.equals(rtnList1.get(i).getPlace()) &&
					 old_topic.equals(rtnList1.get(i).getTopic()) ){
					sumContent += "\n" + rtnList1.get(i).getExp_contents();
				}else{
					rst = new Experiences();
					rst.setExperiencedate(old_date);
					rst.setPlace(old_place);
					rst.setTopic(old_topic);
					rst.setExp_contents(sumContent);
					
					result.add(rst);
					
					old_date = rtnList1.get(i).getExperiencedate();
					old_place = rtnList1.get(i).getPlace();
					old_topic = rtnList1.get(i).getTopic();
					sumContent = rtnList1.get(i).getExp_contents();
				}
					
			}
		} // end for
		rst = new Experiences();
		rst.setExperiencedate(old_date);
		rst.setPlace(old_place);
		rst.setTopic(old_topic);
		rst.setExp_contents(sumContent);
		
		result.add(rst);

		return result;*/
	}
		
	public Education getAllEducation(int fk) throws Exception{
		return portfolioDao.selectEducation(fk);
	}
	
	public List<Activities> getAllActivities(int fk) throws Exception{
		return portfolioDao.selectActivities(fk);
	}
	
	public List<Skills> getAllSkills(int fk) throws Exception{
		return portfolioDao.selectSkills(fk);
	}
	
	public List<Works> getAllWorks(int fk) throws Exception{
		List<Works> rtnList3 = portfolioDao.selectWorks(fk);
		return rtnList3;
	}

	public int insertPersonalInfo(PersonalInfo insert_person) throws Exception{
		int p_seq =  portfolioDao.insertPersonalInfo(insert_person);
		return p_seq;
	}
	
	public void insertObjective(Objective objective) throws Exception{
		
		String[] obj = objective.getObj_content().split(",");  // ',' 분리
		
		//Objective db insert
		for(int i =0; i<obj.length; i++){
			Objective objOne = new Objective(); // db insert
			objOne.setPerson_no(objective.getPerson_no()); // personal_id setting
			objOne.setObj_content(obj[i]); // contents vo set
			portfolioDao.insertObjective(objOne); // dao insert call
		}
	}
	
	/*public int insertExperiences(Experiences experiences) throws Exception{
		String[] expDate = experiences.getExp_date().split(",");
		String[] expPlace = experiences.getExp_place().split(",");
		
		Experiences expOne = new Experiences();
		int exp = 0;
		for(int i =0; i<expDate.length; i++){
			Experiences expOne = new Experiences(); 
			expOne.setPerson_no(experiences.getPerson_no());
			expOne.setExp_no(experiences.getExp_no());
			expOne.setExp_date(expDate[i]);
			expOne.setExp_place(expPlace[i]);
			exp = portfolioDao.insertExperiences(expOne);
		}
		int ee = portfolioDao.insertExperiences(expOne);
		return exp;
	}
	
	public void insertExperiencesContent(ExperiencesContent expcontent) throws Exception{
		String[] expContent = expcontent.getExp_content().split(",");
		
		for(int i =0; i<expContent.length; i++){
			ExperiencesContent expContentOne = new ExperiencesContent(); 
			expContentOne.setPerson_no(expcontent.getPerson_no());
			expContentOne.setExp_no(expcontent.getExp_no());	
			expContentOne.setExp_content(expContent[i]);
			
			portfolioDao.insertExperiencesContent(expContentOne);
		}
		
	} *//*exp_no 연결 안됨*/
	
	/*public void insertExpNew(Expnew expnew) throws Exception{ //test
		
		String[] expContent = expnew.getExp_content().split(",");
		Expnew expContentOne = new Expnew();  
		
		
		for(int i =0; i<expContent.length; i++){
			String expDate = expnew.getExp_date();
			String expPlace = expnew.getExp_place();
			
			expContentOne.setPerson_no(expnew.getPerson_no());
			expContentOne.setExp_date(expDate);
			expContentOne.setExp_place(expPlace);
			expContentOne.setExp_content(expContent[i]);
			
			portfolioDao.insertExpNew(expContentOne);
		}
	}*/
	
	public void insertExperiences(Experiences experiences)throws Exception{ //test
		
		portfolioDao.insertExperiences(experiences);
		
	}

	public void insertEducation(Education education) throws Exception{
		portfolioDao.insertEducation(education);
	}
	
	public void insertActivities(Activities activities) throws Exception{
		String[] act = activities.getAct_content().split(",");  // ',' 분리
		
		for(int i =0; i<act.length; i++){
			Activities actOne = new Activities();
			actOne.setPerson_no(activities.getPerson_no());
			actOne.setAct_content(act[i]); 
			portfolioDao.insertActivities(actOne); 
		}
	}
	
	public void insertSkills(Skills skills) throws Exception{
		String[] language = skills.getSkill_language().split(",");
		String[] tool = skills.getSkill_tool().split(",");
		String[] software = skills.getSkill_software().split(",");
		
		for(int i =0; i<3; i++){
			Skills skillOne = new Skills();
			skillOne.setPerson_no(skills.getPerson_no());
			skillOne.setSkill_language(language[i]); 
			skillOne.setSkill_tool(tool[i]);
			skillOne.setSkill_software(software[i]);
			portfolioDao.insertSkills(skillOne); 
		}
	}
	
	public void insertWorks(Works works) throws Exception{
		String[] workContent = works.getWork_content().split(",");
		String[] workDate = works.getWork_date().split(",");
		
		for(int i =0; i<workDate.length; i++){
			Works workOne = new Works();
			workOne.setPerson_no(works.getPerson_no());
			workOne.setWork_content(workContent[i]); 
			workOne.setWork_date(workDate[i]);
			portfolioDao.insertWorks(workOne); 
		}
	}
	
	/*public int insertPersonal_Info(Personal_Info info) throws Exception{
		int p_seq =  portfolioDao.insertPersonal_Info(info);
		return p_seq;
	}
	
	public void insertObjective(Objective objective) throws Exception{
		
		String[] obj = objective.getContents().split(",");  // ',' �� �и�
		
		// �и��� ������ŭ �ݺ��� ����Ͽ� db insert
		for(int i =0; i<obj.length; i++){
			Objective objOne = new Objective(); // db insert �ϱ� ���� vo �ʱ�ȭ
			objOne.setSeq_fk(objective.getSeq_fk()); // personal_id setting
			objOne.setContents(obj[i]); // contents���� vo set
			portfolioDao.insertObjective(objOne); // dao insert call
		}
	}
	
	public void insertExperiences(Experiences experiences) throws Exception{
		
		portfolioDao.insertExperiences(experiences);
		
	}
	
	public void insertEducation(Education education) throws Exception{
		
		portfolioDao.insertEducation(education);
	}*/
}
