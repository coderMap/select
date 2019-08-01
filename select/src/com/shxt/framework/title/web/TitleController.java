package com.shxt.framework.title.web;

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

import com.shxt.framework.title.model.Title;
import com.shxt.framework.title.service.TitleService;
import com.shxt.framework.user.service.UserService;
import com.shxt.manager.model.Pager;

@Controller
@RequestMapping("/sys/title")
public class TitleController {
	@Autowired
	private TitleService titleService;

	@Autowired
	private UserService userService;

	// ��Ŀ�б��ʼ��
	@GetMapping("/list")
	public String list(Pager pager, ModelMap modelMap) {
		modelMap.addAttribute("pager", this.titleService.list(pager));
		return "jsp/title/list";
	}

	// ��ת���ҳ��
	@GetMapping("/add")
	public String toAdd(Model model) {
		// �������е���ʦ
		model.addAttribute("teacher", this.userService.loadAllTeacher());
		return "jsp/title/add";
	}

	// �����Ŀ��Ϣ
	@PostMapping("/add")
	public String add(Title title, Model model) {
		try {
			this.titleService.add(title);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "������Ŀ��Ϣ�ɹ�");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		// �ض����û��б�ҳ��
		return "redirect:/sys/title/list";
	}

	// ����������Ŀ�ظ�����֤
	@GetMapping("/validTitleName")
	@ResponseBody
	public Map<String, Object> validTitleName(String title_name) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.titleService.validTitleName(title_name);
			map.put("flag", "success");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}

	// ͨ��id��ѯ��Ŀ��Ϣ
	@GetMapping("/update/{id}")
	public String load(@PathVariable("id") Integer title_id, Model model) {
		model.addAttribute("title", this.titleService.load(title_id));
		// �������е���ʦ
		model.addAttribute("teacher", this.userService.loadAllTeacher());
		return "jsp/title/update";
	}

	// ����
	@PutMapping("/update")
	public String update(Title title, Model model) {
		try {
			this.titleService.update(title);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "������Ŀ��Ϣ�ɹ�");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		return "redirect:/sys/title/list";
	}

	// ɾ��
	@DeleteMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer title_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.titleService.delete(title_id);
			map.put("flag", "success");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}

	// ��ת����ʦ������Ϣҳ��
	@GetMapping("/myInfo")
	public String myInfo(Model model) {
		return "jsp/user/my/myInfo";
	}

	// ͨ����ʦ�˺Ų�ѯ��Ŀ
	@PostMapping("/loadByUserAccount/{account}")
	public String loadByUserAccount(@PathVariable("account") String account, ModelMap modelMap) {
		modelMap.addAttribute("title", this.titleService.loadByUserAccount(account));
		return "jsp/user/my/group";
	}

}
