package br.com.pisco.myfirstapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LanguageController {
    //responsavel por receber os requests e fornecer as response

    @Autowired
    private LanguageRepository repository;

    //CRUD = Create, Read, Update and Delete

    @GetMapping(value = "/language")
    public List<Language> getLanguage(){
        List<Language> languages = repository.findByOrderByRanking();
        return languages;
    }

    @PostMapping("/language")
    public ResponseEntity<Language> postLanguage(@RequestBody Language language){
        Language saveLanguage = repository.save(language);
        return new ResponseEntity<>(saveLanguage, HttpStatus.CREATED);
    }

    @GetMapping("/language/{id}")
    public Language getLanguageById(@PathVariable String id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    @PutMapping("/language/{id}")
    public Language updateLanguageById(@PathVariable String id, @RequestBody Language language){
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        language.setId(id);
        Language saveLanguage = repository.save(language);
        return saveLanguage;
    }

    @DeleteMapping("/language/{id}")
    public void deleteLanguageById(@PathVariable String id){
        repository.deleteById(id);
    }


}
