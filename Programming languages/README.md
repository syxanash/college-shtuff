# SoftScript

Parser for a programming language called SoftScript.

## Syntax

```js
begin
  var name = "Simone"
  var languageName = "SoftScript"

  print "Hello " + name + " welcome to " + languageName
end
```

For additional examples you can look in directory `esempi` which contains small programs written for demonstrating the syntax and constructs used by this programming language.

## Features

**SoftScript** is a scripting programming language designed for easily writing algorithms and programs using common english language words. The syntax is highly inspired by programming languages like **Ruby**, **JavaScript** and **Lua**.

It allows to use many constructs and control flow statements typical of imperative and OOP paradigms, code can also be separated into modules and subroutines.

This scripting language was implemented with a *dynamic scope*, achieved using a **LIFO** structure. The interpreter also provides a verbose mode which shows all the variables, functions, modules and parameters shared among the scopes.

The code can be interpreted using the *REPL shell* or written on a file passed to the interpreter as an argument. In case the syntax is not valid the interpreter is able to recover (where possible) the flow. If the interpreter is not able to recover the current error it shows the last accepted token and the column/row numbers indicating the wrong token.

The use of the semicolon character for statements separation is not mandatory because the language uses the carriage return instead, however the `;` character can be used when writing multiple statements on a single line. See `9-inline.rb` file in `esempi`.

## Additional features

Here are listed some of the additional and important features implemented in this programming language:

* error recovery and incorrect tokens recognition;
* infix notation for arithmetical and logical operators using the **Precedence Climbing Method** by Martin Richards e Colin Whitby-Stevens;
* dynamic scope which allows to create separated blocks of code and different scope for variables.

## About

The parser for the SoftScript language is a concept written for the exam [Linguaggi di Programmazione](http://www.di.uniba.it/~fanizzi/corsi/lp/) (Programming Languages) a computer science class in [Informatica e Tecnologie per la Produzione del Software](http://informatica.di.uniba.it/laurea_produzione3/index.htm) • [Università degli Studi di Bari](http://www.uniba.it/)

developed by me and [Antonio Antonino](https://github.com/Diiaablo95).

## Build

In order to build the interpreter you'll need to use the software [JavaCC](https://javacc.java.net/). Once JavaCC is installed compile the file in `.jj` extension plus the java files generated.

```
javacc SoftScript.jj && javac *.java
```
If JavaCC correctly compiles then SoftScript interpreter can be executed like so:

```
java SoftScript esempio_variabili.sft
```

## License
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
