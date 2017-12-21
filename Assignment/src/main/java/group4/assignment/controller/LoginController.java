package group4.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import group4.assignment.dao.LoginDAO;
import group4.assignment.dao.UserDAO;
import group4.assignment.model.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest arg0, HttpServletResponse arg1){
		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/handlingLogin", method=RequestMethod.POST)
	public String handlingLogin(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("username") String user,@RequestParam("password") String pass,HttpSession session){
		// TODO Auto-generated method stub
		LoginDAO loginDAO = new LoginDAO();
		UserDAO userDAO = new UserDAO();
		if(loginDAO.checkLogin(user, pass)){
			List<User> list = loginDAO.getInforIfLoginSucess(user);
			session.setAttribute("name", list.get(0).getFirstName() ); //+ " " +list.get(0).getLastName() 
			session.setAttribute("groupId", list.get(0).getGroupID());
			
			return "redirect:importdata";
		}
		else{
			
			redirectAttributes.addFlashAttribute("message","Tài khoản hoặc mật khẩu không đúng! Vui lòng nhập lại! ");
			return "redirect:/";
		}
	}
}
