package com.nagarro.training.advancejava.assignment4.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.nagarro.training.advancejava.assignment4.dao.TShirtDao;
import com.nagarro.training.advancejava.assignment4.dao.UserDao;
import com.nagarro.training.advancejava.assignment4.model.TShirt;
import com.nagarro.training.advancejava.assignment4.model.User;
import com.nagarro.training.advancejava.assignment4.service.Search;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("unused")
@Controller
public class App {

	@Autowired
	private UserDao userDao;
	@Autowired
	private TShirtDao tshirtDao;
	Search s = new Search();

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView check(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		boolean user = this.validate(uname, pass);
		HttpSession httpSession = request.getSession();

		System.out.println(uname);
		System.out.println(pass);
		
		if (user == true) {
			System.out.println("true");
			HttpSession session = request.getSession();
			session.setAttribute(uname, uname);
			mv.setViewName("product");
		} else {
			System.out.println("false");
			httpSession.setAttribute("message", "Invalid id/password");
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView search(Model m, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String colour = request.getParameter("colour");
		String size = request.getParameter("size");
		String gender = request.getParameter("gender");
		int preference = Integer.parseInt(request.getParameter("preference"));
		System.out.println(colour);
		System.out.println(size);
		System.out.println(gender);
		System.out.println(preference);

		ArrayList<TShirt> list = s.search(tshirtDao, colour, size, gender, preference);
		for (TShirt itr : list) {
			itr.getId();
		}
		m.addAttribute("list", list);
		mv.setViewName("product");

		return mv;
	}
	
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("uname", null);
		mv.setViewName("index");
		return mv;
	}

	public boolean validate(String uname, String pass) {
		boolean result = false;
		List<User> users = userDao.getAllUser();
		for (User itr : users) {

			if (itr.getUname().equals(uname) && itr.getPass().equals(pass)) {
				System.out.println(itr.getUname());
				System.out.println(itr.getPass());
				result = true;
			}
		}
		return result;
	}
}
