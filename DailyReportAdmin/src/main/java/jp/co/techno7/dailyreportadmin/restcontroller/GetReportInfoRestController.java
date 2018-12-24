package jp.co.techno7.dailyreportadmin.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.techno7.dailyreportadmin.service.GetReportInfoService;

@RestController
public class GetReportInfoRestController {

	@Autowired
	GetReportInfoService gris;
	
	@RequestMapping("/GetReportInfo")
	public Map<String, Object> getReportInfo(){
		return gris.getReportInfoService();
	}
	
}
