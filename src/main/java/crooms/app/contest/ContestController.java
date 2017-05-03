package crooms.app.contest;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crooms.app.problem.SelectedProblemsForm;
import crooms.domain.model.problem.CodeforcesProblems;
import crooms.domain.repository.problem.ProblemRepository;
import crooms.domain.service.Problem.ProblemService;

@Controller
@RequestMapping("/contest")
public class ContestController {

//	@Transactional
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String listContest(){
		return "contest/list";
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public String resultContest(@CookieValue("problems") String problems){
		return "contest/list";
	}
	
	@ModelAttribute
	private ContestForm setUpForm(){
		return new ContestForm();
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String registerContest(Model model){
		return "contest/register";
	}



	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String registerContent(@ModelAttribute("selectedProblemsForm") SelectedProblemsForm form, Model model){
		List<String> ids = new ArrayList<>();
		for(String id : form.getCkId()){
			ids.add(id);
		}
		model.addAttribute("ids", ids);
		return "contest/register";
	}
}
