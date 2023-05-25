package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.PetDTO;
import pe.edu.upc.demo.entities.Pet;
import pe.edu.upc.demo.services.IPetService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private IPetService pS;

    @PostMapping
    public void insert(@RequestBody PetDTO dto) {
        ModelMapper m = new ModelMapper();
        Pet p = m.map(dto, Pet.class);
        pS.insert(p);
    }

    @GetMapping
    public List<PetDTO> list() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PetDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    @GetMapping("/{id}")
    public PetDTO listID(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        PetDTO dto= m.map(pS.listId(id), PetDTO.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody PetDTO dto) {
        ModelMapper m = new ModelMapper();
        Pet p = m.map(dto, Pet.class);
        pS.insert(p);
    }
}
