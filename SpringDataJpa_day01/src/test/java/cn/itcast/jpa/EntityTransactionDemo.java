package cn.itcast.jpa;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
详解EntityTransaction对象

   功能:
      事务管理对象,用于管理事务.
      事务开启|提交|回滚...
 */
public class EntityTransactionDemo {

   @Test
   public void fun1() {
      //读取配置文件并创建EntityManagerFactory
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("abc");
      //创建EntityManager
      EntityManager manager = factory.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      tx.commit();//提交事务
      tx.rollback();//回滚事务
   }

}
