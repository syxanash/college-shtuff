begin
  # creo una variabile dandogli un valore
  # iniziale pari a 4

  var pippo = 4

  # creo un ciclo while che ciclera'
  # all'infinito stampando la stringa
  # "hello world" per 4 volte

  while pippo > 0 do
    print "hello world"
    pippo = pippo - 1
  end

  # esempio di un altro ciclo while
  # con la condizione posta alla fine
  # del costrutto. Anche in questo caso
  # pippo verra' incrementato fino a
  # raggiungere il valore 4

  pippo = 0

  repeat
    pippo = pippo + 1
  until pippo < 5

  # esempio di un repeat until ed un while
  # con espressione inline.

  while pippo do print "ciao!"; end while

  # il precedente esempio stampera' "ciao!"
  # all'infinito poiché la condizione
  # del while e' sempre vera.

  # ci sono due modi per terminare un while
  # o con la parola chiave end oppure con
  # end while
end
