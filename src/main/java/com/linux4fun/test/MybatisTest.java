package com.linux4fun.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.linux4fun.pojo.Category;

public class MybatisTest {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Category> list = sqlSession.selectList("listCategory");
		for(Category item : list) {
			System.out.println(item.getName());
		}
		sqlSession.close();
	}

}
