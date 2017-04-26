package crooms.app.contest;

import java.time.LocalTime;

public class ContestForm {
	
	private String name;
	private LocalTime date;
	private Integer duration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalTime getDate() {
		return date;
	}
	public void setDate(LocalTime date) {
		this.date = date;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}	
}
