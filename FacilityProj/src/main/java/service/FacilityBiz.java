package service;

import java.util.List;

import dao.FacilityDAO;
import dao.FacilityDAOImpl;
import dto.Facility;

public class FacilityBiz {
	private FacilityDAO facilityDAO;
	public FacilityBiz() {
		facilityDAO = new FacilityDAOImpl();
	}
	
	public List<Facility> getFacilityList() throws Exception {
		return facilityDAO.selectFacilityList();
	}

	public Facility getFacility(String id) throws Exception {
		return facilityDAO.selectFacility(id);
	}
	
	public void modifyFacility(String id, String name, Integer price, String etc) throws Exception {
		facilityDAO.updateFacility(id, name, price, etc);
	}
}