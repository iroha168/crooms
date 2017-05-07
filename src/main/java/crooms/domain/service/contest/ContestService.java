package crooms.domain.service.contest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crooms.domain.model.CodeforcesProblems;
import crooms.domain.model.Contest;
import crooms.domain.model.ContestProblem;
import crooms.domain.repository.contest.ContestRepository;
import crooms.domain.repository.problem.ProblemRepository;

@Service
public class ContestService {
	@Autowired
	ContestRepository contestRepository;
	public Contest save(Contest contest){
		contestRepository.save(contest);
		return contest;
	}

	public Contest findById(int id){
		return contestRepository.findById(id);
	}
}
