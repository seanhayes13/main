#pragma once

#include "ReadFromTextFile.h"


void printDequeContent(deque<Person> &);
void dequePushFront(deque<Person> &);
void printDequePtrContent(deque<Person> *);

void dequeTestMain() {
	cout << "####################\nStart Deque Main\n####################" << endl;
	deque<Person> persons;
	buildPersonDeque(persons);
	cout << "Number of Person objects: " << persons.size() << endl;
	printDequeContent(persons);
	cout << "Number of Person objects after printing: " << persons.size() << endl;
	dequePushFront(persons);
	cout << "Number of Person objects after after using insert to add one more at the beginning of the list: " << persons.size() << endl;
	cout << "####################\nEnd Deque Main\n####################" << endl;
}

void printDequeContent(deque<Person> &myList) {
	cout << "####################\nStart Deque Print Content\n####################" << endl;
	/*for (Person &person : myList) {
		person.printName();
	}*/
	deque<Person>::iterator it;
	for (it = myList.begin(); it != myList.end(); it++) {
		it->printName();
	}
	cout << "####################\nEnd Deque Print Content\n####################" << endl;
}

void dequePushFront(deque<Person> &myList) {
	myList.push_front(Person("James", "Greer"));
}

void printDequePtrContent(deque<Person> * persons) {
	/*auto it = persons->begin();
	while (it != persons->end()) {
		it->printName();
		it++;
	}*/
}