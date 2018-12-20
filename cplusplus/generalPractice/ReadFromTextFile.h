#pragma once

#include <iostream>
#include <fstream>
#include <string>
#include <queue>
#include <list>
#include <deque>
#include <stack>
#include "Person.h"

using namespace std;

/*
This header file is an example of a collection of methods that don't call each other
so defining the signature ahead of time is not an issue. Look at the VectorTest.h
for an example of when defining the signatures ahead of time is needed.
*/

void readOneLine() {
	ifstream in;
	in.open("sample.txt");
	string text;
	if (in.is_open()) {
		cout << "Found the file" << endl;
		while (getline(in, text)) {
			cout << text << endl;
		}
		in.close();
	}
	else {
		cout << "Uh-oh" << endl;
	}
}

void readMultiplePersonObjects() {
	queue<Person> persons;
	ifstream in;
	in.open("personList.txt");
	string text;
	if (in.is_open()) {
		cout << "File is open" << endl;
		while (getline(in, text)) {
			int i = text.find_first_of(' ');
			string f = text.substr(0, i);
			string l = text.substr(i+1);
			Person p = Person(f, l);
			persons.push(p);
		}
		in.close();
		cout << "File is closed" << endl;
		while (persons.size() > 0) {
			persons.front().printName();
			persons.pop();
		}
	}
	else {
		cout << "Uh-oh" << endl;
	}
}

void buildPersonVector(vector<Person> &ret) {
	ifstream in;
	in.open("personList.txt");
	string text;
	if (in.is_open()) {
		cout << "File is open" << endl;
		while (getline(in, text)) {
			int i = text.find_first_of(' ');
			string f = text.substr(0, i);
			string l = text.substr(i + 1);
			Person p = Person(f, l);
			ret.push_back(p);
		}
		in.close();
		cout << "File is closed" << endl;
	}
	else {
		cout << "Uh-oh" << endl;
	}
}

void buildPersonList(list<Person> &ret) {
	ifstream in;
	in.open("personList.txt");
	string text;
	if (in.is_open()) {
		cout << "File is open" << endl;
		while (getline(in, text)) {
			int i = text.find_first_of(' ');
			string f = text.substr(0, i);
			string l = text.substr(i + 1);
			Person p = Person(f, l);
			ret.push_back(p);
		}
		in.close();
		cout << "File is closed" << endl;
	}
	else {
		cout << "Uh-oh" << endl;
	}

}

void buildPersonDeque(deque<Person> &ret) {
	ifstream in;
	in.open("personList.txt");
	string text;
	if (in.is_open()) {
		cout << "File is open" << endl;
		while (getline(in, text)) {
			int i = text.find_first_of(' ');
			string f = text.substr(0, i);
			string l = text.substr(i + 1);
			Person p = Person(f, l);
			ret.push_back(p);
		}
		in.close();
		cout << "File is closed" << endl;
	}
	else {
		cout << "Uh-oh" << endl;
	}

}

void buildPersonStack(stack<Person> &ret) {
	ifstream in;
	in.open("personList.txt");
	string text;
	if (in.is_open()) {
		cout << "File is open" << endl;
		while (getline(in, text)) {
			int i = text.find_first_of(' ');
			string f = text.substr(0, i);
			string l = text.substr(i + 1);
			Person p = Person(f, l);
			ret.push(p);
		}
		in.close();
		cout << "File is closed" << endl;
	}
	else {
		cout << "Uh-oh" << endl;
	}

}

void buildPersonQueue(queue<Person> &ret) {
	ifstream in;
	in.open("personList.txt");
	string text;
	if (in.is_open()) {
		cout << "File is open" << endl;
		while (getline(in, text)) {
			int i = text.find_first_of(' ');
			string f = text.substr(0, i);
			string l = text.substr(i + 1);
			Person p = Person(f, l);
			ret.push(p);
		}
		in.close();
		cout << "File is closed" << endl;
	}
	else {
		cout << "Uh-oh" << endl;
	}

}

void buildPersonPriorityQueue(priority_queue<Person> &ret) {
	ifstream in;
	in.open("personList.txt");
	string text;
	if (in.is_open()) {
		cout << "File is open" << endl;
		while (getline(in, text)) {
			int i = text.find_first_of(' ');
			string f = text.substr(0, i);
			string l = text.substr(i + 1);
			Person p = Person(f, l);
			ret.push(p);
		}
		in.close();
		cout << "File is closed" << endl;
	}
	else {
		cout << "Uh-oh" << endl;
	}

}