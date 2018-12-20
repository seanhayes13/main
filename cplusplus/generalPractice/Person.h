#pragma once
#include <string>
#include <iostream>

using namespace std;

class Person {
public:
	string firstName;
	string lastName;
	Person() {
		//cout << "default constructor" << endl;
	};
	Person(string fn, string ln) {
		//cout << "parameter constructor" << endl;
		firstName = fn;
		lastName = ln;
	}
	~Person() { /*cout << "deconstructor" << endl;*/ }
	void printName() {
		cout << this->firstName << " " << this->lastName << endl;
	}

	bool equals(Person &other) {
		if (this->firstName.compare(other.firstName))
			return false;
		else if (this->lastName != other.lastName)
			return false;
		else
			return true;
	}
};