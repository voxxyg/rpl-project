package com.labti.springHibernate;

import com.labti.springHibernate.service.MahasiswaService;
import com.labti.springHibernate.view.MahasiswaView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    private static ApplicationContext applicationContext;
    
    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-configuration.xml");
        new MahasiswaView().setVisible(true);
    }
    
    public static MahasiswaService getMahasiswaService(){
        return(MahasiswaService)applicationContext.getBean("MahasiswaService");
    }   
}
