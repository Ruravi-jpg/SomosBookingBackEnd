package com.somosbooking.somosBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class article {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="idarticle", unique = true, nullable = false)
		private int idarticle;
		private String namearticle;
		private String descriptionarticle;
		private String photoarticle;
		private double price;
		private int stock;
		@Column(name="size",  columnDefinition  = "ENUM('Chica','Mediana','Grande')'")
		@Enumerated(EnumType.STRING)
		private articleSize size;
		private int idcolor;
		@Column(name="item",  columnDefinition  = "ENUM('clothe','music', 'hat')'")
		@Enumerated(EnumType.STRING)
		private articleType item;
		public article(int idarticle, String namearticle, String descriptionarticle, String photoarticle, double price,
				int stock, articleSize size, int idcolor, articleType item) {
			super();
			this.idarticle = idarticle;
			this.namearticle = namearticle;
			this.descriptionarticle = descriptionarticle;
			this.photoarticle = photoarticle;
			this.price = price;
			this.stock = stock;
			this.size = size;
			this.idcolor = idcolor;
			this.item = item;
		}
		public article() {
			super();
		}
		public int getIdarticle() {
			return idarticle;
		}
		public void setIdarticle(int idarticle) {
			this.idarticle = idarticle;
		}
		public String getNamearticle() {
			return namearticle;
		}
		public void setNamearticle(String namearticle) {
			this.namearticle = namearticle;
		}
		public String getDescriptionarticle() {
			return descriptionarticle;
		}
		public void setDescriptionarticle(String descriptionarticle) {
			this.descriptionarticle = descriptionarticle;
		}
		public String getPhotoarticle() {
			return photoarticle;
		}
		public void setPhotoarticle(String photoarticle) {
			this.photoarticle = photoarticle;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public articleSize getSize() {
			return size;
		}
		public void setSize(articleSize size) {
			this.size = size;
		}
		public int getIdcolor() {
			return idcolor;
		}
		public void setIdcolor(int idcolor) {
			this.idcolor = idcolor;
		}
		public articleType getItem() {
			return item;
		}
		public void setItem(articleType item) {
			this.item = item;
		}
		@Override
		public String toString() {
			return "article [idarticle=" + idarticle + ", namearticle=" + namearticle + ", descriptionarticle="
					+ descriptionarticle + ", photoarticle=" + photoarticle + ", price=" + price + ", stock=" + stock
					+ ", size=" + size + ", idcolor=" + idcolor + ", item=" + item + "]";
		}		
}
