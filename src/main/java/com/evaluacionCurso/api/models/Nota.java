package com.evaluacionCurso.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imunnic.testController.Result;
import com.imunnic.testController.Trial;

public class Nota extends Result{
  public Nota() {
    super();
  }

  public Nota(Profesor profesor, Trial trial, int grossResult) {
    super(profesor, trial, grossResult);
    
  }
  @JsonProperty("idProfesor")
  public int getProfesorId() {
    return super.getTester().getId();
  }
}
