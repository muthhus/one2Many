package org.telekomatrix.data.service.Simple.data.Service.it;

import org.springframework.beans.factory.annotation.Autowired;
import org.telekomatrix.data.service.Simple.data.Service.rest.DomainRestController;

public abstract class AbstractDomainControllerTests {
	
	protected static final String DOMAIN = "1";
	
	protected static final String DOMAIN_NAME = "YAHOO.COM";
	
	@Autowired
	private DomainRestController domainRestController;
	
//	/**
//	   * Test method for findById method
//	   */
//	  @Test
//	  public void validDomainById() throws Exception {
//	    Logger.getGlobal().info("Start validDomainById test");
//	    ResponseEntity<Entity> domain = 
//	         domainController.findById(DOMAIN);
//
//	    Assert.assertEquals(HttpStatus.OK, domain.getStatusCode());
//	    Assert.assertTrue(domain.hasBody());
//	    Assert.assertNotNull(domain.getBody());
//	    Assert.assertEquals(DOMAIN, domain.getBody().getId());
//	    Assert.assertEquals(DOMAIN_NAME, 
//	                        domain.getBody().getName());
//	    Logger.getGlobal().info("End validDomainById test");
//	  }
//
//	  /**
//	   * Test method for findByName method
//	   */
//	  @Test
//	  public void validDomainByName() throws Exception {
//	    Logger.getGlobal().info("Start validDomainByName test");
//	    ResponseEntity<Collection<Domain>> domains = 
//	                                       domainController
//	        .findByName(DOMAIN_NAME);
//	    Logger.getGlobal().info("In validAccount test");
//
//	    Assert.assertEquals(HttpStatus.OK, domains.getStatusCode());
//	    Assert.assertTrue(domains.hasBody());
//	    Assert.assertNotNull(domains.getBody());
//	    Assert.assertFalse(domains.getBody().isEmpty());
//	    Domain domain = 
//	         (domain) domains.getBody().toArray()[0];
//	    Assert.assertEquals(DOMAIN, domain.getId());
//	    Assert.assertEquals(DOMAIN_NAME, domain.getName());
//	    Logger.getGlobal().info("End validDomainByName test");
//	  }
//
//	  /**
//	   * Test method for add method
//	   */
//	  @Test
//	  public void validAdd() throws Exception {
//	    Logger.getGlobal().info("Start validAdd test");
//	    DomainVO domain = new DomainVO();
//	    domain.setId("999");
//	    domain.setName("Test Domain");
//
//	    ResponseEntity<Domain> domains = 
//	        domainController.add(domain);
//	    Assert.assertEquals(HttpStatus.CREATED, 
//	        domains.getStatusCode());
//	    Logger.getGlobal().info("End validAdd test");
//	  }

}
