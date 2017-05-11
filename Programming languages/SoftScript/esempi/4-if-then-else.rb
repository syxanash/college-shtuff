begin
  # esempio di uso di un costrutto
  # di controllo if then else

  var voto: int; voto = 5

  if voto >= 5 then
    print "maggiore uguale a 5"
  end

  voto = 25

  # esempio di un if con un else

  if voto >= 18 then
    print "benfatto!"
  else
    print "bocciato!"
  end

  # nell'esempio precedente dovrebbe
  # stampare il primo print

  # esempio di un if else if ed else

  if voto = 18 then
    print "potevi fare di meglio!"
  else if voto = 25 then
    print "accetto e vado avanti!"
  else if voto = 30 then
    print "e ti stai lamentando?"
  else
    print "non saprei..."
  end

  # esempio con if inline, ovviamente il comando all'interno del
  # then dovra' concludersi con un ";"

  if voto >= 30 then print "non poteva andare meglio!"; end if

  /*
    un costrutto if e' possibile terminarlo utilizzando
    la parola chiave end oppure end if
  */

end
