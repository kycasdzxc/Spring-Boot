package kr.co.yermi.firstboot.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.yermi.firstboot.info.model.City;
import kr.co.yermi.firstboot.info.model.Project;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("info")
public class InfoController {
	
//	@Autowired
	private InfoService infoService;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}
	
	@PostMapping(value="cityAdd")
	public ResponseEntity<String> cityAdd(@RequestBody City city) {
		try {
			log.info("city = {}", city.toString());
			log.info(city.getId().toString());
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
//	@PostMapping(value="cityAdd")
//	public ResponseEntity<City> cityAdd(@RequestBody City city) {
//		log.info("city = {}", city.toString());
//		return new ResponseEntity<>(city, HttpStatus.OK);
//	}

//	@PostMapping(value="cityAdd")
//	public ResponseEntity<String> cityAdd(String name, String countryCode, String district, Integer population) {
//		log.info("name = {}, ctCode = {}, district = {}, population ={}", name, countryCode, district, population);
//		return new ResponseEntity<>("", HttpStatus.OK);
//	}
	
//	@GetMapping(value="cityAdd")
//	public Object cityAdd(City city) {
//		log.info("city = {}", city.toString());
//		return "ok";
//	}
	
//	@GetMapping("cityAdd")
//	public Object cityAdd(@RequestParam(value="name", required=true) String name
//			, @RequestParam(value="countryCode", required=true) String ctCode
//			, @RequestParam(value="district", required=true) String district
//			, @RequestParam(value="population", required = false, defaultValue = "0") int population) {
//		
//		log.info("name = {}, ctCode = {}, district = {}, population ={}", name, ctCode, district, population);
//		
//		return "ok";
//	}
	
//	@GetMapping("cityAdd/{name}/{countryCode}/{district}/{population}")
//	public Object cityAdd(@PathVariable(value="name") String name
//			, @PathVariable(value="countryCode") String ctCode
//			, @PathVariable(value="district") String district
//			, @PathVariable(value="population") int population) {
//		
//		log.info("name = {}, ctCode = {}, district = {}, population ={}", name, ctCode, district, population);
//		
//		return "ok";
//	}
	
	@GetMapping("cityListByCode/{countryCode}/{population}")
	public List<City> cityByCountryCode(@PathVariable("countryCode") String ctCode, @PathVariable("population") int population) {
		log.info("countryCode = {}, population {}", ctCode, population);
		
		List<City> cityList = infoService.findCityByCodeAndPopulation(ctCode, population);
		return cityList;
	}
	
//	@GetMapping("cityListByCode")
//	public List<City> cityByCountryCode(@RequestParam("countryCode") String ctCode
//			, @RequestParam(value="population", required = false, defaultValue = "0") int population) {
//		log.info("countryCode = {}, population = {}", ctCode, population);
//		
//		List<City> cityList = infoService.findCityByCodeAndPopulation(ctCode, population);
//		return cityList;
//	}
		
	@GetMapping("cityList")
	public List<City> cityList() {
		log.debug("/cityList start");
		return infoService.getCityList();
	}
	
	@GetMapping("project")
	public Project projectInfo() {
		log.debug("/info start");
		Project project = infoService.getProjectInfo();
		return project;
	}
	
//	@GetMapping("/info")
//	public Project projectInfo() {
//		log.debug("/info start");
//		
//		Project project = new Project();
//		project.projectName = "firstboot";
//		project.author = "yermi";
//		project.createDate = new Date();
//		
//		log.info("return {}", project.toString());
//		return project;
//	}
	
//	@GetMapping("/info")
//	public String projectInfo() {
//		return "Project name is firstboot.";
//	}
}
