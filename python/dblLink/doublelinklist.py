# -*- coding: utf-8 -*-
"""
Created on Tue Apr 26 20:04:16 2016

@author: Sean Hayes
"""
"""
The Node is the basic building block for the list. To keep things simple, this only stores integers
"""
class Node:
    data = 0
    nxt = None
    pre = None
    def __init__(self, data=0,nxt=None, 
                 pre=None):
        """"""
        self.data = data
        self.nxt = nxt
        self.pre = pre

"""
The NodeList works like a list, except we 
have a pseudo pointer system set up using 
head and tail, defined in the NodeList class,
and nxt and pre from the Node class.
"""
class NodeList:
    head = None
    tail = None
    def __init__(self, data=0,nxt=None, 
                 pre=None):
        """"""
        self.data = data
        self.nxt = nxt
        self.pre = pre
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
        
    def delete(self, data):
        tempList = NodeList()
        temp = self.head
        while temp.nxt != None:
            if temp.data != data:
                tempList.append(temp.data)
            temp = temp.nxt
        return tempList
        
    def printList(self):
        temp = self.head
        ctr = 1
        print("######List#####")
        while temp != None:
            print("Node",ctr,"data",temp.data)
            temp = temp.nxt
            ctr+=1
            
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
