#pragma once
#include <fstream>

using namespace std;

void writeNamesToTextFile() {
	ofstream out;
	out.open("personList.txt");
	out << "Sean Hayes\n";
	out.close();
}