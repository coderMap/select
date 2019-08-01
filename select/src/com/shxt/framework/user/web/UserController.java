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
	
	
	//用户列表初始化
	@GetMapping("/list")
	public String list(Pager pager, ModelMap modelMap) {
		modelMap.addAttribute("pager", this.userService.find(pager));
		return "jsp/user/list";
	}
	
	//修改密码
	@GetMapping("/password")
	public String password() {
		return "jsp/user/password";
	}

	// 跳转添加页面
	@GetMapping("/add")
	public String toAdd(Model model) {
		//model.addAttribute("role_name", this.userService.loadAll());
		return "jsp/user/add";
	}

	// 添加用户信息
	@PostMapping("/add")
	public String add(User user, Model model) {
		try {
			this.userService.add(user);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "新增用户信息成功");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		//重定向到用户列表页面
		return "redirect:/sys/user/list";
	}

	// 用于新增用户信息验证用户的名字是否重复
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

	// 通过主键查询用户全部信息
	@GetMapping("/update/{id}")
	public String load(@PathVariable("id") Integer user_id, Model model) {
		model.addAttribute("role_name", this.userService.loadAll());
		model.addAttribute("user", this.userService.load(user_id));
		return "jsp/user/update";
	}

	// 更新用户信息
	@PutMapping("/update")
	public String update(User user, Model model) {
		try {
			this.userService.update(user);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "更新用户信息成功");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		return "redirect:/sys/user/list";
	}

	// 删除用户信息
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

	// 通过主键查询用户口令信息
	@GetMapping("/selPassword")
	@ResponseBody
	public String selPassword(Integer user_id) {
		String userPwd = this.userService.selPassword(user_id);
		return userPwd;
	}

	// 更新口令信息
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
