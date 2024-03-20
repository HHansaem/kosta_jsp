package service;

import java.util.List;

import dao.LocationDAO;
import dao.LocationDAOImpl;
import vo.Location;

public class LocationServiceImpl implements LocationService {
	private LocationDAO locationDao = new LocationDAOImpl();

	@Override
	public List<Location> getLocationList(Integer page) throws Exception {
		if(page > getLocationMaxPage()) return null;
		int row = (page-1)*6;
		return locationDao.selectLocationList(row);
	}

	@Override
	public Integer getLocationMaxPage() throws Exception {
		int maxLocation = locationDao.selectLocationCnt();
		return (int)Math.ceil((double)maxLocation/6);
	}

}
