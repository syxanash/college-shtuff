begin
  /*
    Creazione di una espressione inline.
    Le espressioni inline si creano separando
    tutti i comandi con un punto e virgola e
    per la creazione dello scope racchiudendo
    tutto il blocco tra parentesi graffe
  */

  # esempio di creazione di due variabili

  { var mioValore: String; mioValore = "ciao sono simone"; var saluto = mioValore; }
  
  # esempio di creazione di un array

  { array nomiSviluppatori withSize 2; nomiSviluppatori[0] = "Simone"; nomiSviluppatori[1] = "Antonio"; }

  GET_STACK
end
