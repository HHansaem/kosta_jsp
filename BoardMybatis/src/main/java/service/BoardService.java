package service;

import javax.servlet.http.HttpServletRequest;

import dto.Board;

public interface BoardService {
	void boardWrite(HttpServletRequest request) throws Exception;
	void boardListByPage(HttpServletRequest request) throws Exception;
	Board boardDetail(Integer num) throws Exception;
	void boardModify(HttpServletRequest request) throws Exception;
}
