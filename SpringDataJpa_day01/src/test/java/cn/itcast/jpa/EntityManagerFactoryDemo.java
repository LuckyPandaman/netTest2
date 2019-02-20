package cn.itcast.jpa;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
详解EntityManagerFactory对象

   功能:
      创建EntityManager
   注意:
        1.该对象消耗内存资源较大
        2.该对象线程安全
   结论:
      要确保在项目中,EntityManagerFactory只创建一个实例.
 */
public class EntityManagerFactoryDemo {

   @Test
   public void fun1() {
      //读取配置文件并创建EntityManagerFactory
      EntityManagerFactory factory = Persistence
                                    .createEntityManagerFactory("abc");
      //创建EntityManager
      EntityManager manager = factory.createEntityManager();
   }

}
