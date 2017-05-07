package crooms.app.contest;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crooms.app.problem.SelectedProblemsForm;
import crooms.domain.model.CodeforcesProblems;
import crooms.domain.model.Contest;
import crooms.domain.model.ContestProblem;
import crooms.domain.repository.contest.ContestProblemRepository;
import crooms.domain.repository.contest.ContestRepository;
import crooms.domain.repository.problem.ProblemRepository;
import crooms.domain.service.contest.ContestProblemService;
import crooms.domain.service.problem.ProblemService;

@Controller
@RequestMapping("/contest")
public class ContestController {

	@Autowired
	ProblemService problemService;

	@Autowired
	ContestRepository contestRepository;

	@Autowired
	ContestProblemRepository contestProblemRepository;

	@Autowired
	ContestProblemService contestProblemService;
	
	@ModelAttribute
	private ContestForm setUpForm() {
		return new ContestForm();
	}

	// @Transactional
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String listContest(Model model) {
		List<Contest> contests = contestRepository.findAll();
		model.addAttribute("contests", contests);
		return "contest/list";
	}

	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public String resultContest(@CookieValue("problems") String problems, @Validated ContestForm contestForm,
			BindingResult result) {
		Contest contest = new Contest();
		BeanUtils.copyProperties(contestForm, contest);
		contestRepository.save(contest);
		String[] names = problems.split("__");
		List<CodeforcesProblems> problemList = new ArrayList<>();
		for (String name : names) {
			ContestProblem contestProblem = new ContestProblem();
			CodeforcesProblems selectedProblem = problemService.findByName(name);
			contestProblem.setProblem_url(selectedProblem.getUrl());
			contestProblem.setProblem_body(selectedProblem.getBody());
			contestProblem.setContest(contest);
			contestProblemRepository.save(contestProblem);
		}
		return "contest/list";
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String registerContest(Model model) {
		return "contest/register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String registerContent(@ModelAttribute("selectedProblemsForm") SelectedProblemsForm form, Model model) {
		List<String> ids = new ArrayList<>();
		for (String id : form.getCkId()) {
			ids.add(id);
		}
		model.addAttribute("ids", ids);
		return "contest/register";
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String contestRoom(@PathVariable("id") Integer id, Model model){
		Contest contest = contestRepository.findById(id);
		List<ContestProblem> contestProblem = contestProblemService.findByContestId(id);
		model.addAttribute("contest", contest);
		model.addAttribute("problems", contestProblem);
		return "contest/room";
	}
}
