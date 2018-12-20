#pragma once

#include "ReadFromTextFile.h"

void printPriorityQueueContent(priority_queue<Person> &);
void priorityQueuePushFront(priority_queue<Person> &);
void printPriorityQueuePtrContent(priority_queue<Person> *);

void priorityQueueTestMain() {
	cout << "####################\nStart Queue Main\n####################" << endl;
	priority_queue<Person> persons;
	buildPersonPriorityQueue(persons);
	cout << "Number of Person objects: " << persons.size() << endl;
	//printPriorityQueueContent(persons);
	cout << "Number of Person objects after printing: " << persons.size() << endl;
	priorityQueuePushFront(persons);
	cout << "Number of Person objects after after using insert to add one more at the beginning of the list: " << persons.size() << endl;
	cout << "####################\nEnd Queue Main\n####################" << endl;
}

void printPriorityQueueContent(priority_queue<Person> &myList) {
	cout << "####################\nStart Queue Print Content\n####################" << endl;
	while (myList.size() > 0) {
		//myList.top().printName();
		myList.pop();
	}
	cout << "####################\nEnd Queue Print Content\n####################" << endl;
}

void priorityQueuePushFront(priority_queue<Person> &myList) {
	myList.push(Person("James", "Greer"));
}

void printPriorityQueuePtrContent(priority_queue<Person> * persons) {
	while (persons->size() > 0) {
		//persons->top().printName();
		persons->pop();
	}
}