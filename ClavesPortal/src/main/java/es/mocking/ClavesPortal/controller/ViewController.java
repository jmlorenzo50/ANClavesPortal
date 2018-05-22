package es.mocking.ClavesPortal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.mocking.ClavesPortal.constants.ViewConstant;
import es.mocking.ClavesPortal.service.KeyService;

@Controller
@RequestMapping("/portal")
public class ViewController {
	
	/** The log. */
	private static Log LOG = LogFactory.getLog(ViewController.class);

	
	/** The device service. */
	@Autowired
	@Qualifier("keyService")
	private KeyService keyService;
	
	
	/**
	 * List contacts.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/view/{portal}")
	public ModelAndView view(@PathVariable(name="portal",required=true) String portal) {
		LOG.info("METHOD: view");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(ViewConstant.ERROR);
		String salida = null;
		salida = keyService.search(portal);
		if (salida != null) {
			modelAndView.setViewName(ViewConstant.MEMORIAL);
		}
		
		return modelAndView;
	}


}
