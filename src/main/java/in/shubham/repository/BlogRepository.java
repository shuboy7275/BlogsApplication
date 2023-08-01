package in.shubham.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shubham.entityclasses.Blogs;

public interface BlogRepository extends JpaRepository<Blogs, Integer>{

}
