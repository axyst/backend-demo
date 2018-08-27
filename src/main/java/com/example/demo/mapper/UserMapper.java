package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

// mybatis实现数据库操作 (DAO层)
//@CacheConfig(cacheNames = "users")
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    List<User> findByNameList(@Param("name") String name);

    //@Cacheable
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User findById(@Param("id") Long id);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Update("UPDATE USER SET NAME=#{name} WHERE ID=#{id}")
    void updateName(@Param("id")Long id, @Param("name")String name);

    @Update("UPDATE USER SET Age=#{age} WHERE ID=#{id}")
    void updateAge(@Param("id")Long id, @Param("age")Integer age);

    @Delete("DELETE FROM USER WHERE ID =#{id}")
    void delete(@Param("id")Long id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT id, name, age FROM user")
    List<User> findAll();


}