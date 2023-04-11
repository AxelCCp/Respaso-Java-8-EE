package jee.master.model;

public class Products {

	public Products() {
		this.sku = "";
		this.section = "";
		this.name = "";
		this.price = "";
		this.date = "";
		this.imported = "";
		this.origin = "";
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImported() {
		return imported;
	}
	public void setImported(String imported) {
		this.imported = imported;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	private String sku;
	private String section;
	private String name;
	private String price;
	private String date;
	private String imported;
	private String origin;	
}
