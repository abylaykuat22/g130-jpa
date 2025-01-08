package kz.bitlab.g130springjpa.controller;

import kz.bitlab.g130springjpa.entity.Company;
import kz.bitlab.g130springjpa.entity.Country;
import kz.bitlab.g130springjpa.entity.Developer;
import kz.bitlab.g130springjpa.repository.CompanyRepository;
import kz.bitlab.g130springjpa.service.CompanyService;
import kz.bitlab.g130springjpa.service.CountryService;
import kz.bitlab.g130springjpa.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DeveloperService developerService;
    private final CompanyService companyService;
    private final CountryService countryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Developer> developers = developerService.getAllDevelopers();
        model.addAttribute("developers", developers);

        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("компании", companies);

        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("страны", countries);
        return "home";
    }

    @PostMapping("/developers/add")
    public String addDeveloper(Developer developer) {
        developerService.addDeveloper(developer);
        return "redirect:/";
    }

    @GetMapping("/developers/{id}")
    public String getDeveloper(@PathVariable Long id, Model model) {
        Developer developer = developerService.getDeveloperById(id);
        model.addAttribute("developer", developer);

        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("компании", companies);
        return "developer-details";
    }

    @PostMapping("/developers/edit")
    public String editDeveloper(Developer developer) {
        developerService.updateDeveloper(developer);
        return "redirect:/";
    }

    @PostMapping("/developers/delete/{id}")
    public String deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloperById(id);
        return "redirect:/";
    }
}
