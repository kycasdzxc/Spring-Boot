package kr.co.yermi.firstboot.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.yermi.firstboot.info.model.City;
import kr.co.yermi.firstboot.info.model.Project;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InfoController {
	
//	@Autowired
	private InfoService infoService;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}
	
	@GetMapping("/cityList")
	public List<City> cityList() {
		log.debug("/cityList start");
		return infoService.getCityList();
	}
	
	@GetMapping("/info")
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
