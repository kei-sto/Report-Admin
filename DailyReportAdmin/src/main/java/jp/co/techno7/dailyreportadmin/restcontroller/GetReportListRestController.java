package jp.co.techno7.dailyreportadmin.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.techno7.dailyreportadmin.service.GetReportListService;

@RestController
public class GetReportListRestController {

	@Autowired
	GetReportListService grls;
	
	@RequestMapping("/GetReportList")
	public List<Map<String, Object>> getReportList(@RequestParam("user_key") int userKey){
		return grls.getReportListService(userKey);
	}

}
