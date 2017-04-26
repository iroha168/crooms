package crooms.app.contest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(path = "/register")
	public String registerContent(Model model){
		model.addAttribute(new ContestForm());
		return "contest/register";
	}
}
