package dao;

import java.util.List;

import dto.Facility;

public interface FacilityDAO {
	List<Facility> selectFacilityList() throws Exception;
	Facility selectFacility(String id) throws Exception;
	void updateFacility(String id, String name, Integer price, String etc) throws Exception;
}
