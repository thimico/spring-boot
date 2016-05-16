package br.com.w6.sb.utils;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AbstractService <T extends AbstractEntity<ID>, ID extends Serializable> implements ServiceMap {
	private final Logger LOGGER = Logger.getLogger(this.getClass());

	@Autowired
	protected JpaRepository<T, ID> genericRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> findAll() {
		this.LOGGER.debug("Requesting all records.");

		return this.genericRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public T insert(@RequestBody T entityObject) {
		this.LOGGER.debug(String.format("Saving the entity [%s].", entityObject));

		entityObject.setId(null);

		return this.genericRepository.save(entityObject);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody T entityObject) {
		this.LOGGER.debug(String.format("Request to update the record [%s].", entityObject));

		if (entityObject == null) {
			this.LOGGER.error("Entity can not be null.");
			return;
		}

		if (entityObject.getId() == null) {
			this.LOGGER.error("ID can not be null.");
			return;
		}

		this.genericRepository.save(entityObject);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody T entityObject) {
		this.LOGGER.debug(String.format("Request to delete the record [%s].", entityObject));

		this.genericRepository.delete(entityObject);
	}

}
