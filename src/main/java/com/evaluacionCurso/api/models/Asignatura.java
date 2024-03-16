package com.evaluacionCurso.api.models;

import com.imunnic.testController.Trial;

public enum Asignatura implements Trial {
  INTRODUCCION_PROGRAMACION("Introducción a la programación", "Conceptos básicos de la programación.") {

    @Override
    public int getMark(Integer result) {
      return result * 3;
    }
  },
  INTRODUCCION_BBDD("Introducción a la Teoría General de las Bases de Datos", "Conceptos básicos de la teoría de Bases de Datos.") {

    @Override
    public int getMark(Integer result) {
      return result;
    }

  },
  ARQUITECTURA_COMPUTADORES("Arquitectura de computadores", "Conceptos fundamentales de hardware y software.") {

    @Override
    public int getMark(Integer result) {
      return result * 2;
    }
  },
  REDES_COMUNICACIONES("Redes de comunicaciones", "Introducción a los conceptos básicos de redes") {
    // tiempo medido en minutos
    @Override
    public int getMark(Integer result) {
      return 150 / result;
    }
  },
  INGENIERIA_SOFTWARE("Fundamentos de Ingeniería del Software",
      "Introducción al desarrollo de proyectos de software") {

    @Override
    public int getMark(Integer result) {
      return result * 4;
    }

  };

  private final String name;
  private final String description;

  Asignatura(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return getName() + "\n" + getDescription();
  }


}
