package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category", indexes=@Index(columnList = "_name"))
public class Category extends AbstractEntity  {

	@Column(name="_name")
	private String name;
	@OneToMany(mappedBy="category")
	private List<Item> items =new ArrayList<>();
	public Category() {
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
		return "Category [name=" + name + "]";
	}

	
	
}
