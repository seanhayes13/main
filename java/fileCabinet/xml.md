 # Working with XML

So if you are reading this after reading the previous posting, I was working with just grabbing every node in
a drawer then saving all of those as one list, and then processing each of those nodes and building pages. Ugly.
Thankfully, I adjusted the code to save each drawer in its entirety and keeping the same structure (was actually
easier than I thought it would be).

After two months of development, I decided to change the output format and switched from JSON to XML. This partly
came about after doing some testing and realizing that not only was XML cleaner and better organized, but with
some extra coding I could eliminate a problem that was happening when storing the ForeignKeyLists. In the end, I
was able to trim off a couple hundred lines of code (the code to build the relationships went from over 100 lines
to around 40).

[Back to the start](readme.md) | [ForeignKeyList](fkl.md) | [What Works?](whatworks.md) | [Commands](commands.md)
