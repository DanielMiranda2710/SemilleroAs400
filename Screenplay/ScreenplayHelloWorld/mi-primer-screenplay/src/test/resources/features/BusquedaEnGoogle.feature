Feature: Search in google with data from feature
  Daniel quiere hacer una busqueda en google con datos

  @SmokeTest
  Scenario Outline: buscar en google
    Given Daniel is in the google home page
    When he searchs a "<palabra>" composite "<palabrados>"
    Then he validates that word"<resultadoEsperado>" is in results.

    Examples: 
      | palabra  | palabrados | resultadoEsperado |
      | devops   | java       | devops java       |
      | jenkhins | java       | jenkhins java     |
      | docker   | java       | docker java       |
