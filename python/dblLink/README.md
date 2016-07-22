[Back to Python Main](../)

# Double Link List

This code builds a double link list that consists of a series of nodes with pointers (not actual pointers like those found in C++) to previous and next nodes. In the NodeList class you will find functions to:

- Add new nodes
- Search through the list
- Delete specific nodes
- Print out the entire list.

## Node

This node is a basic setup consisting of only one data member, an integer. It can obviously be expanded as needed.

```
class Node:
    data = 0
    nxt = None
    pre = None
    def __init__(self, data=0,nxt=None, 
                 pre=None):
        self.data = data
        self.nxt = nxt
        self.pre = pre
```

## NodeList

The NodeList class builds a data structure to store the nodes. Yes, it is possible to use a dictionary or list to do this, but building the structure gives a better understanding of the background workings of existing structures.

### Basic Initiation

```
class NodeList:
    head = None
    tail = None
    def __init__(self, data=0,nxt=None, 
                 pre=None):
        """"""
        self.data = data
        self.nxt = nxt
        self.pre = pre
```

### Append

Works like the list function of the same name and add a new entry to the end of the node list

```
    def append(self, data):
        n = Node()
        n.data = data
        #if the list is empty
        if self.head == None:
            self.head = n
            self.tail = n
        else:
            self.tail.nxt = n
            n.pre = self.tail
            self.tail = n
```

### Search

Will go through entire list searching the data field of each node for the target value

```
    def search(self, data):
        temp = self.head
        found = "Found"
        notFound = "Not Found"
        while temp.nxt != None:
            if temp.data == data:
                return found
            else:
                temp = temp.nxt
        return notFound
```

### Delete

The delete function works by going through the full node list and only appends those nodes where the data value is not equal to the target and returns the new list

```
    def delete(self, data):
        tempList = NodeList()
        temp = self.head
        while temp.nxt != None:
            if temp.data != data:
                tempList.append(temp.data)
            temp = temp.nxt
        return tempList
```

### Print All

A simple function to go through each node in the list and print an incrementing integer and the data value. This can be altered if more data is being saved in each node.

```
    def printList(self):
        temp = self.head
        ctr = 1
        print("######List#####")
        while temp != None:
            print("Node",ctr,"data",temp.data)
            temp = temp.nxt
            ctr+=1
```

## Main Program

The rest of the code prints out a menu and performs the function calls. If you look in the main program when menuchoice is equal to 4, you see that we reset what d is equal to by making it equal to the returned list from the delete function above.

```
def printMenu():
    print("1:        Add a number to the list")
    print("2:             View the whole list")
    print("3: Search for a number in the list")
    print("4:   Delete a number from the list")
    print("Enter 0 to exit")
    option = int(input("Select an option"))
    return option
        
if __name__=="__main__":
    d = NodeList()
    menuchoice = -99
    while menuchoice != 0:
        menuchoice = printMenu()
        if menuchoice == 1:
            d.append(int(input("Enter a number to add to the list")))
        if menuchoice == 2:
            d.printList()
        if menuchoice == 3:
            print(d.search(int(input("Enter a number to search for:"))))
        if menuchoice == 4:
            d = d.delete(int(input("Enter a number to delete:")))
            print("#########List#######")
            print("######New list######")
            d.printList()
            print("####################")
```

I will be uploading the original C++ version of this at a future date.
