package com.gregorhue.theblog.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by gregorhue on 02.10.2020.
 */
public enum Vote {
	
	DOWNVOTE("downVote"), UPVOTE("upVote");
	
	@JsonValue
	private String displayText;

	private Vote(String displayText) {
		this.displayText = displayText;
	}

}
