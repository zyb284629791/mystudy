package com.john.mybatislearning;

import com.john.mybatislearning.dao.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-28 14:28
 */
public class MyBatisDemo {

    public static void main(String[] args) throws IOException {
        String resource = "com/john/mybatislearning/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            mapper.selectBlog(101);
        } finally {
            session.close();
        }
    }
}
