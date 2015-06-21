package net.kraklups.solarapp.web.message;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class UpdateMessage {
	
	private final static int EVENTTSK_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(UpdateMessage.class);
	
	private int startIndex = 0;	
	
	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/message/updateMessage/{messageEventId}", method = RequestMethod.GET)
	public String updateMessageEventGet(@PathVariable String messageEventId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create MessageEvent page GET!");
		
		MessageEvent messageEvent = taskPrkService.findMessageEvent(Long.valueOf(messageEventId));
		
		model.addAttribute("messageEvent", messageEvent);
		initModelListEventTsk(model);
				
		return "message/updateMessage";
	}
	
	@RequestMapping(value = "/message/updateMessage/{messageEventId}", method = RequestMethod.POST)
	public String updateMessageEventPost(@Valid @ModelAttribute("messageEvent") MessageEvent messageEvent, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateMessageEvent.jspx page");
			
			return "message/updateMessage";
		} else {
			logger.info("UpdateMessageEvent done");
			
			model.addAttribute("messageEvent", messageEvent);
			
			MessageEvent merda = taskPrkService.saveMessageEvent(messageEvent);
			
			logger.info("Update MessageEvent page POST!" + merda);
			
			return "redirect:/message/showMessages";
		}
	}
	
	private void initModelListEventTsk(Model model) throws InstanceNotFoundException {
		List <EventTsk> eventTskList = taskPrkService.getEventTsks(startIndex, EVENTTSK_PER_PAGE).getEventTsks();
		model.addAttribute(eventTskList);
	}	

}
