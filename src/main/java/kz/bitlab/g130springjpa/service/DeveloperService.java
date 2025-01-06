package kz.bitlab.g130springjpa.service;

import kz.bitlab.g130springjpa.entity.Developer;
import kz.bitlab.g130springjpa.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    public Developer getDeveloperByEmail(String email) {
        return developerRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found" + email));
    }

    public void addDeveloper(Developer developer) {
        developerRepository.save(developer);
    }

    public void updateDeveloper(Developer developer) {
        developerRepository.save(developer);
    }

    public void deleteDeveloperById(Long id) {
        developerRepository.deleteById(id);
    }

}
