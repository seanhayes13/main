#include "Person.h"
#include "PreprocessorUsage.h"
#include "ReadFromTextFile.h"
#include "WriteToTextFile.h"
#include "VectorTest.h"
#include "ListTest.h"
#include "DequeTest.h"
#include "StackTest.h"
#include "QueueTest.h"

#define WELCOME "Welcome to my General Test Bed"

using namespace std;

int main() {
	cout << WELCOME << endl;

	//usingIfDef();

	//readOneLine();

	//writeNamesToTextFile();

	//readMultiplePersonObjects();

	//vectorTestMain();

	//listTestMain();

	//dequeTestMain();

	//stackTestMain();

	queueTestMain();

	cout << "Good bye" << endl;

	system("pause");

	return 0;
}