package com.pablosaraiva.web.blog;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends CrudRepository<BlogPost, String> {
    Optional<BlogPost> findById(String id);

    @Query("select * from blog_post order by date_time desc")
    List<BlogPost> findAllByDateDesc();

    @Query("select * from blog_post where published = true order by date_time desc")
    List<BlogPost> findAllPublishedByDateDesc();

}
