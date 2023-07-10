# jlox language interpreter

## Notes of each Phase of coding

- Consuming each **character** and building **lexemes or tokens** (Chapter 4. Scanning).
- Defining the rules of **syntax grammar** and how is structured in java classes (Chapter 5. Representing Code).
  <pre>expression  -> literal
              | unary
              | binary
              | grouping ;
  literal     -> NUMBER | STRING | "true" | "false" | "nil";
  grouping    -> "(" expression ")" ;
  unary       -> ( "-" | "!" ) expression ;
  binary      -> expression operator expression ;
  operator    -> "==" | "!=" | "<" | "<=" | ">" | ">=" | "+" | "-" | "\*" | "/" ;</pre>
- Parsing: consuming **tokens** to build **expressions** that build an AST (Chapter 6. Parsing expressions).
  | Name       | Operators | Associates |
  |------------|:---------:|-----------:|
  | Equality   |   ==  !=  |       Left |
  | Comparison | > >= < <= |       Left |
  | Term       |    -  +   |       Left |
  | Factor     |    *  /   |       Left |
  | Unary      |    !  -   |      Right |

