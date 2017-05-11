begin

  # creo una variabile iniziale
  # dando un valore pari a 4

  var eta = 4

  # creo un costrutto case is
  # che controlla la variabile eta

  # se eta ha come valore 4
  # allora stampo il messaggio corrispondente
  # se eta assume un valore negativo
  # stampo il messaggio "e' negativa!"
  # se non e' nessuna delle precedenti condizioni
  # allora stampero' "non so che dire!" con la
  # parola chiave default seguita da ":" opzionali

  case eta is
    4:
      print "si hai 4 anni"
    break
    false:
      print "e negativa!"
    break
    default:
      print "non so che dire"
    break
  end case

  # e' possibile terminare il costrutto case usando le parole chiave
  # end oppure end case

  # esempio di un costrutto case costruito
  # con una espressione inline

  case eta is 4: eta = "ok"; break 5: eta = "sei grande!"; break default print "non saprei!"; break end
end
