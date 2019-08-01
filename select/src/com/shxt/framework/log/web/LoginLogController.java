package com.shxt.framework.log.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shxt.framework.log.service.LoginLogService;
import com.shxt.manager.model.Pager;

@Controller
@RequestMapping("/sys/loginlog")
public class LoginLogController {
	@Autowired
	private LoginLogService loginLogService;

	@GetMapping("/find")
	public String find(Pager pager ,ModelMap modelMap){
		//传递数据
		modelMap.addAttribute("pager",this.loginLogService.find(pager));
		return "jsp/loginlog/find";
	}

	//文档删除
	@DeleteMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String id){
		System.out.println(11);
		Map<String, Object> map= new HashMap<String, Object>();
		try {
			this.loginLogService.delete(id);
			System.out.println(id+"controller");
			map.put("flag", "success");
			map.put("message", "删除日志信息成功");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}

}
