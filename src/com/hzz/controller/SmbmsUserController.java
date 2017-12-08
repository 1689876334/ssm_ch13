package com.hzz.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hzz.entity.SmbmsRole;
import com.hzz.entity.SmbmsUser;
import com.hzz.service.SmbmsRoleService;
import com.hzz.service.SmbmsUserService;

@Controller
@RequestMapping("jsp")
public class SmbmsUserController {
	@Autowired
	private SmbmsUserService us=null;
	@Autowired
	private SmbmsRoleService rs=null;

	@RequestMapping(value="login.do",method={RequestMethod.POST,RequestMethod.GET})
	public String login(SmbmsUser user, HttpSession session,HttpServletRequest request){
		SmbmsUser login = us.login(user);
		if (login !=null) {
			session.setAttribute("userSession", login);
			return "jsp/frame";
		}else{
			request.setAttribute("error", "用户名或密码错误");
			return "login";
		}
	}
	@RequestMapping(value="user.do",method={RequestMethod.POST,RequestMethod.GET})
	public String userList(HttpSession session,String queryname,Integer queryUserRole,@RequestParam(defaultValue="1")Integer pageIndex){
		Integer pageSize=5;
		List<SmbmsUser> userList = us.getSmbmsUserPage(queryname, queryUserRole, pageIndex, pageSize);
		List<SmbmsRole> roleList = rs.getSmbmsRoleList();
		int totalCount=us.getCount(queryname, queryUserRole);
		int totalPageCount =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		session.setAttribute("roleList", roleList);
		session.setAttribute("userList", userList);
		//当前页
		session.setAttribute("currentPageNo", pageIndex); 
		//总页数
		session.setAttribute("totalPageCount", totalPageCount); 
		//总行数
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     	session.setAttribute("totalCount", totalCount);

		session.setAttribute("queryUserName", queryname);
		session.setAttribute("queryUserRole", queryUserRole);
		return "jsp/userlist";
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("userSession");
		return "login";
	}
	
	@RequestMapping(value="useradd.do",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") SmbmsUser user,HttpSession session){
		return "useradd";
	}
	@RequestMapping(value="addsave.do",method=RequestMethod.POST)
	public String addUserSave(SmbmsUser user,HttpSession session){
		user.setCreatedBy(((SmbmsUser)session.getAttribute("userSession")).getId());
		user.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int result = us.addSmbmsUser(user);
		if (result>0) {
			return "redirect:/jsp/user.do";
		}
		return "useradd";
	}
	
	//根据用户ID获取用户信息
	@RequestMapping(value="usermodify.do",method=RequestMethod.GET)
	public String getUserById(@RequestParam Long id,Map<String, Object> map){
		SmbmsUser user = us.getUsers(id);
		map.put("user", user);
		return "jsp/usermodify";
	}
	//修改用户
	@RequestMapping(value="usermodifysave.do",method=RequestMethod.POST)
	public String modifyUserSave(SmbmsUser user,HttpSession session){
		user.setModifyBy(((SmbmsUser)session.getAttribute("userSession")).getId());
		user.setModifyDate(new Timestamp(System.currentTimeMillis()));
		int result = us.updateSmbmsUser(user);
		if (result>0) {
			return "redirect:/jsp/user.do";
		}
		return "js/usermodify";
	}
	
	//查看信息
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable("id") Long id,Map<String, Object> model){
		SmbmsUser user = us.getUsers(id);
		model.put("user", user);
		return "jsp/userview";
		
	}
	@RequestMapping(value="deluser.do")
	public String deluser(@PathVariable("id") Long id,Map<String, Object> model){
		int result=us.deleteUserById(id);
		if (result>0) {
			return "redirect:/jsp/user.do";
		}
		return "jsp/userlist";
		
	}
	
	
	
	
	
	/*@RequestMapping(value="add.do",method=RequestMethod.GET)
	public String add(@ModelAttribute("user") SmbmsUser user,HttpSession session){
		return "add";
	}
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	public String addSave(@Valid SmbmsUser user,BindingResult bindingResult,HttpSession session){
		if (bindingResult.hasErrors()) {
			System.out.println("*********************************");
			return "add";
		}
		
		user.setCreatedBy(((SmbmsUser)session.getAttribute("userSession")).getId());
		user.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int result = us.addSmbmsUser(user);
		if (result>0) {
			return "redirect:/jsp/user.do";
		}
		return "add";
	}*/

}
