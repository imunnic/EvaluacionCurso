package com.evaluacionCurso.api.models;

import com.imunnic.testController.Result;
import com.imunnic.testController.Trial;

public class Nota extends Result{
  public Nota() {
    super();
  }

  public Nota(Profesor profesor, Trial trial, int grossResult) {
    super(profesor, trial, grossResult);
    
  }
}
