package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="country",  indexes=@Index(columnList = "_name"))
public class Country extends AbstractEntity{
	
	@Column(name="_name")
	private String name;
	@OneToMany(mappedBy="country")
	private List<Producer> producers = new ArrayList<>();
	
	public Country() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country(List<Producer> producers) {
		super();
		this.producers = producers;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + "]";
	}
	
	
}
