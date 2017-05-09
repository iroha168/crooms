package crooms.app.contest;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ContestForm {
	
	private String name;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private LocalDateTime startTime;
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime duration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
}