# Threaded Singleton

So this bit of code came from wanting to come up with a better way to show how the use of singletons work with multithreading. Originally I tried to explain it to some classmates verbally and using a dry erase board. Then, partially out of boredom, I decided to write this.

## TestSingleton

This is a very basic singleton class with a private static instance of itself, a private static AtomicInteger (to keep track of how many times the singleton is referenced) and a private HashMap to store two integers. The AtomicInteger is really meant as an additional demonstration of the concept of static member. The HashMap is populated during the run of the code with a loop number and a random number.

## Automaton

The Automaton extends the Thread class and has an int to save the id, and a TestSingleton instance. In the run method, we execute a for loop. Inside the loop, we start with a pause that grows based on the Automaton's id times the iteration of the loop plus 1000 (this is so that with larger numbers of Automatons and higher number of iterations in the for loop, the user can see different Automatons running at different times). Then we get a random number, add an entry into the singleton's HashMap, print out two messages. Repeat.

## Main

In the main, we have a static ExecutorService to manage all of the threads. In the main method, we have an ArrayList to store all of the TestSingletons that are created. As each is created, it is added to the list, then added to a new Automaton which is then added to the ExecutorService to get them running. In the base version that has been loaded here, after all runs are complete, we grab the first TestSingleton in the list and display the contents of its HashMap.
