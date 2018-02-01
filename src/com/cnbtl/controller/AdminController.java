package com.cnbtl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cnbtl.entity.User;
import com.cnbtl.service.UserService;
import com.cnbtl.util.JsonResult;

/**
 * Admin controller ����Ա���������
 * 1.����Ա��¼(���Ʒ�ʽ)
 * 
 * 
 * @author Mrruan
 *
 */

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	
	/**
	 * ����Ա�û���¼�Ĵ�����
	 * @param username �û���
	 * @param password ����
	 * @return ��ʽ:JSON ����:��¼ʧ�ܷ���false,��¼�ɹ�����token
	 */
	@RequestMapping(value="/adminlogin")
	@ResponseBody
	public String adminlogin(HttpSession session,@RequestParam String username,@RequestParam String password) {
		System.out.println("front-->" + username + "  " +password);
		User user = userService.login(username, password);
		System.out.println("db-->" + user);
		if(user == null) {
			return JsonResult.RS_FALSE;
		}else {
			//��¼�ɹ�
			session.setAttribute("user", user);
			return "{\"token\":\"" + user.getPassword() + "\"}";
		}
	}
	
	@RequestMapping("/logoff")
	public String logoff(HttpSession session) {
		session.removeAttribute("user");
		return "/internal/logoff";
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public ModelAndView main(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/internal/index");
		mdv.addObject("user", session.getAttribute("user"));
		return mdv;
	}
	
	@RequestMapping("/showcase")
	public ModelAndView showcase() {
		ModelAndView mdv = new ModelAndView();
		//������ʾ���е�ҳ��
		mdv.setViewName("/internal/showcase");
		//����
		return mdv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit() {
		//ȥ���༭ҳ��
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/internal/fulleditor");
		return mdv;
	}
	
}
