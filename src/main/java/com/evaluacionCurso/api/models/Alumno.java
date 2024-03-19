package com.evaluacionCurso.api.models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.imunnic.testController.Participant;
import com.imunnic.testController.Person;
import com.imunnic.testController.Result;

@JsonIgnoreProperties({"name", "dorsal", "id", "person", "alias", "results"})
@JsonPropertyOrder({"idAlumno", "nombre", "notas"})
public class Alumno extends Participant{
  
  private void setIdAlumno(Long id) {
    setId(id);
  }
  
  public Long getIdAlumno() {
    return getId();
  }
  
  public void setNombre(String nombre) {
    getPerson().setName(nombre);
  }
  
  public String getNombre() {
    return getPerson().getName();
  }
  
  public void addNota(Nota nota) {
    getResults().add(nota);
  }
  
  public List<Result> getNotas(){
    return getResults();
  }
  
  public Alumno() {
    setResults(new ArrayList<Result>());
    setPerson(new Person<Long>());
  }

  public Alumno(String name, Long id) {
    this();
    setIdAlumno(id);
    setNombre(name);
  }
  
  public Alumno(String name, Long id, List<Result> results) {
    this(name, id);
    setResults(results);
  }
  
  @Override
  public String toString() {
    return "Alumno: " + getPerson().getName() /*+ " Id: " + getIdAlumno()*/;
  }
}
