# tom-mybatis-v2
最基础的sqlSession方式操作数据库,
dao方式操作数据库,需要写dao的实现类,实现类中的重复代码过多

sql片段在/tom_mybatis_v2/src/main/resources/oracle/mapper/User.xml文件下;

直接操纵SqlSession(mybatis最最原始的方式);在Dao的实现类中注入SqlSessionFactory,在dao中操作SqlSession,
间接操作dao来操作数据库(mybatis原始dao的开发方式),dao的实现类中有模板代码的存在;SqlSessionFactory生成SqlSession,使用SqlSession生成mapper代理对象,原来的模板代码由代理对象来生成,进而操作数据(mybatis的mapper代理开发模式)

mybatis二级缓存开启小总结
通过mybatis-ehcache整合包进行,不需要再注入其它东西
1:在SqlMapConfig.xml进行配置 -->  <setting name="cacheEnabled" value="true"></setting>
2:在mapper.xml中进行配置
3:需要开启二级缓存的pojo进行序列化
二级缓存可以将内存的数据写入到磁盘中,存在对象的序列化和反序列化,所以要实现Serializable接口;如果还包括有其它的pojo,那么都需要进行序列化

和spring整合后,
原始dao开发中主要就是需要注入SqlSessionFactory;
mapper代理的开发方式中,接口和dao是不变的,代理对象由Spring容器来生成和管理,直接从spring容器中拿取就是了;

mybatis的延迟加载并没有hibernate那么严重;并不需要格外注意,mybatis容易出现全加载的情况


