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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Message page.
 */
@Controller
public class CreateMessage {
	
	private final static int EVENTTSK_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(CreateMessage.class);
	
	private int startIndex = 0;
	
	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/message/createMessage", method = RequestMethod.GET)
	public String createMessageGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Message page GET!");
		
		MessageEvent messageEvent = new MessageEvent();
		
		model.addAttribute("messageEvent", messageEvent);
		initModelListEventTsk(model);
				
		return "message/createMessage";
	}
	
	@RequestMapping(value = "/message/createMessage", method = RequestMethod.POST)
	public String createMessagePost(@Valid @ModelAttribute("messageEvent") MessageEvent messageEvent, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning after error createMessage.jspx page");
			
			initModelListEventTsk(model);
			
			return "message/createMessage";
		} else {
			logger.info("Create MessageEvent page !" + "messageEvent: " + messageEvent);

			model.addAttribute("messageEvent", messageEvent);
			
			MessageEvent merda = taskPrkService.saveMessageEvent(messageEvent);
			
			logger.info("Create MessageEvent page POST! " + merda);			
			
			return "redirect:/message/showMessages";
		}
	}	

	private void initModelListEventTsk(Model model) throws InstanceNotFoundException {
		List <EventTsk> eventTskList = taskPrkService.getEventTsks(startIndex, EVENTTSK_PER_PAGE).getEventTsks();
		model.addAttribute("eventTskList", eventTskList);
	}	
	
}
