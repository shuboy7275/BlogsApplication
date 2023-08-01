package com.ait.binding;

import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentForm {
	
	private String name;
	private String email;
	
	@Lob
	private String comment;

}
