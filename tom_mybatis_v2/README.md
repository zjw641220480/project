# tom-mybatis-v2
最基础的sqlSession方式操作数据库,
dao方式操作数据库,需要写dao的实现类,实现类中的重复代码过多

mybatis二级缓存开启小总结
1:在SqlMapConfig.xml进行配置 -->  <setting name="cacheEnabled" value="true"></setting>
2:在mapper.xml中进行配置
3:需要开启二级缓存的pojo进行序列化
二级缓存可以将内存的数据写入到磁盘中,存在对象的序列化和反序列化,所以要实现Serializable接口;如果还包括有其它的pojo,那么都需要进行序列化

