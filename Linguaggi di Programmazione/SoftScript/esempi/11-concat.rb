begin
  const numeroElementi = 10
  const mesi = 5

  var sommaUffici = call eseguiSommaUffici()
  var sommaSpese = call eseguiSommaSpese()

  # creo una nuova variabile che
  # contterra' una espressione aritmetica complessa

  var formuletta = ((sommaUffici / numeroElementi) + (sommaSpese / numeroElementi)) * mesi

  if (-3 < (4*3)) then
    print "penso questa disuguaglianza sia vera..."
  end

  # concateno una stringa con un intero

  var nome = "Simone"
  var eta = 20
  var saluto = "Ciao " + nome + " la tua eta' corrisponde a: " + eta
end
