package ua.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="item",  indexes={@Index(columnList = "size" ),@Index(columnList = "price" ),@Index(columnList = "_context" )})
public class Item  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="_context", length = 800000)
	private String context;
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	@ManyToOne(fetch=FetchType.LAZY)
	private Producer producer;
	@ManyToOne(fetch=FetchType.LAZY)
	private Color color;
	@ManyToOne(fetch=FetchType.LAZY)
	private Season season;
	private int size;
	private BigDecimal price ;
	@ManyToOne(fetch=FetchType.LAZY)
	private Model model;
	@Column(name = "version", nullable = true)
	private Integer version;

		
	public Item() {
		super();
	}
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;	
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [category=" + category + ", producer=" + producer
				+ ", color=" + color + ", season=" + season + ", size=" + size
				+ ", price=" + price + ", model=" + model + "]";
	}
}
