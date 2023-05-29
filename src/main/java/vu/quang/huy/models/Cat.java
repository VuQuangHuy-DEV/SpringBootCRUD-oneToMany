package vu.quang.huy.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cat_Id;
	
	private String cat_Name;
	private Boolean cat_Gender;
	private Date cat_Birthday;
	private String cat_Description;
	private String cat_Image;
	@ManyToOne
	@JoinColumn(name = "bread_Id")
	private Bread bread;
	public int getCat_Id() {
		return cat_Id;
	}
	public void setCat_Id(int cat_Id) {
		this.cat_Id = cat_Id;
	}
	public String getCat_Name() {
		return cat_Name;
	}
	public void setCat_Name(String cat_Name) {
		this.cat_Name = cat_Name;
	}
	public Boolean getCat_Gender() {
		return cat_Gender;
	}
	public void setCat_Gender(Boolean cat_Gender) {
		this.cat_Gender = cat_Gender;
	}
	public Date getCat_Birthday() {
		return cat_Birthday;
	}
	public void setCat_Birthday(Date cat_Birthday) {
		this.cat_Birthday = cat_Birthday;
	}
	public String getCat_Description() {
		return cat_Description;
	}
	public void setCat_Description(String cat_Description) {
		this.cat_Description = cat_Description;
	}
	public String getCat_Image() {
		return cat_Image;
	}
	public void setCat_Image(String cat_Image) {
		this.cat_Image = cat_Image;
	}
	public Bread getBread() {
		return bread;
	}
	public void setBread(Bread bread) {
		this.bread = bread;
	}


}
