//package ua.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Index;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="content",  indexes=@Index(columnList = "_name"))
//public class Content extends AbstractEntity{
//	
//	@Column(name="_name")
//	private String name;
//	@OneToMany(mappedBy="content")
//	private List<Model> models = new ArrayList<>();
//	public Content() {
//		super();
//	}
//	
//	
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public Content(List<Model> models) {
//		super();
//		this.models = models;
//	}
//
//}
