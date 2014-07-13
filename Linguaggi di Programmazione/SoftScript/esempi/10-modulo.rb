# creo un modulo iniziale

module gestioneSpesa
  # creo una funzione e ci passo
  # dei parametri formali all'interno

  function addElement(elemento, prezzo)

    # dichiaro due variabili la prima
    # di tipo stringa la seconda, float

    var nome: String
    var costo: Float

    # assegno alle variabili all'interno
    # della funzione le variabili, passate
    # come parametro alla funzione

    nome = elemento
    costo = prezzo

    # creo una nuova variabile aggiungendo
    # uno sconto del 20% sul prezzo

    var sconto = 20

    # assegno alla variabile prezzoScontato
    # il valore restituito dalla funzione getSconto

    var prezzoScontato = call getSconto(valore, sconto)

    # ritorno il valore della variabile appena creata

    return costo
  end

  function getSconto(prezzo, sconto)
    var nuovoPrezzo: Float

    nuovoPrezzo = prezzo * sconto / 100

    return nuovoPrezzo
  end

  GET_STACK

  # termino il modulo creato
end module
