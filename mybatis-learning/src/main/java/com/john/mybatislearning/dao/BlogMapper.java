package com.john.mybatislearning.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-28 15:08
 */
public interface BlogMapper {

    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);
}
