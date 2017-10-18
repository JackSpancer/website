package net.blover.website.user.dao;

import net.blover.website.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    //    @Select("select * from user where id = #{id}")
    User getById(String id);

//    User getUserByName(String name);
}
