package cz.upce.nnpia.eschool.controller;

import cz.upce.nnpia.eschool.entity.Parent;
import cz.upce.nnpia.eschool.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/parents")
public class ParentController {
    @Autowired
    ParentRepository parentRepository;

    @GetMapping
    List<Parent> getParents(){
        return parentRepository.findAll();
    }
    @PostMapping
    Parent createParent(@RequestBody Parent parent){
        return parentRepository.save(parent);
    }
}
