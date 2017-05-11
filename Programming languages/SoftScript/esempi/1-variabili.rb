begin
  # dichiaro una nuova variabile intera

  var numeroMagico: int
  
  # ora assegno il valore 3 alla variabile
  # precedentemente creata

  numeroMagico = 3

  # dichiaro una variabile e successivamente
  # assegno un valore booleano

  var veritas: boolean
  veritas = true

  # dichiaro due variabili ed effettuo uno scambio
  # utilizzando una variabile temporanea

  var primo: int
  var secondo: int
  var temp: int

  primo = 3; secondo = 4; temp = 0

  temp = primo
  primo = secondo
  secondo = temp

  /*
    ora primo dovrebbe valore 4
    e secondo dovrebbe valore 3
  */

  # creo una variabile ed incremento di una unita'
  # il suo valore

  var test = 0
  test = test + 1

  # effettuo altre operazioni aritmetiche su test

  test = 3 + 2

  # creo uno scope

  begin
    # test e' stata creata per lo scope 2
    var test = 3

    /*
      la variabile nuovoTest ora fara' riferimento
      alla variabile piu' interna allo scope che
      corrisponde a test con valore 3
    */

    var nuovoTest = test
  end

  # dichiaro una nuova costante di tipo intero
  # generalmente le costanti vengono dichiarate all'inizio del codice

  const pippo: int

  GET_STACK
end
