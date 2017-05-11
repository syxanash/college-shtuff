# creo un modulo iniziale
# e lo estendo importando tutte le funzioni
# presenti in un altro modulo
# fittizio chiamato Matematica

module GestioneSpesa extend Matematica
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

    # chiamo una funzione fittizia chiamata
    # Radix presente nel modulo che ho esteso chiamato Matematica
    # e la applico al nuovo prezzo calcolato

    var risultato = call Matematica::Radix(nuovoPrezzo)

    return nuovoPrezzo
  end

  GET_STACK

  # termino il modulo creato
end module