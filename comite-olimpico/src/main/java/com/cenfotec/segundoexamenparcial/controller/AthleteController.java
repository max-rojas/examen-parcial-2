package com.cenfotec.segundoexamenparcial.controller;

import com.cenfotec.segundoexamenparcial.domain.Athlete;
import com.cenfotec.segundoexamenparcial.domain.AthleteDetails;
import com.cenfotec.segundoexamenparcial.services.AthleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AthleteController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AthleteService athleteService;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/insertAthlete",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Athlete());
        return "insertAthlete";
    }

    @RequestMapping(value = "/insert-details",  method = RequestMethod.GET)
    public String insertAthleteDetails(
            @RequestParam(value = "athleteId", required = true) Long id,
            Model model) {
        model.addAttribute("athleteId", id);
        model.addAttribute(new AthleteDetails());
        return "insertAthleteDetails";
    }

    @RequestMapping(value = "/insertAthlete",  method = RequestMethod.POST)
    public String insertAthlete(Athlete athlete, BindingResult result, Model model) {
        athleteService.save(athlete);
        return "index";
    }

    @RequestMapping(value = "/insert-details",  method = RequestMethod.POST)
    public String insertAthleteDetails(
            @RequestParam(value = "athleteId", required = true) Long athleteId,
            AthleteDetails athleteDetails, BindingResult result, Model model) {
        athleteService.saveAthleteDetails(athleteDetails, athleteId);
        return "index";
    }

    @RequestMapping(value = "/view-details",  method = RequestMethod.GET)
    public String viewAthleteDetails(
            @RequestParam(value = "athleteId", required = true) Long athleteId,
            Model model) {
        AthleteDetails athleteDetails = athleteService.getAthleteDetails(athleteId);
        model.addAttribute("athlete", athleteService.getAthleteById(athleteId));
        model.addAttribute("athleteDetails", athleteDetails);
        model.addAttribute("bmiHistory", athleteService.findAllBmiByAthleteDetails_Id(athleteDetails.getId()));
        return "viewAthleteDetails";
    }

    @RequestMapping(value = "/update-details",  method = RequestMethod.GET)
    public String updateAthleteDetails(
            @RequestParam(value = "athleteId", required = true) Long athleteId,
            Model model) {
        model.addAttribute("athleteId", athleteId);
        model.addAttribute(athleteService.getAthleteDetails(athleteId));
        return "updateAthleteDetails";
    }

    @RequestMapping(value = "/update-details",  method = RequestMethod.POST)
    public String updatetAthleteDetails(
            @RequestParam(value = "athleteId", required = true) Long athleteId,
            AthleteDetails athleteDetails, BindingResult result, Model model) {
        athleteService.updateAthleteDetails(athleteDetails, athleteId);
        return "index";
    }

    @RequestMapping("/listAthletes")
    public String listAthletes(Model model) {
        logger.info("Lista de Atletas: ", athleteService.getAll());
        model.addAttribute("athletes", athleteService.getAll());
        return "listAthletes";
    }

}
