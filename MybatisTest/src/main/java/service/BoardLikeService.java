package service;

public interface BoardLikeService {
	boolean boardLike(String memberId, Integer boardNum) throws Exception;
	boolean togleBoardLike(String memberId, Integer boardNum) throws Exception;
}
