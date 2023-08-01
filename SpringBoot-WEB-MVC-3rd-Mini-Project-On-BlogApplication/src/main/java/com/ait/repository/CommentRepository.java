package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entityclasses.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
