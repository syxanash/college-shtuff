begin
  # creo una variabile contatore

  var contatore: int; contatore = 0
  var max = 5;

  # creo una etichetta chiamata condizione
  # partiro' da qui ogni volta che il programma viene
  # eseguito

  label condizione

  # se il contatore e' minore uguale a 5 vado
  # all'etichetta "incrementa" che incrementera'
  # il contatore di 1 una volta superato
  # il valore max che corrisponde a 5 con contatore
  # vado all'etichetta massimoRaggiunto
  # che stampera' solo un messaggio

  if contatore <= max then
    goto incrementa
  else
    goto massimoRaggiunto
  end

  # dichiariamo una etichetta
  label incrementa

  # eseguo una operazione fino a questo punto
  # incrementando la variabile contatore di 1
  contatore = contatore + 1
  goto condizione

  label massimoRaggiunto
  print "ok hai raggiunto il massimo per il contatore!"

  # esempio di loop
  # le seguenti istruzioni
  # gireranno all'infinito

  label primo
  print "home"
  print "sweet"
  goto primo
end
