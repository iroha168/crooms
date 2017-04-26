package crooms.domain.repository.problem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import crooms.domain.model.problem.CodeforcesProblems;

public interface ProblemRepository extends JpaRepository<CodeforcesProblems, Integer>{
}
