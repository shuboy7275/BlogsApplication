package com.ait.entityclasses;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "blog_tbl")
public class Blogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blogId;

	private String title;
	private String description;
	
	@Lob
	private String content;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	@UpdateTimestamp
	private LocalDate updatedOn;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private UserDetails userDetails;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "blogDetails")
	private List<Comments> CommentDetails;

}
