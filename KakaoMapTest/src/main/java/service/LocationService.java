package service;

import java.util.List;

import vo.Location;

public interface LocationService {
	List<Location> getLocationList(Integer page) throws Exception;
	Integer getLocationMaxPage() throws Exception;
}
