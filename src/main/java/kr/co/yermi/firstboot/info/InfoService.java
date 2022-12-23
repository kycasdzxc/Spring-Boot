package kr.co.yermi.firstboot.info;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.yermi.firstboot.info.model.City;
import kr.co.yermi.firstboot.info.model.Project;
import kr.co.yermi.firstboot.info.repository.CityRepository;

@Service
public class InfoService {
	
	private final CityRepository cityRepository;
	
	// spring 4.2 이상은 @Autowired 생략 가능
	public InfoService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	public Project getProjectInfo() {
		Project project = new Project();
		project.projectName = "firstboot";
		project.author = "yermi";
		project.createDate = new Date();
		return project;
	}
	
	public List<City> getCityList() {
		return this.cityRepository.findList();
	}

	public List<City> findCityByCodeAndPopulation(String countryCode, int population) {
		return this.cityRepository.findByCountryCodeAndPopulation(countryCode, population);
	}
	
	public City insert(City city) {
		return this.cityRepository.insert(city);
	}

	public Integer updateById(City city) {
		return cityRepository.updateById(city);
	}
	
	public Integer deleteById(Integer id) {
		return cityRepository.deleteById(id);
	}
	
}
