#EBNF per SoftScript

Grammatica per il linguaggio **SoftScript** espressa mediante formalismo EBNF.

### Block

```
<BLOCK> ::= begin (using <MODULE NAME>)* (carriage return)* (<EXPRESSION>)* end block |
            module, name (extend <MODULE NAME>)? (carriage return)*
            (<EXPRESSION>)* end block |
            
            function, name, "(", param, (",", param)*, ")", ((carriege return)+ (<EXPRESSION>)* (end_function | end_block)) |
            
            "{" (<EXPRESSION>)* "}"   (* usata per le espressioni su singola riga *)
```

### Expression

```
<EXPRESSION> ::= (<COMMAND> (carriage return | ";")+) |
                <CONTROL_STATEMENT> (carriage return)+ |
                (<BLOCK> (carriage return)*)
```

### Control Flow Statements

```
<CONTROL_STATEMENT> ::= <IF_STATEMENT> | <FOR_STATEMENT> | <WHILE_STATEMENT> |
                        <REPEAT_STATEMENT> | <CASE STATEMENT>

<CASE_STATEMENT> ::= case, ["("] (<CONTROL_EXPRESSION>)+ [")"], is, (carriage return)*
                     (<VALUE_TYPE>, ':', (carriage return)* (<EXPRESSION>)* break
                     (carriage_return)*)+ [case_default (":")+ (carriage return)*
                     (<EXPRESSION>)* break (carriage_return)*] (end case | end block)

<REPEAT_STATEMENT> ::= repeat (carriage return)* (<EXPRESSION>)* until (["("]
                       <CONTROL_EXPRESSION>)+ [")"])

<WHILE_STATEMENT> ::= while ["("] (<CONTROL_EXPRESSION>)+ [")"] do (carriage_return)*
                      (<EXPRESSION>)* (end while | end block)

<FOR_STATEMENT> ::= for "(" (<CONTROL_EXPRESSION>)* ";" (<CONTROL_EXPRESSION>)*
                    ";" (<CONTROL_EXPRESSION>)* ")" (carriage return)* (<EXPRESSION>)*
                    (end for | end block)

<IF_STATEMENT> ::= if ["("] (<CONTROL_EXPRESSION>)+ [")"] then (carriage return)*
                   (<EXPRESSION>)* (else_if ["("] (<CONTROL_EXPRESSION>)+ [")"] then
                   (carriage return)* (<EXPRESSION>)* )* [else (carriage return)*
                   (<EXPRESSION>)*] (end if | end block)

<CONTROL_EXPRESSION> ::= [<OPERATORS>] (<VALUE_SELECTION> | name [<STATE_OPERATORS>]

<STATE_OPERATORS> ::= (increment | decrement)

<OPERATORS> ::= (":" | "+" | "-" | "*" | "/" | "%" | "&" | "|" | "!" | "=" | "!=" | ">"
                | "<")
```

### Command

```
<COMMAND> ::= <ASSIGNATION> | <GOTO_STATEMENT> | <GOTO_LABEL> | <SUBROUTINE> |
              <RETURN_STATEMENT> | <PRINT_FUNCTION> | <GET_STACK> | <GET_VERSION>
```

### Primitive Types

```
<PRIMITIVE_TYPES> ::= int | float | string | char | boolean | null
```

### Assignation

```
<ASSIGNATION> ::= [const | array | var] variable name ("["
                  (int_value | variable name) "]")* [":" |
                  "=" (([<OPERATORS>] (<VALUE_SELECTION> | variable name)
                  ("[" (int_value | name) "]")*))+ |
                  <ARRAY_ASSIGNATION> |
                  <SUBROUTINE>) | size int_value (per int_value)*] (* Used for matrix *)
                  
<ARRAY_ASSIGNATION> ::= "[" (<VALUE_SELECTION> | variable name)
                        ("," (<VALUE_SELECTION> | name))* "]"
```

### Operators Precedence

```
<EQUALITY_EXPR> ::= <ADDITIVE_EXPR> (("=" | "!=" | ">" | "<" | ">=" | "<=") <ADDITIVE_EXPR>)*

<ADDITIVE_EXPRESSION> ::= <MULTIPLICATIVE_EXPR> (("+" | "-") <MULTIPLICATIVE_EXPR>)*

<MULTIPLICATIVE_EXPR> ::= <PRIMARY> (("*" | "/" | "%") <PRIMARY>)*

<PRIMARY> ::= "(", <EQUALITY_EXPR>, ")" | <VALUE_SELECTION> | variable name
```

### Sub Routines

```
<SUBROUTINE> ::= call name ("::" <FUNCTION NAME>)? "("
				 [(<VALUE_SELECTION> | parameter name) (","
                 (<VALUE_SELECTION> | parameter name))*] ")"
<RETURN_STATEMENT> ::= return (<VALUE_SELECTION> | variable name)
```

### Other Statements

```
<GOTO_STATEMENT> ::= goto, label name
<GOTO_LABEL> ::= label name

<PRINT_FUNCTION> ::= print strings

<GET_STACK> ::= get_stack | get_current_scope

<GET_VERSION> ::= get_version
```