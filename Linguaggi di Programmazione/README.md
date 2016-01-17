# SoftScript

Parser per un linguaggio di scripting chiamato SoftScript.

## Sintassi

```js
begin
  var name = "Simone"
  var languageName = "SoftScript"
  
  print "Hello " + name + " welcome to " + languageName
end
```
Per ulteriori esempi guardare la sezione **esempi** che contiene ulteriori programmi d'esempio per l'utilizzo del linguaggio.

## Caratteristiche

**SoftScript** è stato concepito come un linguaggio di programmazione in grado di descrivere algoritmi in maniera chiara e semplice. La sintassi prende spunto da linguaggi di programmazione già esistenti quali **Ruby**, **JavaScript** e **Lua**.

Consente di utilizzare i più comuni costrutti di controllo e permette la suddivisione del codice in opportuni moduli e subroutine.

Implementa uno scope *dinamico* realizzato sotto forma di struttura **LIFO** e consente mediante opportune funzioni implementate nel linguaggio, di controllare tutti gli *oggetti denotabili* creati dal programmatore.

Il parser permette di interpretare il codice in tempo reale mediante una *shell interattiva* oppure passando come parametro il nome di un file che contiene un programma scritto in linguaggio **SoftScript**.

Il linguaggio prevede anche un controllo sugli errori di sintassi e lessico mediante produzioni d'errore su token ammissibili. In caso di errori irreparabili, il parser si interrompe lanciando un messaggio di errore che indica la posizione **(riga e colonna)** e il nome dell’ultimo token corretto riconosciuto. Il successivo, quindi, sarà il token errato.

Il punto e virgola per la separazione dei vari statement è opzionale poiché il linguaggio riconoscerà il carriege return come fine dello statement. Tuttavia il ";" verrà utilizzato per descrivere espressioni concatenate su una singola riga di codice.
      
## Caratteristiche aggiuntive

Le caratteristiche più importanti del linguaggio sono di seguito elencate.

* Gestione degli errori mediante produzioni d'errore come token ammissibili.
* Precedenza degli operatori aritmetici con notazione infissa con il **Precedence Climbing Method** descritto da *Martin Richards* e *Colin Whitby-Stevens*.
* Scope dinamico per la creazione di blocchi e dichiarazione di variabili.


## Sviluppatori

Il parser per SoftScript è un concept sviluppato per l'esame di [Linguaggi di Programmazione](http://www.di.uniba.it/~fanizzi/corsi/lp/) corso di [Informatica e Tecnologie per la Produzione del Software](http://informatica.di.uniba.it/laurea_produzione3/index.htm) • [Università degli Studi di Bari](http://www.uniba.it/)

Sviluppatori del progetto:

* Simone Marzulli
* [Antonio Antonino](https://github.com/Diiaablo95)

## Build

Per compilare **SoftScript** bisogna utilizzare il software [JavaCC](https://javacc.java.net/). Una volta installato JavaCC si prosegue compilando il file **.jj** e compilando i file java generati da JavaCC in automatico.

```
javacc SoftScript.jj && javac *.java
```

Se la compilazione è andata a buon fine, si può eseguire l'interprete SoftScript:

```
java SoftScript esempio_variabili.sft
```

##Licenza
```
The MIT License (MIT)

Copyright (c) 2014 SoftScript

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
*'cause why not?*
