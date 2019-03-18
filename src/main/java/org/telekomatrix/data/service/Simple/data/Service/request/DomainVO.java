package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class DomainVO {
	
	private Long Id;
	
	private String domainName;
	
	private List<CategoryVO> categories;

	public DomainVO(Long id, String domainName, List<CategoryVO> categories) {
		super();
		Id = id;
		this.domainName = domainName;
		this.categories = categories;
	}

	public DomainVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<CategoryVO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryVO> categories) {
		this.categories = categories;
	}
	
	

}
