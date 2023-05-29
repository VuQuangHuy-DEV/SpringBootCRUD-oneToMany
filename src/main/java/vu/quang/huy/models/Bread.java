package vu.quang.huy.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Bread {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bread_Id;
	@Column(columnDefinition = "nvarchar(100)")
	private String bread_Name;
	@OneToMany(mappedBy = "bread",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Cat> cats;
	public int getBread_Id() {
		return bread_Id;
	}
	public void setBread_Id(int bread_Id) {
		this.bread_Id = bread_Id;
	}
	public String getBread_Name() {
		return bread_Name;
	}
	public void setBread_Name(String bread_Name) {
		this.bread_Name = bread_Name;
	}
	public List<Cat> getCats() {
		return cats;
	}
	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}
	
	
	
	

}
