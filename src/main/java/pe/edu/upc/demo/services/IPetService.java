package pe.edu.upc.demo.services;

import pe.edu.upc.demo.entities.Pet;

import java.util.List;

public interface IPetService {

    public void insert(Pet pet);
    List<Pet> list();

    public void delete(int idPet);

    public Pet listId(int idPet);
}
