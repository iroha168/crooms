package crooms.domain.service.problem;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.stereotype.Service;

import crooms.domain.model.CodeforcesProblems;
import crooms.domain.repository.problem.ProblemRepository;

@Service
//@Transactional
public class ProblemService {

	@Autowired
	ProblemRepository problemRepository;
	
	public CodeforcesProblems save(CodeforcesProblems codeforcesProblems){
		problemRepository.save(codeforcesProblems);
		return codeforcesProblems;
	}
	
	public CodeforcesProblems findByName(String name){
		return problemRepository.findByName(name);
	}
}
