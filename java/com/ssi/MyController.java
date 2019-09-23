package com.ssi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("newStudent")
	public String AddStudent(@ModelAttribute("info") Student model){
		
		Configuration config= new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		org.hibernate.Transaction tr=session.beginTransaction();	
		session.save(model);
		tr.commit();
		session.close();
		System.out.println("Data Added");
		
		
		return "index.jsp";
	}

	@RequestMapping("findStudent")
	public  ModelAndView SearchStudent(@RequestParam("rno") int rollno){
	Configuration config= new Configuration().configure();
	SessionFactory sf=config.buildSessionFactory();
	Session session=sf.openSession();
	
//		String sql =" select * from student where id=? ";
//		
//		SQLQuery query = session.createSQLQuery(sql);
//		query.setParameter(1, rollno);
//		//query.addEntity(StudentModel.class);
//		
//		List<Object[]> list = query.list();
//		for(Object objects[]:list)
//		 {
//			System.out.println(objects[0]+"  "+objects[1]+" "+objects[2]+" "+objects[3]);
//			s.setId(Integer.parseInt(objects[0].toString()));
//			s.setName((objects[1].toString()));
//			s.setPhno((objects[2].toString()));
//			s.setMarks(Integer.parseInt(objects[3].toString()));
//			
//		 }
		Student s=new Student();	
		ModelAndView mv=new ModelAndView("SearchStudent.jsp");
		s=session.get(Student.class, rollno);
		System.out.println(s);
		mv.addObject("info", s);
		return mv;
	}
	@RequestMapping("ViewStudent")
	public  ModelAndView AllStudent(){
	Configuration config= new Configuration().configure();
	SessionFactory sf=config.buildSessionFactory();
	Session session=sf.openSession();
	
		/*String sql =" select * from student ";
		
		SQLQuery query = session.createSQLQuery(sql);
		//query.addEntity(StudentModel.class);*/
		Criteria cr=session.createCriteria(Student.class);
		List<Student> l1=cr.list();
		System.out.println(l1);
		
		ModelAndView mv=new ModelAndView("ViewStudent.jsp");
		
		/*List<Object[]> list = query.list();
		List<Student> listStudent = new ArrayList<Student>(); 
		for(Object objects[]:list)
		 {Student s=new Student();
			System.out.println(objects[0]+"  "+objects[1]+" "+objects[2]+" "+objects[3]);
			s.setRno(Integer.parseInt(objects[0].toString()));
			s.setSname((objects[1].toString()));
			s.setBranch((objects[2].toString()));
			s.setMarks(Integer.parseInt(objects[3].toString()));
			listStudent.add(s);
			
		 }*/
		
		mv.addObject("infoAll", l1);
		return mv;
	}
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("rno") int rollno){
		Configuration config= new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx2=session.beginTransaction();
		Student s=new Student(rollno);
		/*Student s=session.get(Student.class, rollno);
		System.out.println("##########"+s);*/
		
		session.delete(s);
		tx2.commit();
		session.close();
		
		ModelAndView mv=new ModelAndView("redirect:ViewStudent");
		return mv;
	}
}
