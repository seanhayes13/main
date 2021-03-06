[Back to Java Main](../)

# File Back Up

## Background
As you can see from the number of languages I have on here, I have files all over my computer, 
which makes backing up my work a little time consuming. So what is a programmer to do when a
problem arises? Write a program to solve the problem.

## Getting started

I started with [this](https://www.mkyong.com/java/how-to-copy-directory-in-java/) bit of code
from mkyong.com which copies one folder and all of its subfolders and files.

## Defining the backup folder

My naming convention for backups is:

* 4 digit year
* 2 digit month
* 2 digit day
* 2 digit hour (using 24 hour system to avoid confusion between AM and PM)
* 2 digit minute

For example, I'm writing this line at 12:31 am on 6 August 2016 (why am I up this late? curse of working
night shifts 4 nights a week and trying to stay on the same sleep schedule). This comes out to 
201608060031. I use this format so it is easier to sort the folders by name. To do this, I use this code:

```
		LocalDate dNow = LocalDate.now();
		LocalDateTime dtNow = LocalDateTime.now();
		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		String test2 = df2.format(dtNow);
		File newDir = new File("E:\\backups\\"+test2);
		newDir.mkdir();
```

The newDir File is the same as the destFolder used by Mkyong's code. However, pulling from
multiple sources, the srcFolder has to iterate through each folder, which means modifiying the
code.

## New Main

As I said, the existing code works with source folder, but what to do with multiple source
folders? The solution is a HashMap containing two strings:

* A name for the subfolder that each section of code will go into
* The location of each folder

I've removed the exact file path

```
		HashMap<String,String> dirList = new HashMap<String,String>();
		dirList.put("python", "Python Scripts");
		dirList.put("csharp-cplusplus", removed);
		dirList.put("android", removed);
		dirList.put("java", removed);
		dirList.put("webdev", removed);
```

And to iterate through each entry of the HashMap:

```
		Set set = dirList.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry item = (Map.Entry)it.next();
			System.out.println("Key: " + item.getKey() + "\tValue: " + item.getValue());
			File orig = new File((String) item.getValue());
			File newDir2 = new File("E:\\backups\\"+test2 + "\\" + (String) item.getKey());
```

Another change comes in the try-catch block where I pass a third variable into the copyFolder
fuction:

```
			try {
				copyFolder(orig, newDir2, (String)item.getKey());
				//copyFolder(orig,newDir2);
				System.out.println("Done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
```

## New copyFolder

The last part of the copyFolder function (everything inside the else block) stays the same,
but there is new code before it. In the section above I added a third variable to the function
call, a String:

```
	public static void copyFolder(File in, File out, String loc)
```

I'll get to the purpose of that in a minute. On the first run through I noticed that my webdev
section was pulling a lot of folders whose files I wasn't working with, so there was no need 
to bring them over. I started with an Array turned HashSet of the folders I do want to copy over:


```
		Set<String> folderList = new HashSet<String>(Arrays.asList(new String[]
				{"htdocs","css","php","js","login"}));
```

The loc variable I passed in is the key from the HashMap I built at the beginning of the program.
I use this variable to check for when the program is working with the webdev directory and to see if
the current folder is in the folderList I created above. If the program is working with the webdev
set and the current folder is in that set, it will create the folder, if not, it skips over it.

 ```
		if(in.isDirectory()){
			if (loc == "webdev" && folderList.contains(in.getName())){ //only needed for webdev
					if(!out.exists()){
						out.mkdir();
					}				
			} else {
				if(!out.exists()){
					out.mkdir();
				}
			}
```

I use a similar concept iterating through each file in the folder, again checking for the same conditions
as above.

```
			String files[] = in.list();
			for (String file : files){
				if (loc == "webdev" && folderList.contains(in.getName())){ //only needed for webdev
					File oldFile = new File(in, file);
					File newFile = new File(out,file);
					copyFolder(oldFile, newFile, loc);
				} else {
					File oldFile = new File(in, file);
					File newFile = new File(out,file);
					copyFolder(oldFile, newFile, loc);
				}
			}
		}
```

## Other plans

* Build a simple GUI with a button to start the process, display what has been done, and tell me when the whole process is done
* Read the file locations from a file instead of being hard coded into the program itself
* Let the user select which folders to backup and save that information to the external file

## Update 18 September 2016

So my plans for this little program have expanded a little and I've been busy working out the bugs in those new plans.
Among the new things I have been working on include multithreading to make the process faster and a little more complex GUI than originally planned. I was thinking about using an embedded database to store some information but realized that the program doesn't really store that much information. I am also breaking down the code so that instead of one massive file, there will be a MVC structure.

I will add in some of the new pieces when I get a chance.

## Update 18 December 2016

Well, so much for updating this every other week or so as I developed the program. That just morphed into writing the program and "I'll update the GitHub page tomorrow...".

Three months later and the program is nearly complete. Just need to run a few tests and clean up the GUI. What have I completed since September? The multithreading is working like a charm, I've built up a fairly decent GUI with tabbed pages, hidden elements that hide or reveal themselves based on user choices, and instead of saving the details of the save configurations to a text file I was able to get a simple database working (not embedded as originally hoped, but still more than just exporting objects to a file). I will be loading some of the code in the next week or so (if I remember...)
