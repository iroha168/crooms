package crooms.domain.model.problem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CodeforcesProblems {

	@Id
	private Integer id;
	
	private String url;
	
	private String name;
	
	private String title;

	private String html;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	
	
}
