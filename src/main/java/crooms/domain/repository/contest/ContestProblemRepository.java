package crooms.domain.repository.contest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import crooms.domain.model.ContestProblem;

public interface ContestProblemRepository extends JpaRepository<ContestProblem, Integer>{
	public List<ContestProblem> findByContestId(int contestId);
}
