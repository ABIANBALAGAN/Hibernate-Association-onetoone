	package com.model;
	import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

	public class HibernateUtil {
		public static StandardServiceRegistry registry=null;
		private static SessionFactory sf=null;
		public static SessionFactory getSessionFactory()
	       {	
		if(sf==null) {
				try {
				registry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources sources=new MetadataSources(registry);
				Metadata metadata=sources.getMetadataBuilder().build();
				sf=metadata.getSessionFactoryBuilder().build();
				}
				catch(Exception e) {
					e.printStackTrace();
					if(registry!=null)
						StandardServiceRegistryBuilder.destroy(registry);
				}
		}
		return sf;
	       }
	}
				