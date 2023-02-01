package br.com.persondoc.database.persondoc.adapters;

import br.com.persondoc.database.persondoc.api.dtos.requests.PersonDTO;
import br.com.persondoc.database.persondoc.repository.entities.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonAdapter {

    public static Person convertTo(PersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .age(personDTO.getAge())
                .id(personDTO.getId())
                .documents(DocumentAdapter.convertToList(personDTO.getDocuments()))
                .build();
    }

    public static List<Person> convertToList(List<PersonDTO> personDTO) {
        return personDTO.stream().map(item -> convertTo(item)).collect(Collectors.toList());
    }
}