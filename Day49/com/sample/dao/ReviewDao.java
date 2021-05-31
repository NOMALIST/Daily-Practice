package com.sample.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sample.util.MybatisUtils;
import com.sample.vo.Review;


public class ReviewDao {

	private static ReviewDao instance = new ReviewDao();
	
	private ReviewDao() {
		this.sqlSessionFactory =  MybatisUtils.getSqlSessionFactory();
	}
	
	public static ReviewDao getInstance() {
		return instance;
	}
	
	
	private SqlSessionFactory sqlSessionFactory;
	
	public void insertReview(Review review) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.insert("insertReview", review);
		session.close();
	}
	
	public List<Review> getReviewByProductNo(int productNo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Review> reviews = session.selectList("getReviewByProductNo", productNo);
		session.close();
		return reviews;
		
	}
	
	public void deleteReview(int reviewNo) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.delete("deleteReviewByNo", reviewNo);
		session.close();
	}
}
