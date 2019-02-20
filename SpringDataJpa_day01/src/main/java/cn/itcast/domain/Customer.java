package cn.itcast.domain;

import javax.persistence.*;
//@Entity : 标识性注解,表示当前类是实体类
@Entity
/*
@Table : 指定实体与表的对应.
   name属性: 指定实体对应的表名
 */
@Table(name = "cst_customer")
public class Customer {

   /*
      @GeneratedValue : 指定主键生成策略=> 决定保存当前对象时,主键值如何生成
         IDENTITY : 主键自增 (依赖于数据库: MySql|SqlServer|SqlLite..)
         SEQUENCE : 使用序列维护主键值 (依赖于数据库:Oracle)
                @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "abc")
               //sequenceName : 指定序列名称 initialValue:指定序列初始值
               @SequenceGenerator(name="abc",sequenceName = "seq_customer",initialValue = 1)
         TABLE: 使用一张表来记录主键值.根据表中的记录生成主键值. (适用于在没有序列的数据库模拟序列的效果)
               @GeneratedValue(strategy = GenerationType.TABLE,generator = "abc")
               @TableGenerator(name="abc",
                              table = "mysql_sequence",
                              pkColumnName = "name",
                              valueColumnName ="value",
                              pkColumnValue = "cst_customer",
                              initialValue = 0,
                              allocationSize = 1)
         AUTO: 自动三选一. 有问题. 自动选择的老是Table
    */
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
   @Id:标识性质注解.标识与数据库主键对应的属性.=>OID(ObjectID)
    */
   @Id
   /*
      @Column : 描述属性与表中的列的对应关系
         name属性: 属性对应的列名,默认值就是属性名.
         length属性:指定列长度
         nullable属性:是否使用非空约束
         unique属性:是否使用唯一约束
         insertable属性: 生成insert语句时是否包含该列(默认为true)
         updatable属性:  生成update语句时是否包含该列(默认为true)
        precision|scale属性: 指定浮点类型数据的有效长度,和小数点后位数

    */
   @Column()
   private long custId;

   @Column(name="custName")
   private String custName;

   @Column(name="cust_source")
   private String custSource;

   @Column(name="cust_industry")
   private String custIndustry;

   @Column(name="cust_level")
   private String custLevel;

   @Column(name="cust_address")
   private String custAddress;

   @Column(name="cust_phone")
   private String custPhone;

   public long getCustId() {
      return custId;
   }

   public void setCustId(long custId) {
      this.custId = custId;
   }

   public String getCustName() {
      return custName;
   }

   public void setCustName(String custName) {
      this.custName = custName;
   }

   public String getCustSource() {
      return custSource;
   }

   public void setCustSource(String custSource) {
      this.custSource = custSource;
   }

   public String getCustIndustry() {
      return custIndustry;
   }

   public void setCustIndustry(String custIndustry) {
      this.custIndustry = custIndustry;
   }

   public String getCustLevel() {
      return custLevel;
   }

   public void setCustLevel(String custLevel) {
      this.custLevel = custLevel;
   }

   public String getCustAddress() {
      return custAddress;
   }

   public void setCustAddress(String custAddress) {
      this.custAddress = custAddress;
   }

   public String getCustPhone() {
      return custPhone;
   }

   public void setCustPhone(String custPhone) {
      this.custPhone = custPhone;
   }

   @Override
   public String toString() {
      return "Customer{" +
       "custId=" + custId +
       ", custName='" + custName + '\'' +
       '}';
   }
}
