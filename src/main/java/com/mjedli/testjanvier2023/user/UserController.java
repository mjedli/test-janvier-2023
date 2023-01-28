/**
 * 
 */
package com.mjedli.testjanvier2023.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjedli.testjanvier2023.model.User;
import com.mjedli.testjanvier2023.sequence.SequenceGeneratorService;

/**
 * @author mjedli
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	/**
	 * <p>
	 * Returne la vue home
	 * </p>
	 * @return la vue home
	 */
	@GetMapping(value = "/")
	private String home() {
		return "home";
	}
	
	/**
	 * <p>
	 * Returne la vue home est permet d'inserer un utilisateur
	 * </p>
	 * @param user l'utilisateur à inserer
	 * @param modelMap le model qui contient l'information sur le déroulement de l'insertion de l'utilisateur
	 * @return la vue home avec le modelMap
	 * @throws Exception 
	 */
	@PostMapping(value = "/insert")
	private String insert(@ModelAttribute User user, Model modelMap) throws Exception {
		
		try {
			
			LocalDate now = LocalDate.now();
			DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
			LocalDate  birthday = LocalDate.parse(user.getBirthday().toString(), df);

			
			// verifier si l'utilistauer existe
			if(userService.findUserByEmail(user).size() > 0) {
				throw new Exception("User existe");
			} 
			// verifier si l'utilistauer est en France
			else if (!"france".equals(user.getCountry().toLowerCase())) {
				throw new Exception("Not France");
			} 			
			// verifier si l'utilistauer a 18 ans est plus
			else if (birthday.until(now).getYears() < 18) {
				throw new Exception("Not 18");
			} else {
				user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
				userService.insert(user);
				modelMap.addAttribute("paramok", "OK");
			}
			
		} catch(Exception e) {
			
			if("User existe".equals(e.getMessage())) {
				modelMap.addAttribute("paramerror", "E-mail exist.");
			} else if ("Not France".equals(e.getMessage())) {
				modelMap.addAttribute("paramerror", "Il faut être en France pour s'inscrire.");
			} else if ("Not 18".equals(e.getMessage())) {
				modelMap.addAttribute("paramerror", "Il faut avoir 18 ans.");
			} else {
				modelMap.addAttribute("paramerror", "Un problème est survenu.");
			}
			
			return "home";
		}
		
		return "home";
	}
	
	
	/**
	 * <p>
	 * Returne la vue liste des utilisateurs
	 * </p>
	 * @param modelMap le model qui contient l'information sur la liste des utilisateurs
	 * @return la vue liste
	 */
	@GetMapping(value = "/list")
	private String list(Model modelMap) {
		List<User> list = userService.findAllUsers();
		modelMap.addAttribute("list", list);
		return "list";
	}
	
	
	/**
	 * <p>
	 * Returne la vue details d'un utilisateur
	 * </p>
	 * @param id l'identificateur de l'utilisateur
	 * @param modelMap le model qui contient l'information sur l'utilisateur
	 * @return la vue details
	 */
	@GetMapping(value = "/user/{id}")
	private String details(@PathVariable Long id, Model modelMap) {
		User user = userService.findUserById(id);
		modelMap.addAttribute("user", user);
		return "details";
	}
	
}
