begin
  # dichiaro un array di interi

  array numeri: int

  # adesso assegno al precedente array
  # 20 locazioni iniziali

  numeri withsize 20

  # dichiaro un'array con 10 elementi iniziali
  
  array lista withSize 10

  # creo un nuovo array ed
  # assegno i valori di lista

  array altroArray = lista

  # creo una matrice di 3 righe e 3 colonne

  array cuboRubik withSize 3 x 3 x 3

  cuboRubik[2][2][2] = "cubetto centrale"

  # creo un array con degli elementi iniziali

  array pippo = ["primo elemento", 2, 3.14, '4', true, false]

  # creo un nuovo array ed inserisco una variabile
  # in fase di dichiarazione

  var numeretto = 3

  array pippo2 = [numeretto, 4]

  # creo una variabile ed assegno la variabile
  # alla prima locazione del nuovo array listaNomi

  var mioNome = "Simone"

  array listaNomi[0] = mioNome
  listaNomi[1] = "Antonio"       # seconda posizione inserisco stringa

  # creo una variabile che mi servira' in seguito

  var frutto = "mele"

  # creo un nuovo scope

  begin
    # lista spesa ora sara' creato nello scope 2

    array listaSpesa withSize 12

    # assegno a lista della spesa la variabile frutto
    # creata nello scope precedente

    listaSpesa[0] = frutto
  end

  GET_STACK
end
