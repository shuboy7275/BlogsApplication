package com.ait.binding;

import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostForm {
	
	private Integer blogId;
	private String title;
	private String description;
	
	@Lob
	private String content;

}
