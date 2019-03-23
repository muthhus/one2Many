package org.telekomatrix.data.service.Simple.data.Service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telekomatrix.data.service.Simple.data.Service.domain.Category;
import org.telekomatrix.data.service.Simple.data.Service.domain.Domain;
import org.telekomatrix.data.service.Simple.data.Service.repository.CategoryRepository;
import org.telekomatrix.data.service.Simple.data.Service.repository.DomainRepository;
import org.telekomatrix.data.service.Simple.data.Service.request.CategoryVO;
import org.telekomatrix.data.service.Simple.data.Service.request.DomainVO;

@RestController
@RequestMapping("v1/categories")
public class CategoryRestController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private DomainRepository domainRepository;
	
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody CategoryVO categoryVO){
		Category category = new Category(null);
		category.setCategoryName(categoryVO.getCategoryName());

		for(DomainVO domainVO : categoryVO.getDomains()) {
			Domain domain = new Domain();
			domain.setDomainName(domainVO.getDomainName());
			domainRepository.save(domain);
//			category.getDomains().add(domain);
			
		}
		
		categoryRepository.save(category);
		
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Category> getCategory() {
		return categoryRepository.findAll();
	}
}
