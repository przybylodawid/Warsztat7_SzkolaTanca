package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.TechniqueDto;
import pl.coderslab.model.Technique;
import pl.coderslab.model.User;
import pl.coderslab.repositories.TechniqueRepository;
import pl.coderslab.repositories.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/techniques")
public class TechniqueController {

    @Autowired
    private TechniqueRepository techniqueRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public String showTechniqueAddForm(Model model){
      model.addAttribute("techniqueDto", new TechniqueDto());
      return "forms/techniqueAdd";
    }

    @PostMapping("/add")

    public String saveTechnique(@Valid TechniqueDto techniqueDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "forms/techniqueAdd";
        }
        Technique technique =  new Technique();
        technique.setTechniqueName(techniqueDto.getTechniqueName());
        techniqueRepository.save(technique);

        // TODO gdzie przekierować??
    return "redirect:/admin/techniques/all";
    }

    @GetMapping("/all")
    public String showAllTechniques(Model model){
    List<Technique> techniques = techniqueRepository.findAll();
    model.addAttribute("techniques", techniques);
    return "techniquesShowAll";
    }

    @GetMapping("/edit/{id}")
    public String editTechnique(@PathVariable Long id, Model model){
        Technique technique = techniqueRepository.findOne(id);
        model.addAttribute("technique", technique);
        return "forms/techniqueEdit";

    }

    @PostMapping("/edit/{id}")
    public String saveEditedTechnique(@Valid TechniqueDto techniqueDto,@PathVariable Long id, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "forms/techniqueEdit";
        }

        Technique technique = techniqueRepository.findOne(id);

        technique.setTechniqueName(techniqueDto.getTechniqueName());
        techniqueRepository.save(technique);

    return "redirect:/admin/techniques/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTechnique(@PathVariable Long id){
        techniqueRepository.delete(id);

        return "redirect:/admin/techniques/all";
    }

}
