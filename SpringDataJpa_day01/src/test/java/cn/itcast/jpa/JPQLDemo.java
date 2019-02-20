package cn.itcast.jpa;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/*
详解JPQL查询
   介绍:
      Jave Persistence Query Language java持久化查询语言
      前身是HQL语言:Hibernate Query Language
      该语言是面向对象的,主要用于查询的语言.语法与SQL查询语句基本一致.
 */
public class JPQLDemo {

   @Test
   //查询所有客户
   public void fun1() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //定义JPQL语句
      //String jpql = " select c from cn.itcast.domain.Customer c "; //查询所有客户
      //String jpql = " select c from Customer c ";
      String jpql = " from Customer ";
      //封装到Query对象中
      Query query = manager.createQuery(jpql);
      //执行并获得查询结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }

   @Test
   //分页查询所有客户
   public void fun2() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //定义JPQL语句
      String jpql = " from Customer ";
      //封装到Query对象中
      Query query = manager.createQuery(jpql);
      //设置分页参数 limit ?,?
      query.setFirstResult(2); //第一个问号
      query.setMaxResults(2); //第二个问号
      //执行并获得查询结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }
   @Test
   //条件查询-> 客户名称中包含"李旭"的客户
   public void fun3() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //定义JPQL语句
      String jpql = " from Customer where custName like ? ";
      //封装到Query对象中
      Query query = manager.createQuery(jpql);
      //指定占位符的值
      query.setParameter(1,"%李旭%");
      //执行并获得查询结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }

   @Test
   //条件查询-> 客户名称中包含"李旭"的客户(命名占位符)
   public void fun3_2() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //定义JPQL语句
      String jpql = " from Customer where custName like :hehe ";
      //封装到Query对象中
      Query query = manager.createQuery(jpql);
      //指定占位符的值
      query.setParameter("hehe","%李旭%");
      //执行并获得查询结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }

   @Test
   //排序
   public void fun4() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //定义JPQL语句
      String jpql = " from Customer order by custId desc ";
      //封装到Query对象中
      Query query = manager.createQuery(jpql);
      //执行并获得查询结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }

   @Test
   //聚合函数=> count/sum/avg/max/min
   public void fun5() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //定义JPQL语句
      String jpql1 = " select count(c) from Customer c ";
      String jpql2 = " select sum(c.custId) from Customer c ";
      String jpql3 = " select avg(c.custId) from Customer c ";
      String jpql4 = " select max(c.custId) from Customer c ";
      String jpql5 = " select min(c.custId) from Customer c ";
      //封装到Query对象中
      Query query = manager.createQuery(jpql3);
      //执行并获得查询结果
      Number num = (Number) query.getSingleResult();

      System.out.println(num);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }
}
