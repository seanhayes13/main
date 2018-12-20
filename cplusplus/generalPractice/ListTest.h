#pragma once
#include <iostream>
#include <list>
#include "ReadFromTextFile.h"


void printListContent(list<Person> &);
void listPushFront(list<Person> &);

void listTestMain() {
	cout << "####################\nStart List Main\n####################" << endl;
	list<Person> persons;
	buildPersonList(persons);
	cout << "Number of Person objects: " << persons.size() << endl;
	printListContent(persons);
	cout << "Number of Person objects after printing: " << persons.size() << endl;
	listPushFront(persons);
	cout << "Number of Person objects after after using insert to add one more at the beginning of the list: " << persons.size() << endl;
	cout << "####################\nEnd List Main\n####################" << endl;
}

void printListContent(list<Person> &myList) {
	cout << "####################\nStart List Print Content\n####################" << endl;
	for (Person &person : myList) {
		person.printName();
	}
	cout << "####################\nEnd List Print Content\n####################" << endl;
}

void listPushFront(list<Person> &myList) {
	myList.push_front(Person("James", "Greer"));
}

void printVectorPtrContent(list<Person> * persons) {
	auto it = persons->begin();
	while (it != persons->end()) {
		it->printName();
		it++;
	}
}