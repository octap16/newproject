package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="color",  indexes=@Index(columnList = "_name"))
public class Color extends AbstractEntity {

	@Column(name="_name")
	private String name;
	@OneToMany(mappedBy="color")
	private List<Item> items =new ArrayList<>();
	public Color() {
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
		return "Color [name=" + name + "]";
	}
	
	}
