begin
  # creo una variabile contatore

  var contatore: int

  # creo una variabile che conterra' la somma
  # dei 10 elementi

  var somma: int; somma = 0

  for (contatore = 0; contatore < 10; contatore++)
    somma = somma + contatore
  end

  # esempio di operazioni con un array

  array listaSpesa = [3.50, 5.50, 10]

  somma = 0

  for (contatore = 0; contatore < 3; contatore++)
    somma = somma + listaSpesa[contatore]
  end for

  # somma ora dovrebbe contenere la somma di
  # tutti i valori di listaSpesa

  # for con espressione inline
  # stampa ciao per 5 volte

  for(contatore = 0; contatore < 5; contatore++) print "ciao"; end


  # ci sono due modi per terminare un costrutto
  # for, attraverso la parola chiave "end" oppure
  # con "end for"
end
