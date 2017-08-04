# distributedWork

So as with a lot of my small side projects, this one started with me asking myself if I could write in program that 'simulated' a distributed processing system. The approach I took for the work load was to make a list of words, pick a random number, make an object out of that. The work was just for tracking, the number is used to simulate time spent processing the work (it gets thrown into a Thread.sleep() method).

So the MainUnit starts by creating a set of SubUnit workers. It then takes the list of words, creates a Job from the word and a random number, finds out which SubUnit worker has the smallest work load, assigns that Job to that SubUnit, creates a new Runnable, and starts that Runnable.

When a Job is complete, it is removed from the SubUnit's working list, and added to the MainUnit's completed list.

If all SubUnits have a full workload (5 for testing purposes), the MainUnit will wait 5 seconds, then check again. As long as there is something in the workload for the MainUnit, it will keep going.

This isn't the final version, I plan to expand on it more, this is just a proof of concept. Before expanding on this more, I'm planning to refactor into Python.
