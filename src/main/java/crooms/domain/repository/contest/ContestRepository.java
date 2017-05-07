package crooms.domain.repository.contest;
import org.springframework.data.jpa.repository.JpaRepository;

import crooms.domain.model.Contest;

public interface ContestRepository extends JpaRepository<Contest, Integer>{
	public Contest findById(int id);
}
