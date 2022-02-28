package com.somosbooking.somosBack.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somosbooking.somosBack.model.article;
import com.somosbooking.somosBack.model.articleType;
import com.somosbooking.somosBack.model.articleSize;

@Service
public class articleService {
	
	private final articleRepository artRepo;
	
	@Autowired
	public articleService(articleRepository artRepo) {
		this.artRepo = artRepo;
	}
	
	public List<article> getArticles() {
		return artRepo.findAll();
	}

	public void updateArticle(int idArticle, String nameArticle, String descriptionArticle, String photoArticle,
			double price, int stock, articleSize size, int idColor, articleType item) {
		if(artRepo.existsById(idArticle)) {
			article a = artRepo.getById(idArticle);
			if(nameArticle!=null)a.setNamearticle(nameArticle);
			if(descriptionArticle!=null)a.setDescriptionarticle(descriptionArticle);
			if(photoArticle!=null)a.setPhotoarticle(photoArticle);
			if(price!=0)a.setPrice(price);
			if(stock!=0)a.setStock(stock);
			if(size!=null)a.setSize(size);
			if(idColor!=0)a.setIdcolor(idColor);
			if(item!=null)a.setItem(item);
			artRepo.save(a);
		}else {
			System.out.println("No existe el id "+idArticle);
		}
	}

	public void addArticle(article art) {
		Optional<article> artByName = artRepo.findByName(art.getNamearticle());
		if(artByName.isPresent()) {
			throw new IllegalStateException("El producto con el nombre "+art.getNamearticle()+" ya existe.");
		}else {
			artRepo.save(art);
		}
		
	}

	public void deleteArticle(int idArticle) {
		if(artRepo.existsById(idArticle)) { 
			artRepo.deleteById(idArticle);
		}
	}

	public article getArticle(int idArticle) {
		return artRepo.findById(idArticle).
				orElseThrow(() -> new IllegalStateException("El producto con el Id "+idArticle+" no existe."));
	}

}
