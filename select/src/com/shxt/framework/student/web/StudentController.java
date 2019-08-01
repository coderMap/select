package com.shxt.framework.student.web;

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

import com.shxt.framework.student.model.Student;
import com.shxt.framework.student.service.StudentService;
import com.shxt.framework.title.model.Title;
import com.shxt.framework.title.service.TitleService;
import com.shxt.manager.model.Pager;

@Controller
@RequestMapping("/sys/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private TitleService titleService;

	// ѧ���б��ʼ��
	@GetMapping("/list")
	public String list(Pager pager, ModelMap modelMap) {
		modelMap.addAttribute("pager", this.studentService.list(pager));
		return "jsp/student/list";
	}

	// ��ת���ѧ��ҳ��
	@GetMapping("/add")
	public String toAdd(ModelMap modelMap) {
		// �������еİ༶
		modelMap.addAttribute("class_name", this.studentService.loadAllClass());
		return "jsp/student/add";
	}

	// ���ѧ��
	@PostMapping("/add")
	public String add(Student student, Model model) {
		try {
			this.studentService.add(student);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "����ѧ����Ϣ�ɹ�");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		// �ض����û��б�ҳ��
		return "redirect:/sys/student/list";
	}

	// ��������ѧ������֤�˺��Ƿ��ظ�
	@GetMapping("/validAccount")
	@ResponseBody
	public Map<String, Object> validAccount(String account) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.studentService.validAccount(account);
			map.put("flag", "success");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}

	// ͨ��������ѯѧ��
	@GetMapping("/update/{id}")
	public String load(@PathVariable("id") Integer student_id, Model model) {
		model.addAttribute("class_name", this.studentService.loadAllClass());
		System.out.println(this.studentService.loadAllClass());
		model.addAttribute("student", this.studentService.load(student_id));
		System.out.println(this.studentService.load(student_id));
		return "jsp/student/update";
	}

	// ����ѧ��
	@PutMapping("/update")
	public String update(Student student, Model model) {
		try {
			this.studentService.update(student);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "����ѧ����Ϣ�ɹ�");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		return "redirect:/sys/student/list";
	}

	// ɾ��ѧ��
	@DeleteMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer student_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.studentService.delete(student_id);
			map.put("flag", "success");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("flag", "error");
			map.put("message", ex.getMessage());
		}
		return map;
	}

	// ��ת��������Ϣҳ��
	@GetMapping("/myInfo")
	public String myInfo(ModelMap modelMap) {
		return "jsp/student/my/myInfo";
	}

	// ͨ���˺Ų�ѯѧ��
	@PostMapping("/loadByAccount/{account}")
	public String loadByAccount(@PathVariable("account") String account, ModelMap modelMap) {
		modelMap.addAttribute("student", this.studentService.loadByAccount(account));
		// ��������δѡ�����Ŀ
		modelMap.addAttribute("title", this.titleService.loadAllTitle());
		return "jsp/student/my/select";
	}

	// ѧ��ѡ��
	@PutMapping("/select")
	public String select(Title title, Model model) {
		try {
			this.titleService.update(title);
			model.addAttribute("flag", "success");
			model.addAttribute("message", "������Ŀ��Ϣ�ɹ�");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			model.addAttribute("flag", "error");
			model.addAttribute("message", ex.getMessage());
		}
		return "redirect:/sys/student/myInfo";
	}

}
