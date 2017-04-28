package crooms.app.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "redirect:select/1";
	}
	
	@RequestMapping("/select/{no}")
	public String selectProblem(@PathVariable("no") int no, Model model){
		Page<CodeforcesProblems> problems = problemRepository.findAll(new PageRequest(no - 1, 20));
		SelectedProblemsForm form = new SelectedProblemsForm();
		List<CodeforcesProblems> problemsList = problems.getContent();
		long totalPage = problemRepository.count() / 20; 
		totalPage += problemRepository.count() % 20 > 0 ? 1 : 0;
		long lastPage = Math.min(totalPage, no+10);
		form.setProblems(problemsList);
		model.addAttribute("form", form);
		model.addAttribute("no", no);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("totalPage", totalPage);
		return "problem/select";
	}
}
