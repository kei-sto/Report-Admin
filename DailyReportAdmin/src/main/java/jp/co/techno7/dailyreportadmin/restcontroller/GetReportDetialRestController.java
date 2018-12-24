package jp.co.techno7.dailyreportadmin.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.techno7.dailyreportadmin.service.GetReportDetialService;

@RestController
public class GetReportDetialRestController {

	@Autowired
	GetReportDetialService grds;
	
	@RequestMapping("/GetReportDetail")
	public Map<String, Object> getReportDetial(@RequestParam("user_key") int userKey, @RequestParam("report_key") int reportKey)
	{
		return grds.getReportDetialService(userKey, reportKey);
	}

}
