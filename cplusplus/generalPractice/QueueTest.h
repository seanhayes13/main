#pragma once

#include "ReadFromTextFile.h"

void printQueueContent(queue<Person> &);
void queuePushFront(queue<Person> &);
void printQueuePtrContent(queue<Person> *);

void queueTestMain() {
	cout << "####################\nStart Queue Main\n####################" << endl;
	queue<Person> persons;
	buildPersonQueue(persons);
	cout << "Number of Person objects: " << persons.size() << endl;
	printQueueContent(persons);
	cout << "Number of Person objects after printing: " << persons.size() << endl;
	queuePushFront(persons);
	cout << "Number of Person objects after after using insert to add one more at the beginning of the list: " << persons.size() << endl;
	cout << "####################\nEnd Queue Main\n####################" << endl;
}

void printQueueContent(queue<Person> &myList) {
	cout << "####################\nStart Queue Print Content\n####################" << endl;
	while (myList.size() > 0) {
		myList.front().printName();
		myList.pop();
	}
	cout << "####################\nEnd Queue Print Content\n####################" << endl;
}

void queuePushFront(queue<Person> &myList) {
	myList.push(Person("James", "Greer"));
}

void printQueuePtrContent(queue<Person> * persons) {
	while (persons->size() > 0) {
		persons->front().printName();
		persons->pop();
	}
}