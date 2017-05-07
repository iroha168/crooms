package crooms.domain.model;
import javax.persistence.*;

@Entity
public class ContestProblem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "contest_id", referencedColumnName = "id")
	private Contest contest;


	private String problem_url;
	
	private String problem_body;
	
	public Contest getContest() {
		return contest;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getProblem_url() {
		return problem_url;
	}

	public void setProblem_url(String problem_url) {
		this.problem_url = problem_url;
	}

	public String getProblem_body() {
		return problem_body;
	}

	public void setProblem_body(String problem_body) {
		this.problem_body = problem_body;
	}
}
