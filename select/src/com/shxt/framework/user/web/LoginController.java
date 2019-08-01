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
	// �ӿڻص�
	@Autowired
	private UserService userService;
	@Autowired
	private LoginLogService loginLogService;

	@PostMapping("/login")
	public String login(String account, String password, ModelMap modelMap) {

		try {
			// ����userService��login������ȡuser��Ϣ
			User user = this.userService.login(account, password);
			// ��ȡsession
			this.session.setAttribute("session_user", user);

			// ��½�ɹ���¼��½��־
			LoginLog loginLog = new LoginLog();
			loginLog.setUser_id(user.getUser_id());
			loginLog.setIp(this.request.getRemoteAddr());
			// ����
			this.loginLogService.insert(loginLog);
			// �ض�����һ��controller
			return "redirect:/sys/main";
		} catch (LoginException ex) {
			ex.printStackTrace();
			// ��ȡ�Զ����쳣
			modelMap.addAttribute("message", ex.getMessage());
			// ��ȡ�û���,���ڻ����˺�
			modelMap.addAttribute("account", account);
			// ����ת����login.jspҳ��
			return "jsp/login";

		}
	}

}
