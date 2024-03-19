package com.evaluacionCurso.api.models;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.imunnic.testController.Result;
import com.imunnic.testController.Trial;

@JsonIgnoreProperties({"trial", "grossResult", "result", "tester"})
@JsonPropertyOrder({"asignatura","puntuacion"})
public class Nota extends Result{
  
  @JsonGetter("asignatura")
  public String getAsignaturaNombre() {
    return getTrial().getName();
  }
  
  @JsonProperty("puntuacion")
  public int getPuntuacion() {
    return getResult();
  }
  
  public Nota() {
    super();
  }

  public Nota(Profesor profesor, Trial trial, int grossResult) {
    super(profesor, trial, grossResult);
    
  }

}
