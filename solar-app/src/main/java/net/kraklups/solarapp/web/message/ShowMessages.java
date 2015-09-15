package net.kraklups.solarapp.web.message;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class ShowMessages {
	
	private final static int MESSAGES_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowMessages.class);
	
	private int startIndex = 0;
	
	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/message/showMessages", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Messages page !");
		
		initModelListMessageEvents(model);
		
		return "message/showMessages";
	}
	
	private void initModelListMessageEvents(Model model) throws InstanceNotFoundException {
		List <MessageEvent> messageEventList = taskPrkService.getMessageEvents(startIndex, MESSAGES_PER_PAGE).getMessageEvents();
		model.addAttribute("messageEventList",messageEventList);
	}
}
