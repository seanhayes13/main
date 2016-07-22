// SortNodes.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
using namespace std;

// define Structures
struct Node
{
	string color;
	int count;
	Node*  next;
};

void sortnodesstring()
{
	cin.ignore();
	int    nodeCount = 0;
	string testcolor;
	//bool   moreInts = false, moreInput = false;
	Node *prevPtr = NULL, *newPtr = NULL,
		*currPtr = NULL, *frontPtr = NULL,
		*backPtr = NULL, *endPtr = NULL;

	do
	{
		cout << "Enter your favorite color or type exit to quit: ";
		// enter the initial data into the new node
		getline(cin, testcolor);

		// if the user enters exit then Stop otherwise continue
		if (testcolor != "exit")
		{
			if (nodeCount == 0)
			{
				// create a new Node in memory each time
				// point newPtr at the new Node
				newPtr = new Node;
				newPtr->color = testcolor;
				newPtr->next = NULL;
				newPtr->count = 1;

				frontPtr = newPtr;
				endPtr = newPtr;
			}
			//CheckFront
			else if (testcolor <= frontPtr->color)
			{
				if (testcolor == frontPtr->color)
				{
					frontPtr->count++;
				}
				else
				{
					// create a new Node in memory each time
					// point newPtr at the new Node
					newPtr = new Node;
					newPtr->color = testcolor;
					newPtr->next = NULL;
					newPtr->count = 1;

					newPtr->next = frontPtr;
					frontPtr = newPtr;
				}

			}
			else if (testcolor >= endPtr->color)
			{
				//CheckEnd
				if (testcolor == endPtr->color)
				{
					endPtr->count++;
				}
				else
				{
					// create a new Node in memory each time
					// point newPtr at the new Node
					newPtr = new Node;
					newPtr->color = testcolor;
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
				while (testcolor > currPtr->color)
				{
					prevPtr = currPtr;
					currPtr = currPtr->next;
				}
				if (testcolor == currPtr->color)
				{
					currPtr->count++;
				}
				else
				{
					// create a new Node in memory each time
					// point newPtr at the new Node
					newPtr = new Node;
					newPtr->color = testcolor;
					newPtr->next = NULL;
					newPtr->count = 1;

					prevPtr->next = newPtr;
					newPtr->next = currPtr;
				}
			}
			nodeCount++;
		}

	} while (testcolor != "exit");
	currPtr = frontPtr;
	int thiscolor = 1;
	do
	{
		cout << "Node " << thiscolor << " is: " << 
			currPtr->color << " and has been entered " << 
			currPtr->count << " times" << endl;
		frontPtr = frontPtr->next;
		delete currPtr;
		currPtr = frontPtr;
		thiscolor++;
	} while (currPtr != NULL);
	system("PAUSE");
	system("CLS");
}
