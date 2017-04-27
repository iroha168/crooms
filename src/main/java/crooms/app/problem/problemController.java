package crooms.app.problem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import crooms.domain.model.problem.CodeforcesProblems;
import crooms.domain.repository.problem.ProblemRepository;
import crooms.domain.service.Problem.ProblemService;

@Controller
@RequestMapping("/problem")
public class ProblemController {
	@Autowired
	ProblemService problemService;
	
	@Autowired
	ProblemRepository problemRepository;

	@RequestMapping("/select")
	public String selectProblem(Model model) {
		List<CodeforcesProblems> problems = problemRepository.findAll();
		SelectedProblemsForm form = new SelectedProblemsForm();
		form.setProblems(problems);
		model.addAttribute("form", form);
		return "problem/select";
	}
}
