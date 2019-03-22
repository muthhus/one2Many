package org.telekomatrix.data.service.Simple.data.Service.rest;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
import org.telekomatrix.data.service.Simple.data.Service.repository.DomainRepository;
import org.telekomatrix.data.service.Simple.data.Service.request.CategoryVO;
import org.telekomatrix.data.service.Simple.data.Service.request.DomainVO;


@RestController
@RequestMapping("/v1/domains")
public class DomainRestController {
	
	@Autowired
	private DomainRepository domainRepository;
	
	@PostMapping
	public ResponseEntity<Domain> createDomain(@RequestBody DomainVO domainVO){
		Domain domain = new Domain();
		domain.setDomainName(domainVO.getDomainName());

//		BeanUtils.copyProperties(domainVO, domain);
		if(domainVO.getCategories().size() >0) {
			System.out.println("-----------------------------");
			System.out.println(domainVO.getCategories());
			System.out.println("-----------------------------");
			for(CategoryVO categoryVo : domainVO.getCategories()) {
				Category category = new Category();
				category.setCategoryName(categoryVo.getCategoryName());
				
				domain.addCategory(category);
				
			}
		}
		
		domainRepository.saveAndFlush(domain);
		return new ResponseEntity<>(domain, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Domain> getDomains() {
		return domainRepository.findAll();
	}
}
