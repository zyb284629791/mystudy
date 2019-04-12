package com.john;

import com.john.mvc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-25 16:44
 */
@Repository
public class HelloDao {

    private String defaultName = "Java";

    @Autowired
    private JdbcOperations jdbcOperations;

    public void sayHello(String name){
        System.out.printf("Hello %s \n", StringUtils.isEmpty(name) ? defaultName : name);
    }

    public void testConnection(long id){
        User user = (User) jdbcOperations.queryForObject("select * from t_user t where t.id = ?",new Object[]{id}, new BeanPropertyRowMapper(User.class));
        System.out.println(user);
    }
}
