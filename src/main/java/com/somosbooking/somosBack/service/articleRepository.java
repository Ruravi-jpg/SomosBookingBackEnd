package com.somosbooking.somosBack.service;

import java.util.Optional;
import java.lang.Integer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.somosbooking.somosBack.model.article;

public interface articleRepository extends JpaRepository<article, Integer>{
	@Query("SELECT a FROM article a WHERE a.namearticle=?1")
	Optional<article> findByName(String NameArticle);
}