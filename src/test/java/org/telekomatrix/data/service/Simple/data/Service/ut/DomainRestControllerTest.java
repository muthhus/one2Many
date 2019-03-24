package org.telekomatrix.data.service.Simple.data.Service.ut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.telekomatrix.data.service.Simple.data.Service.domain.Domain;
import org.telekomatrix.data.service.Simple.data.Service.it.AbstractDomainControllerTests;

public class DomainRestControllerTest extends AbstractDomainControllerTests {

	/**
	   * Test Domain Instance
	   */
	  protected static final Domain domainStaticInstance = new Domain();
	  /**
	   * Initialized Domain Repository
	   */
	  protected TestDomainRepository testDomainRepository = new TestDomainRepository();
	  /**
	   * Initialized Domain Service
	   */
	  protected DomainService restaurantService = new DomainServiceImpl(
			  testDomainRepository);

	  /**
	   * Setup method
	   */
	  @Before
	  public void setup() {
	    domainController = new DomainController(domainService);
	  }

	  /**
	   * Test Repository
	   */
	  protected static class TestDomainRepository implements
	      DomainRepository<Domain, String> {

	    private Map<String, Domain> entities;

	    /**
	     * Constructor
	     */
	    public TestDomainRepository() {
	      entities = new HashMap();
	      Domain domain = new Domain(DOMAIN_NAME);
	      entities.put("1", domain);
	      domain = new Domain("O Domain", "2", "Address of O Domain", null);
	      entities.put("2", domain);
	    }

	    /**
	     * @param name
	     */
	    @Override
	    public boolean containsName(String name) {
	      try {
	        return this.findByName(name).size() > 0;
	      } catch (Exception ex) {
	        //Exception Handler
	      }
	      return false;
	    }

	    /**
	     * @param entity
	     */
	    @Override
	    public void add(Domain entity) {
	      entities.put(entity.getId(), entity);
	    }

	    /**
	     * @param id
	     */
	    @Override
	    public void remove(String id) {
	      if (entities.containsKey(id)) {
	        entities.remove(id);
	      }
	    }

	    /**
	     * @param entity
	     */
	    @Override
	    public void update(Domain entity) {
	      if (entities.containsKey(entity.getId())) {
	        entities.put(entity.getId(), entity);
	      }
	    }

	    /**
	     * @param name
	     */
	    @Override
	    public Collection<Domain> findByName(String name) throws Exception {
	      Collection<Domain> domains = new ArrayList();
	      int noOfChars = name.length();
	      entities.forEach((k, v) -> {
	        if (v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
	          domains.add(v);
	        }
	      });
	      return domains;
	    }

	    /**
	     * @param id
	     */
	    @Override
	    public boolean contains(String id) {
	      throw new UnsupportedOperationException(
	          "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    /**
	     * @param id
	     */
	    @Override
	    public Domain get(String id) {
	      return entities.get(id);
	    }

	    /**
	     *
	     * @return
	     */
	    @Override
	    public Collection<Domain> getAll() {
	      return entities.values();
	    }
	  }
}
