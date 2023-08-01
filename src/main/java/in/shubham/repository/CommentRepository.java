package in.shubham.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shubham.entityclasses.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
