package cn.itcast.jpa;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
详解EntityManager对象

   功能:
      是JPA中数据库操作核心对象.
      一切数据库操作:CRUD 都是通过EntityManager对象完成的.
 */
public class EntityManagerDemo {

   @Test
   //增
   public void fun1() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      Customer c = new Customer();
      c.setCustName("黑马程序员");

      manager.persist(c);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }

   @Test
   //查(OID查询) => 根据ID查询
   //find : 立即加载
   public void fun2_1() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //查询主键值为1l的Customer对象
      Customer c = manager.find(Customer.class, 1L);
      System.out.println("------------------------------------------------------------------------");
      System.out.println(c);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }
   @Test
   //查(OID查询) => 根据ID查询
   // getReference => 延迟加载.使用时才查询.
   public void fun2_2() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //查询主键值为1l的Customer对象
      Customer c = manager.getReference(Customer.class, 1L);
      System.out.println("------------------------------------------------------------------------");
      //System.out.println(c);
      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }

   @Test
   //修改 => 先查后改
   public void fun3() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //查询主键值为1l的Customer对象
      Customer c = manager.find(Customer.class, 1L);

      c.setCustName("李旭洗脚城");

      manager.merge(c);//修改

      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }
   @Test
   //修改 => 自己创建对象修改
   //注意:属性值丢失问题
   public void fun3_2() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //查询主键值为1l的Customer对象
      Customer c = new Customer();

      c.setCustId(1L);

      c.setCustName("李旭洗头房");

      manager.merge(c);//修改

      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }

   @Test
   //删除 => 先查后删
   public void fun4() {

      EntityManager manager = JPAUtils.createEntityManager();
      //获得Transaction对象
      EntityTransaction tx = manager.getTransaction();
      tx.begin();//开启事务
      //------------------------------------------------------------------------------------
      //查询主键值为1l的Customer对象
      Customer c = manager.find(Customer.class, 1L);

   //删除对象
      manager.remove(c);

      //------------------------------------------------------------------------------------
      tx.commit();//提交事务
      manager.close();
   }
}
