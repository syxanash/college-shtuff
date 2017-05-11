# creo uno scope iniziale

begin

  # creo un nuovo scope

  var pippo = 3

  begin

    var piGreco = 3.14

    # creo ancora un'altro scope

    begin

      # la variabile pippo ora
      # appartiene al terzo scope (2 partendo da 0)
      # il valore di pippo sara' quindi 3.14
    
      var pippo = piGreco

      # la funzione primitiva seguente stampa tutte le
      # variabili presenti nello scope corrente
      # in questo caso stampera' solo pippo

      GET_CURRENT_SCOPE

    end

    # la variabile pippo non e' piu' visibile in
    # questo scope, quindi dovro' creare un altra
    # variabile di nome pippo per assegnarla a test

    var pippo: String

    var test = pippo

    # get current scope stampera' pippo e test

    GET_CURRENT_SCOPE

  end

  # la variabile altroTest fara' riferimento
  # alla variabile pippo con valore 3
  # creata nello stesso scope, ovvero primo scope (0)

  var altroTest = pippo

  GET_STACK
end
