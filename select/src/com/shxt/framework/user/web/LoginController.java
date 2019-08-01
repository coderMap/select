package com.shxt.framework.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shxt.framework.log.model.LoginLog;
import com.shxt.framework.log.service.LoginLogService;
import com.shxt.framework.user.exception.LoginException;
import com.shxt.framework.user.model.User;
import com.shxt.framework.user.service.UserService;
import com.shxt.manager.web.BaseController;

@Controller
@RequestMapping("/sys")
public class LoginController extends BaseController {
	// 接口回调
	@Autowired
	private UserService userService;
	@Autowired
	private LoginLogService loginLogService;

	@PostMapping("/login")
	public String login(String account, String password, ModelMap modelMap) {

		try {
			// 调用userService的login方法获取user信息
			User user = this.userService.login(account, password);
			// 获取session
			this.session.setAttribute("session_user", user);

			// 登陆成功记录登陆日志
			LoginLog loginLog = new LoginLog();
			loginLog.setUser_id(user.getUser_id());
			loginLog.setIp(this.request.getRemoteAddr());
			// 调用
			this.loginLogService.insert(loginLog);
			// 重定向到另一个controller
			return "redirect:/sys/main";
		} catch (LoginException ex) {
			ex.printStackTrace();
			// 获取自定义异常
			modelMap.addAttribute("message", ex.getMessage());
			// 获取用户名,用于回显账号
			modelMap.addAttribute("account", account);
			// 请求转发到login.jsp页面
			return "jsp/login";

		}
	}

}
