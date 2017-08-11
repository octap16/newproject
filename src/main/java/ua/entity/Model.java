package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Index;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="model",  indexes=@Index(columnList = "_name"))
public class Model extends AbstractEntity{
	
	@Column(name="_name")
	private String name;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	private Content content;
	
	@OneToMany(mappedBy="model")
	private List<Item> items = new ArrayList<>();
	public Model() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
		
	}

	@Override
	public String toString() {
		return "Model [name=" + name + "]";
	}

//	public Content getContent() {
//		return content;
//	}
//
//	public void setContent(Content content) {
//		this.content = content;
//	}
}
