package com.shxt.framework.user.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shxt.framework.user.model.User;
import com.shxt.framework.user.service.UserService;
import com.shxt.manager.model.Pager;

@Controller
@RequestMapping("/sys/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//�û��б��ʼ��
	@GetMapping("/list")
	public String list(Pager pager, ModelMap modelMap) {
		modelMap.addAttribute("pager", this.userService.find(pager));
		return "jsp/user/list";
	}
	
	//�޸�����
	@GetMapping("/password")
	public String password() {
		return "jsp/user/password";
	}

	// ��ת���ҳ��
	@GetMapping("/add")
	public String toAdd(Model model) {
		//model.addAttribute("role_name", this.userService.loadAll());
		return "jsp/user/add";
	}

	// ����û���Ϣ
	@PostMapping("/add")
	public String add(User user, Model model) {
		try {
			this.userService.add(user);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "�����û���Ϣ�ɹ�");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		//�ض����û��б�ҳ��
		return "redirect:/sys/user/list";
	}

	// ���������û���Ϣ��֤�û��������Ƿ��ظ�
	@GetMapping("/validAccount")
	@ResponseBody
	public Map<String, Object> validAccount(String account) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.userService.validAccount(account);
			map.put("flag", "success");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}

	// ͨ��������ѯ�û�ȫ����Ϣ
	@GetMapping("/update/{id}")
	public String load(@PathVariable("id") Integer user_id, Model model) {
		model.addAttribute("role_name", this.userService.loadAll());
		model.addAttribute("user", this.userService.load(user_id));
		return "jsp/user/update";
	}

	// �����û���Ϣ
	@PutMapping("/update")
	public String update(User user, Model model) {
		try {
			this.userService.update(user);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "�����û���Ϣ�ɹ�");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		return "redirect:/sys/user/list";
	}

	// ɾ���û���Ϣ
	@DeleteMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.userService.delete(user_id);
			map.put("flag", "success");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}

	// ͨ��������ѯ�û�������Ϣ
	@GetMapping("/selPassword")
	@ResponseBody
	public String selPassword(Integer user_id) {
		String userPwd = this.userService.selPassword(user_id);
		return userPwd;
	}

	// ���¿�����Ϣ
	@GetMapping("/updPassword")
	@ResponseBody
	public Map<String, Object> updPassword(Integer user_id, String new_password) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.userService.updPassword(user_id, new_password);
			map.put("flag", "success");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}


}
