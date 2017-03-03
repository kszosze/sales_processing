# sales_processing
Small tiny basic project to test the liability of the basic java functionalities.

The main concept is receive certain messages of different types and process, store and be able to generate small number of basic report.

Goal is achive ta working application with the minimun nomber of external libraries.

## Installation

There is not required installation. Once the source code is compile a small executable jar is generated

## Execution

In order to run the project is needed run the java as

```
  java -jar challenge1-1.0-SNAPSHOT.jar
```

A message will appear in order to start processing messages.
All the messages will be introduced by the standard input.
The format must be exactly the following for eath type of message:

* Message Type 1 – contains the details of 1 sale E.g apple at 10p 
* Message Type 2 – contains the details of a sale and the number of occurrences of that sale. E.g 20 sales of apples at 10p. 
* Message Type 3 – contains the details of a sale and an adjustment operation to be applied to all stored sales of this product type. Operations can be add, subtract, or multiply.  E.g Add 20p apples.


 
