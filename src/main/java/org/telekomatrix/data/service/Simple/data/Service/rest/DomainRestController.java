package org.telekomatrix.data.service.Simple.data.Service.rest;

import java.util.Date;
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
import org.telekomatrix.data.service.Simple.data.Service.domain.DomainCategory;
import org.telekomatrix.data.service.Simple.data.Service.repository.CategoryRepository;
import org.telekomatrix.data.service.Simple.data.Service.repository.DomainRepository;
import org.telekomatrix.data.service.Simple.data.Service.request.CategoryVO;
import org.telekomatrix.data.service.Simple.data.Service.request.DomainVO;


@RestController
@RequestMapping("/v1/domains")
public class DomainRestController {
	
	@Autowired
	private DomainRepository domainRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping
	public ResponseEntity<Domain> createDomain(@RequestBody DomainVO domainVO){
		Domain domain = domainRepository.findByDomainName(domainVO.getDomainName());
		
		if(domain == null) {
			domain = new Domain();
		}
		
		domain.setDomainName(domainVO.getDomainName());

		if(domainVO.getCategories().size() >0) {

			for(CategoryVO categoryVo : domainVO.getCategories()) {
				
				Category category = categoryRepository.findByCategoryName(categoryVo.getCategoryName());
				
				if(category == null) {
					 category = new Category();
				}
				
				
				category.setCategoryName(categoryVo.getCategoryName());
				
				categoryRepository.save(category);
//				domain.addCategory(category);
				
				DomainCategory domainCategory = new DomainCategory();
				domainCategory.setDomain(domain);
				domainCategory.setCategory(category);
				domainCategory.setCreatedDate(new Date());
				domainCategory.setCreatedBy("System");
				
				domain.getDomainCategories().add(domainCategory);
				domainRepository.save(domain);
			}
			
			
			
		}
		
		
		return new ResponseEntity<>(domain, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Domain>> getDomains() {
		List<Domain> domain = domainRepository.findAll();
		
		return new ResponseEntity<>(domain, HttpStatus.OK);
	}
}
