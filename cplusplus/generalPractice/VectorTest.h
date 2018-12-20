#pragma once
#include <iostream>
#include "ReadFromTextFile.h"

/*This class is an example of when defining the method signature before hand
is needed since one method calls another. ReadFromTextFile.h is an example
where this is not needed because the individual methods do not call each other.*/

void printVectorContent(vector<Person> &);
void vectorPushFront(vector<Person> &);
void printVectorPtrContent(vector<Person>*);

void vectorTestMain() {
	cout << "####################\nStart Vector Main\n####################" << endl;
	vector<Person> persons;
	buildPersonVector(persons);
	cout << "Number of Person objects: " << persons.size() << endl;
	/*for (Person &person : persons) {
		person.printName();
	}*/
	printVectorContent(persons);
	cout << "Number of Person objects after printing: " << persons.size() << endl;
	vectorPushFront(persons);
	cout << "Number of Person objects after after using insert to add one more at the beginning of the list: " << persons.size() << endl;
	vector<Person>* personsPtr = &persons;
	printVectorPtrContent(personsPtr);
	cout << "####################\nEnd Vector Main\n####################" << endl;
}

void printVectorContent(vector<Person> &myVector) {
	cout << "####################\nStart Vector Print Content\n####################" << endl;
	for (Person &person : myVector) {
		person.printName();
	}
	cout << "####################\nEnd Vector Print Content\n####################" << endl;
}

void vectorPushFront(vector<Person> &myVector) {
	myVector.insert(myVector.begin(), Person("James", "Greer"));
}

void printVectorPtrContent(vector<Person> * persons) {
	auto it = persons->begin();
	while (it < persons->end()) {
		it->printName();
		it++;
	}
}