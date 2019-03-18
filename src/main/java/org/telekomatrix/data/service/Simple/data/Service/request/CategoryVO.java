package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.HashSet;
import java.util.Set;


public class CategoryVO {
	
	private String categoryName;
	
	private Set<DomainVO> domains = new HashSet<>();

	public CategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryVO(String categoryName, Set<DomainVO> domains) {
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

	public Set<DomainVO> getDomains() {
		return domains;
	}

	public void setDomains(Set<DomainVO> domains) {
		this.domains = domains;
	}
	
	

}
