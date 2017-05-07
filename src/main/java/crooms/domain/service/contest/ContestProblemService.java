package crooms.domain.service.contest;
import org.springframework.stereotype.Service;

import crooms.domain.model.ContestProblem;
import crooms.domain.repository.contest.ContestProblemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ContestProblemService {
	@Autowired
	ContestProblemRepository contestProblemRepository;
	public ContestProblem save(ContestProblem contestProblem){
		contestProblemRepository.save(contestProblem);
		return contestProblem;
	}
	
	public List<ContestProblem> findByContestId(int contestId){
		return contestProblemRepository.findByContestId(contestId);
	}
}
