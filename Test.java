package com.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
public static void main(String[] args) {
	Transaction tr=null;
	try(Session ses=HibernateUtil.getSessionFactory().openSession()){
			tr=ses.beginTransaction();
			Employee e=new Employee();
			e.setName("Ramesh");
			e.setEmail("ramesh@gmail.com");
			Address a=new Address(0, "VSB COLLEGE","COVAI ROAD","KARUR","TAMILNADU",639002, e);
			e.setAddr(a);
			a.setEmp(e);
			ses.persist(e);
			tr.commit();
			ses.close();
			
}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
