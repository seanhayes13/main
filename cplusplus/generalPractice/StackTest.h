#pragma once

#include "ReadFromTextFile.h"

void printStackContent(stack<Person> &);
void stackPushFront(stack<Person> &);
void printStackPtrContent(stack<Person> *);

void stackTestMain() {
	cout << "####################\nStart Deque Main\n####################" << endl;
	stack<Person> persons;
	buildPersonStack(persons);
	cout << "Number of Person objects: " << persons.size() << endl;
	printStackContent(persons);
	cout << "Number of Person objects after printing: " << persons.size() << endl;
	stackPushFront(persons);
	cout << "Number of Person objects after after using insert to add one more at the beginning of the list: " << persons.size() << endl;
	cout << "####################\nEnd Deque Main\n####################" << endl;
}

void printStackContent(stack<Person> &myList) {
	cout << "####################\nStart Deque Print Content\n####################" << endl;
	while (myList.size() > 0) {
		myList.top().printName();
		myList.pop();
	}
	cout << "####################\nEnd Deque Print Content\n####################" << endl;
}

void stackPushFront(stack<Person> &myList) {
	myList.push(Person("James", "Greer"));
}

void printStackPtrContent(stack<Person> * persons) {
	while (persons->size() > 0) {
		persons->top().printName();
		persons->pop();
	}
}