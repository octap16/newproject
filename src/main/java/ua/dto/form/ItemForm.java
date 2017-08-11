package ua.dto.form;

import org.springframework.web.multipart.MultipartFile;


import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Model;
import ua.entity.Producer;
import ua.entity.Season;

public class ItemForm {
	
		private int id;
		
		private String context;
	
		private String price;
		
		private String size;
		
		private Category category;
			
		private Producer producer;
		
		private Color color;
		
		private Season season;
				
		private Model model;
		
		private Integer version;
		
		private MultipartFile file;
		
		public MultipartFile getFile() {
			return file;
		}

		public void setFile(MultipartFile file) {
			this.file = file;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
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

		public Model getModel() {
			return model;
		}

		public void setModel(Model model) {
			this.model = model;
		}

		public Integer getVersion() {
			return version;
		}

		public void setVersion(Integer version) {
			this.version = version;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getContext() {
			return context;
		}

		public void setContext(String context) {
			this.context = context;
		}
			
}
