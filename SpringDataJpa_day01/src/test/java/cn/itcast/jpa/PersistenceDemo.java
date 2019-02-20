package cn.itcast.jpa;

import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
详解Persistence对象

   功能:
      1.读取配置文件
      2.创建EntityManagerFactory
 */
public class PersistenceDemo {

   @Test
   public void fun1() {
      //读取配置文件并创建EntityManagerFactory
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("abc");
   }
}
