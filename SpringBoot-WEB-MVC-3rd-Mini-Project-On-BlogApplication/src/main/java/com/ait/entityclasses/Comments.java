package com.ait.entityclasses;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "comment_tbl")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	
	private String name;
	private String email;
	
	@Lob
	private String comment;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "blogId")
	private Blogs blogDetails;

	
	
	

}
