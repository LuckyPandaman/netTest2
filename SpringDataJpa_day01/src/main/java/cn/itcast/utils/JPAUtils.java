package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

   private static EntityManagerFactory factory;
   static{
      //读取配置文件并创建EntityManagerFactory
       factory = Persistence.createEntityManagerFactory("abc");

   }

   public static EntityManager createEntityManager(){

     //创建EntityManager
      EntityManager manager = factory.createEntityManager();

      return manager;
   }
}
