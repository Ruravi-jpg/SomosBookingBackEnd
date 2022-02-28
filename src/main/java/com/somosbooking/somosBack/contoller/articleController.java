package com.somosbooking.somosBack.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.somosbooking.somosBack.model.article;
import com.somosbooking.somosBack.model.articleSize;
import com.somosbooking.somosBack.model.articleType;
import com.somosbooking.somosBack.service.articleService;

@RestController
@RequestMapping(path = "/api/article/")
@CrossOrigin(origins="http://127.0.0.1:5500/")
public class articleController {
	private final articleService artServ;
	@Autowired
	public articleController(articleService artServ) {
		this.artServ = artServ;
	}
	@GetMapping
	public List<article> getArticles(){
		return artServ.getArticles();
	}// getProductos
	
	@GetMapping(path="{IdArticle}")
	public article getArticle(@PathVariable("IdArticle") int IdArticle){
		return artServ.getArticle(IdArticle);
	}// getProducto
	
	@DeleteMapping(path="{IdArticle}")
	public void deleteArticle(@PathVariable("IdArticle") int IdArticle) {
		artServ.deleteArticle(IdArticle);
	}//deleteProducto
	
	@PostMapping
	public void addProducto(@RequestBody article art) {
		artServ.addArticle(art);
	}//addProducto

	@PutMapping(path="{IdArticle}")
    public void updateProducto(@PathVariable("IdArticle") int IdArticle,
    		@RequestParam(required=false) String NameArticle, 
    		@RequestParam(required=false) String DescriptionArticle,
    		@RequestParam(required=false) String PhotoArticle,
    		@RequestParam(required=false) double Price,
    		@RequestParam(required=false) int Stock,
    		@RequestParam(required=false) articleSize Size,
    		@RequestParam(required=false) int IdColor,
    		@RequestParam(required=false) articleType Item) {
		artServ.updateArticle (IdArticle, NameArticle, DescriptionArticle,
				PhotoArticle, Price, Stock, Size, IdColor, Item);
	}// updateProducto

}
