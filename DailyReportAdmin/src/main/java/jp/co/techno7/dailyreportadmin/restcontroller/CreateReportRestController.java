package jp.co.techno7.dailyreportadmin.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.techno7.dailyreportadmin.form.CreateReportForm;
import jp.co.techno7.dailyreportadmin.service.CreateReportService;

@RestController
public class CreateReportRestController {

	@Autowired
	CreateReportService crs;
	
	@CrossOrigin
	@RequestMapping(value="/CreateReport", method = {RequestMethod.POST}, produces="application/json; charset=UTF-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> createReport(@RequestBody CreateReportForm form){
		return crs.createReportService(form.getReportTitle(), form.getCreateUserKey(), form.getCreateDate(), 
				form.getContents(), form.getProgress(), form.getJob_plan(), form.getImpression());
	}

}
