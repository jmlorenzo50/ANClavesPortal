package es.mocking.ClavesPortal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.mocking.ClavesPortal.service.KeyService;
import es.mocking.ClavesPortal.type.TypeError;


/**
 * The Class DeviceController.
 * @version 1.0
 * @author jorge
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/keys")
public class KeysController {
	
	/** The log. */
	private static Log LOG = LogFactory.getLog(KeysController.class);

	
	/** The device service. */
	@Autowired
	@Qualifier("keyService")
	private KeyService keyService;

	
	/**
	 * Get the token of portal
	 * @param user
	 * @param key
	 * @return
	 */
	@GetMapping("/get/{user}/{key}")
	public String get(@PathVariable(name="user",required=true) String user,
					  @PathVariable(name="key",required=true) String key
			) {
		LOG.info("METHOD: get");
		String salida = null;
		salida = keyService.get(user, key);
		if (salida == null) {
			salida = TypeError.ERR404.name();
		}
		return salida;
	}
	

	
	
	
}
