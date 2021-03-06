package com.example.zebranie;

import java.util.Date;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Zebranie")
public class Zebranie extends ParseObject {
	public Zebranie() {

	}

	public boolean isCompleted() {
		return getBoolean("completed");
	}

	public void setCompleted(boolean complete) {
		put("completed", complete);
	}


	public String getDescription() {
		return getString("description");
	}

	public void setDescription(String description) {
		put("description", description);
	}

	public String getDate() {
		return getString("date");
	}

	public void setDate(String date) {
		put("date", date);
	}
}
