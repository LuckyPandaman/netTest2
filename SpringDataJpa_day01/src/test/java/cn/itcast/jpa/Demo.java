package cn.itcast.jpa;

import cn.itcast.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {

   @Test
   //保存客户对象
   public void fun1() {


      EntityManagerFactory factory = Persistence.createEntityManagerFactory("abc");

      EntityManager manager = factory.createEntityManager();

      EntityTransaction tx = manager.getTransaction();

      tx.begin();
//---------------------------------------------------------------------------------------------------
      Customer c = new Customer();
      c.setCustName("传智播客");


      manager.persist(c);//保存客户
//---------------------------------------------------------------------------------------------------
      tx.commit();

      manager.close();

      factory.close();

   }
}
