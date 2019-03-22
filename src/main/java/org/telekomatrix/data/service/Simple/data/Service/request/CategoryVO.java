package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.List;

public class CategoryVO {
	
	private String categoryName;
	
	private List<DomainVO> domains;
	

	public CategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryVO(String categoryName, List<DomainVO> domains) {
		super();
		this.categoryName = categoryName;
		this.domains = domains;
		
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<DomainVO> getDomains() {
		return domains;
	}

	public void setDomains(List<DomainVO> domains) {
		this.domains = domains;
	}

	
	

}
