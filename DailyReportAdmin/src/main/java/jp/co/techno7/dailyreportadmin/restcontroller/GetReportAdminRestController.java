package jp.co.techno7.dailyreportadmin.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.techno7.dailyreportadmin.service.GetReportAdminService;

@RestController
public class GetReportAdminRestController {

	@Autowired
	GetReportAdminService gras;
	
	@RequestMapping("/GetReportAdmin")
	public Map<String, Object> getReportAdmin(@RequestParam("user_key") int userKey){
		return gras.getReportAdminService(userKey);
	}

}
