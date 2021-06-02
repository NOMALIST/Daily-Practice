package com.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sample.util.MybatisUtils;
import com.sample.vo.Board;


public class BoardDao {

	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	
	private BoardDao() {
		this.sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
	}
	
	public void insertBoard(Board board) {
		SqlSession session  = sqlSessionFactory.openSession(true);
		session.insert("insertBoard", board);
		session.close();
	}
	
	public List<Board> getBoards(int beginIndex, int endIndex) {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> index = new HashMap<String, Object>();
		index.put("beginIndex", beginIndex);
		index.put("endIndex", endIndex);
		List<Board> boards = session.selectList("getBoards", index);
		return boards;
	}
	
	public int getBoardRowsCount() {
		SqlSession session = sqlSessionFactory.openSession();
		int rows = session.selectOne("getBoardRowsCount");
		session.close();
		return rows;
	}
	
	public Board getBoardByNo(int boardNo) {
		SqlSession session = sqlSessionFactory.openSession();
		Board board = session.selectOne("getBoardByNo",boardNo);
		session.close();
		return board;
	}
	
	public void updateBoardByNo(Board board) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("updateBoardByNo", board);
		session.close();
	}
	
	public void deleteBoardByNo(int boardNo) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("deleteBoardByNo", boardNo);
		session.close();
	}
	
	
}
