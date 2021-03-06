package crooms.app.problem;

import java.util.ArrayList;
import java.util.List;

import crooms.domain.model.CodeforcesProblems;

import java.util.Collections;

public class SelectedProblemsForm {
	private List<String> ckId;
	private List<CodeforcesProblems> problems;
	

	public List<CodeforcesProblems> getProblems() {
		return problems;
	}

	public void setProblems(List<CodeforcesProblems> problems) {
		this.problems = problems;
	}

	public List<String> getCkId() {
		if(ckId == null){
			ckId =  Collections.emptyList();
		}
		return ckId;
	}

	public void setCkId(List<String> urls) {
		this.ckId = urls;
	}
}
