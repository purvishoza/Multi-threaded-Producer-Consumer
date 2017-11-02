Concurrency and multithreading in Java
 Multithreading producer-consumer in Java with concurrency, multithreading and synchronization.
We need three producers and two consumers (five thread) in a multithreaded program (concurrency with synchronization).
All producers and consumers access the same buffer.
The buffer is an integer array of length 5.
Each producer add a value between 1 – 10 to one of the slot of buffer.
Each consumer consumes (subtract) a value between 1 – 10 from one of the buffer slot. Initially the buffer is empty (all slots have value 0). The maximum value in each slot is 100 and minimum is 0. 
In the output print the buffer after each transaction and which thread performed the transaction. Each transaction is adding a value or subtracting a value from one of the slot by one of the five thread.
Output is like:
First transaction done by a producer on slot 2 add 7
P 2 7
Second transaction done by a consumer on buffer slot number 5 subtracting 3
C 5 3


