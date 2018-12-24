package jp.co.techno7.dailyreportadmin.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.techno7.dailyreportadmin.service.GetReportSeqService;

@RestController
public class GetReportSeqRestController {

	@Autowired
	GetReportSeqService grss;
	
	@RequestMapping("/GetReportSeq")
	public Map<String, Object> getReportSeq(){
		return grss.getReportSeqService();
	}
}
