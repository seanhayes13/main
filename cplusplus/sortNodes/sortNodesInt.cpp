#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

// define Structures
struct Node
{
	int num, count;
	Node*  next;
};

void sortnodesint()
{
	int    nodeCount = 0, testNum = 0;
	//bool   moreInts = false, moreInput = false;
	Node *prevPtr = NULL, *newPtr = NULL,
		*currPtr = NULL, *frontPtr = NULL,
		*backPtr = NULL, *endPtr = NULL;

	do
	{
		cout << "Enter a Positive Integer to add to the Queue (-1 to Quit): ";
		// enter the initial data into the new node
		cin >> testNum;

		// if the user enters -1 then Stop otherwise continue
		if (testNum != -1)
		{
			if (nodeCount == 0)
			{
				// create a new Node in memory each time
				// point newPtr at the new Node
				newPtr = new Node;
				newPtr->num = testNum;
				newPtr->next = NULL;
				newPtr->count = 1;

				frontPtr = newPtr;
				endPtr = newPtr;
			}
			//CheckFront
			else if (testNum <= frontPtr->num)
			{
				if (testNum == frontPtr->num)
				{
					frontPtr->count++;
				}
				else
				{
					// create a new Node in memory each time
					// point newPtr at the new Node
					newPtr = new Node;
					newPtr->num = testNum;
					newPtr->next = NULL;
					newPtr->count = 1;

					newPtr->next = frontPtr;
					frontPtr = newPtr;
				}

			}
			else if (testNum >= endPtr->num)
			{
				//CheckEnd
				if (testNum == endPtr->num)
				{
					endPtr->count++;
				}
				else
				{
					// create a new Node in memory each time
					// point newPtr at the new Node
					newPtr = new Node;
					newPtr->num = testNum;
					newPtr->next = NULL;
					newPtr->count = 1;

					endPtr->next = newPtr;
					endPtr = newPtr;
				}
			}
			else
			{
				//CheckMiddle
				prevPtr = frontPtr;
				currPtr = frontPtr->next;
				while (testNum > currPtr->num)
				{
					prevPtr = currPtr;
					currPtr = currPtr->next;
				}
				if (testNum == currPtr->num)
				{
					currPtr->count++;
				}
				else
				{
					// create a new Node in memory each time
					// point newPtr at the new Node
					newPtr = new Node;
					newPtr->num = testNum;
					newPtr->next = NULL;
					newPtr->count = 1;

					prevPtr->next = newPtr;
					newPtr->next = currPtr;
				}
			}
			nodeCount++;
		}

	} while (testNum != -1);
	currPtr = frontPtr;
	int thisNum = 1, nodeTotal = 0;
	do
	{
		cout << "Node " << thisNum << " is: " << currPtr->num << " and has been entered " << currPtr->count << " times" << endl;
		nodeTotal = nodeTotal + (currPtr->num*currPtr->count);
		frontPtr = frontPtr->next;
		delete currPtr;
		currPtr = frontPtr;
		thisNum++;
	} while (currPtr != NULL);
	cout << "Total is " << nodeTotal << endl;
	system("PAUSE");
	system("CLS");
}
