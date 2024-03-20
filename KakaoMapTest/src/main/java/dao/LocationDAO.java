package dao;

import java.util.List;

import vo.Location;

public interface LocationDAO {
	List<Location> selectLocationList(Integer row) throws Exception;
	Integer selectLocationCnt() throws Exception;
}
