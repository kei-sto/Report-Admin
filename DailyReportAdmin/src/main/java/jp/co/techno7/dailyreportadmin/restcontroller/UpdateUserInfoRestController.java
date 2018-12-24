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

import jp.co.techno7.dailyreportadmin.form.GetReportAdminForm;
import jp.co.techno7.dailyreportadmin.service.UpdateReportInfoService;

@RestController
public class UpdateUserInfoRestController {

	@Autowired
	UpdateReportInfoService uris;
	
	@CrossOrigin
	@RequestMapping(value="/UpdateUserInfo", method = {RequestMethod.POST}, produces="application/json; charset=UTF-8", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> updateReportInfo(@RequestBody GetReportAdminForm form){
		return uris.updateReportInfoService(form.getName(), form.getDefualtTitle(), form.getUnitCode(), form.getUserKey());
	}
	
}
