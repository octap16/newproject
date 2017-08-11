package ua.dto.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



public class ItemFilter {
	private static final Pattern PEATTERN = Pattern.compile("[0-9]+");

	private String search = "";
	
	private String maxPrice = "";
	
	private String minPrice = "";
	
	private String maxSize = "";
	
	private String minSize = "";
	
	private Integer max;
	
	private Integer min;
	
	private List<Integer> producerIds = new ArrayList<>();
	
	private List<Integer> modelIds = new ArrayList<>();
	
	private List<Integer> seasonIds = new ArrayList<>();
	
	private List<Integer> colorIds = new ArrayList<>();
	
	private List<Integer> categoryIds = new ArrayList<>();
	

	
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(PEATTERN.matcher(maxPrice).matches())max = Integer.valueOf(maxPrice);
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(PEATTERN.matcher(minPrice).matches())min = Integer.valueOf(minPrice);
		this.minPrice = minPrice;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}
	public String getMinSize() {
		return minSize;
	}

	public void setMinSize(String minSize) {
		if(PEATTERN.matcher(minSize).matches())min = Integer.valueOf(minSize);
		this.minSize = minSize;
	}

	public String getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(String maxSize) {
		if(PEATTERN.matcher(maxSize).matches())max = Integer.valueOf(maxSize);
		this.maxSize = maxSize;
	}

	public List<Integer> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Integer> producerIds) {
		this.producerIds = producerIds;
	}

	public List<Integer> getModelIds() {
		return modelIds;
	}

	public void setModelIds(List<Integer> modelIds) {
		this.modelIds = modelIds;
	}

	public List<Integer> getSeasonIds() {
		return seasonIds;
	}

	public void setSeasonIds(List<Integer> seasonIds) {
		this.seasonIds = seasonIds;
	}

	public List<Integer> getColorIds() {
		return colorIds;
	}

	public void setColorIds(List<Integer> colorIds) {
		this.colorIds = colorIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}


	
	
}
