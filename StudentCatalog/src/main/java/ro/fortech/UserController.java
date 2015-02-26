package ro.fortech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.fortech.bean.User;
import ro.fortech.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String student(Model model) {
		model.addAttribute("userData", new User());
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("userData", new User());
		return "register";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {

		if (this.userService.checkIfUsernameExists(user.getUsername()) == false) {
			this.userService.addUser(user);
		} else {
			// existing person, call update
			return "userExists";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userData") User userDetails) {
		userDetails.setTeacher(false);
		User user = this.userService.checkUser(userDetails.getUsername(), userDetails.getPassword());
		if (user != null) {
			if (user.isTeacher() == true) {
				return "redirect:/grades";
			} else {
				return "redirect:/studentGrades/" + user.getId();
			}
		} else {
			return "loginFailed";
		}
	}
	
	@RequestMapping("/remove/student/{studentId}")
	public String removeGrade(@PathVariable("studentId") int studentId) {
		this.userService.deleteUser(studentId);
		return "redirect:/students";
	}
}
