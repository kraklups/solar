package net.kraklups.solarapp.web.element;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.dataservice.DataService;
import net.kraklups.solarapp.model.elementprk.ArrayBox;
import net.kraklups.solarapp.model.elementprk.ArrayPanel;
import net.kraklups.solarapp.model.elementprk.Cell;
import net.kraklups.solarapp.model.elementprk.Counter;
import net.kraklups.solarapp.model.elementprk.ElectricalSubstation;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementprk.ElementPrkMock;
import net.kraklups.solarapp.model.elementprk.ExtractionPoint;
import net.kraklups.solarapp.model.elementprk.Gps;
import net.kraklups.solarapp.model.elementprk.Inverter;
import net.kraklups.solarapp.model.elementprk.MediumVoltage;
import net.kraklups.solarapp.model.elementprk.SolarTracker;
import net.kraklups.solarapp.model.elementprk.StringLine;
import net.kraklups.solarapp.model.elementprk.WeatherStation;
import net.kraklups.solarapp.model.elementservice.ElementService;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Element page.
 */
@Controller
public class CreateElement {
	
	private final static int PARK_PER_PAGE = 50;
	
	private final static int STRINGLINE_PER_PAGE = 50;
	
	private final static int DATALOGGER_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(CreateElement.class);
	
	private int startIndex = 0;	

	@Autowired
	private ElementService elementService;	
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private ParkService parkService;
	
	@Autowired
	private DataService dataService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/element/createElement", method = RequestMethod.GET)
	public String createElementGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Element page !");
		
		ElementPrkMock elementPrkMock = new ElementPrkMock();
		
		model.addAttribute("elementPrkMock", elementPrkMock);
		
		initModelListPark(model);
		
		initModelListDataLogger(model);
		
		initModelListStringLine(model);
		
		initModelListArrayBox(model);
		
		initModelListArrayPanel(model);
		
		initModelListCounter(model);
		
		initModelListElectricalSubstation(model);
		
		initModelListExtractionPoint(model);
		
		initModelListMediumVoltage(model);
		
		return "element/createElement";
	}

	@RequestMapping(value = "/element/createElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("elementPrk") ElementPrk elementPrk, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create ElementPrk page! " + "elementPrk: " + elementPrk.getElementPrkId());

			model.addAttribute("elementPrk", elementPrk);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			elementPrk.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			ElementPrk merda = elementService.saveElementPrk(elementPrk);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createArrayPanelElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("arrayPanel") ArrayPanel arrayPanel, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create ArrayPanel page! " + "arrayPanel: " + arrayPanel.getArrayPanelId());

			model.addAttribute("arrayPanel", arrayPanel);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			arrayPanel.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			ArrayPanel merda = elementService.saveElementPrk(arrayPanel);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}
	
	@RequestMapping(value = "/element/createArrayBoxElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("arrayBox") ArrayBox arrayBox, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create ArrayBox page! " + "arrayBox: " + arrayBox.getArrayBoxId());

			model.addAttribute("arrayBox", arrayBox);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			arrayBox.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			ArrayBox merda = elementService.saveElementPrk(arrayBox);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}		
	
	@RequestMapping(value = "/element/createCellElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("cell") Cell cell, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create Cell page! " + "cell: " + cell.getCellId());

			model.addAttribute("cell", cell);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			cell.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Cell merda = elementService.saveElementPrk(cell);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createCounterElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("counter") Counter counter, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create Counter page! " + "counter: " + counter.getCounterId());

			model.addAttribute("counter", counter);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			counter.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Counter merda = elementService.saveElementPrk(counter);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createElectricalSubstationElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("electricalSubstation") ElectricalSubstation electricalSubstation, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create ElectricalSubstation page! " + "electricalSubstation: " + electricalSubstation.getElectricalSubstationId());

			model.addAttribute("electricalSubstation", electricalSubstation);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			electricalSubstation.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			ElectricalSubstation merda = elementService.saveElementPrk(electricalSubstation);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createExtractionPointElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("extractionPoint") ExtractionPoint extractionPoint, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create ExtractionPoint page! " + "extractionPoint: " + extractionPoint.getExtractionPointId());

			model.addAttribute("extractionPoint", extractionPoint);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			extractionPoint.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			ExtractionPoint merda = elementService.saveElementPrk(extractionPoint);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createGpsElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("gps") Gps gps, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create Gps page! " + "gps: " + gps.getGpsId());

			model.addAttribute("gps", gps);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			gps.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Gps merda = elementService.saveElementPrk(gps);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createInverterElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("inverter") Inverter inverter, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create Inverter page! " + "inverter: " + inverter.getInverterId());

			model.addAttribute("inverter", inverter);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			inverter.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Inverter merda = elementService.saveElementPrk(inverter);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createMediumVoltageElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("mediumVoltage") MediumVoltage mediumVoltage, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create MediumVoltage page! " + "mediumVoltage: " + mediumVoltage.getMediumVoltageId());

			model.addAttribute("mediumVoltage", mediumVoltage);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			mediumVoltage.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			MediumVoltage merda = elementService.saveElementPrk(mediumVoltage);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	

	@RequestMapping(value = "/element/createSolarTrackerElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("solarTracker") SolarTracker solarTracker, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create SolarTracker page! " + "solarTracker: " + solarTracker.getSolarTrackerId());

			model.addAttribute("solarTracker", solarTracker);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			solarTracker.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			SolarTracker merda = elementService.saveElementPrk(solarTracker);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	

	@RequestMapping(value = "/element/createStringLineElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("stringLine") StringLine stringLine, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create StringLine page! " + "stringLine: " + stringLine.getStringLineId());

			model.addAttribute("stringLine", stringLine);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			stringLine.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			StringLine merda = elementService.saveElementPrk(stringLine);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	@RequestMapping(value = "/element/createWeatherStationElement", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("weatherStation") WeatherStation weatherStation, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "element/createElement";
		} else {
			logger.info("Create WeatherStation page! " + "weatherStation: " + weatherStation.getWeatherStationId());

			model.addAttribute("weatherStation", weatherStation);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			weatherStation.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			WeatherStation merda = elementService.saveElementPrk(weatherStation);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	private void initModelListPark(Model model) throws InstanceNotFoundException {
		List <Park> parkList = parkService.getParks(startIndex, PARK_PER_PAGE).getParks();
		model.addAttribute("parkList",parkList);
	}	
	
	private void initModelListDataLogger(Model model) throws InstanceNotFoundException {
		List <DataLogger> dataLoggerList = dataService.getDataLoggers(startIndex, DATALOGGER_PER_PAGE).getDataLoggers();
		model.addAttribute(dataLoggerList);
	}	
	
	private void initModelListStringLine(Model model) throws InstanceNotFoundException {
		List <StringLine> stringLineList = elementService.getStringLines(startIndex, STRINGLINE_PER_PAGE).getStringLines();
		model.addAttribute(stringLineList);
	}
	
	private void initModelListArrayPanel(Model model) throws InstanceNotFoundException {
		List <ArrayPanel> arrayPanelList = elementService.getArrayPanels(startIndex, STRINGLINE_PER_PAGE).getArrayPanels();
		model.addAttribute(arrayPanelList);
	}
	
	private void initModelListMediumVoltage(Model model) throws InstanceNotFoundException {
		List <MediumVoltage> mediumVoltageList = elementService.getMediumVoltages(startIndex, STRINGLINE_PER_PAGE).getMediumVoltages();
		model.addAttribute(mediumVoltageList);
	}	
	
	private void initModelListCounter(Model model) throws InstanceNotFoundException {
		List <Counter> counterList = elementService.getCounters(startIndex, STRINGLINE_PER_PAGE).getCounters();
		model.addAttribute(counterList);
	}	
	
	private void initModelListArrayBox(Model model) throws InstanceNotFoundException {
		List <ArrayBox> arrayBoxList = elementService.getArrayBoxs(startIndex, STRINGLINE_PER_PAGE).getArrayBoxs();
		model.addAttribute(arrayBoxList);
	}
	
	private void initModelListElectricalSubstation(Model model) throws InstanceNotFoundException {
		List <ElectricalSubstation> electricalSubstationList = elementService.getElectricalSubstations(startIndex, STRINGLINE_PER_PAGE).getElectricalSubstations();
		model.addAttribute(electricalSubstationList);
	}	
	
	private void initModelListExtractionPoint(Model model) throws InstanceNotFoundException {
		List <ExtractionPoint> extractionPointList = elementService.getExtractionPoints(startIndex, STRINGLINE_PER_PAGE).getExtractionPoints();
		model.addAttribute(extractionPointList);
	}	
	
	
}
