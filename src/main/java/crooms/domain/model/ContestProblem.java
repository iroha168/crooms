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


	private String problemName;
	
	private String problemTitle;
	
	private String problemUrl;
	
	private String problemBody;
	
	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getProblemUrl() {
		return problemUrl;
	}

	public void setProblemUrl(String problemUrl) {
		this.problemUrl = problemUrl;
	}

	public String getProblemBody() {
		return problemBody;
	}

	public void setProblemBody(String problemBody) {
		this.problemBody = problemBody;
	}

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
		return problemUrl;
	}

	public void setProblem_url(String problem_url) {
		this.problemUrl = problem_url;
	}

	public String getProblem_body() {
		return problemBody;
	}

	public void setProblem_body(String problem_body) {
		this.problemBody = problem_body;
	}
}
