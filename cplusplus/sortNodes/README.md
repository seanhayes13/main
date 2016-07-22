[Back to C++ Main](../)

# Sort Nodes in C++

This section contains two variations of the same code that get either an integer or string input 
from the user, store that data in a node, stores those nodes into a single linked list structure
and sorts those nodes according to the data.

## How it works (integer version)

### Set the Stage

First we define a structure called Node:
```
struct Node
{
	int num, count;
	Node*  next;
};
```

Inside the main program we define a few integer variables and set the pointers to NULL:

```
void sortnodesint()
{
	int    nodeCount = 0, testNum = 0;
	//bool   moreInts = false, moreInput = false;
	Node *prevPtr = NULL, *newPtr = NULL,
		*currPtr = NULL, *frontPtr = NULL,
		*backPtr = NULL, *endPtr = NULL;
```

### Get the First Input

Within a do-while loop, the program asks the user for input with -1 being the escape value.
If the input is not -1 and this is the first entry in the list, we create a new Node and make it
the front and end of the list:

```
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
```

So if the first entry is 3, the first Node in the list contains a Node with 3 stored in the num variable.

### Check the Beginning

Now the fun begins. After putting in the first Node, every Node after that has to be placed in the 
right spot in the list. To do this, we check if the new entry comes before the front of the list.

```
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
```

So if the new entry is 3, since 3 is already in the list, the count gets incremented.
If the new entry is less than 3, a new node is created, its next pointer is set to the current
front pointer, then the front pointer is set to the new Node.

### Check the End

The next step is to check if the new value comes after the last entry in the list.
This process is similar to the above code, the difference being that end pointer is moved:

```
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
```

### Check the Middle

And for the confusing part, checking the new value against everything between the front and the end.
To do this, we start at the beginning and slowly work through the list one Node at a time until we find
the right spot to insert the new value. Once found, redirect the next pointers and we are done.

```
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
```

### Print the List

Once the user enters -1 and escapes the sequence, we go through each Node in the list and 
print out the numbers and how often they were entered.

```
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
```

Thanks to 'c' being greater than 'a' and less than 'e', sorting strings works similar to sorting integers.
