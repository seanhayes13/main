[Back to Java Main](../)

# Caesar Cipher

This is a Java program based on the same concept that I have also written in [Python](../../python/caesarcipher), [JavaScript](../../webdev/caesarCipher), and [C#](../../csharp/caesarcipher). The code allows users to enter a message, select whether they want to encrypt with one key or two, returns the encrypted message. There is also an option to decrypt a message with a known key or set of keys, and to decrypt a message without knowing which key or keys were used. There are limitations to the unknown key decryption part of the code that I will go over in those sections.

## The Code

The first 200 lines of the main builds the GUI that I will decribe at a later time, for now I'm going to go over the meat and potatoes found in the last half of that file plus the code in the event file.

### Encrypt With One Key

If the user is encrypting a message, after entering in the message and the key, the actionPerformed function in the event file calls the encrypt function from the main file, passing in the message and the key.

The encrypt function creates an empty string, converts to lower case (plans are in the works to work with messages as they are, upper and lower case, numbers, and other symbols found on a standard QWERTY keyboard):

```
public String encrypt(int key, String input){
	String encr = "";
	String lowerMsg = input.toLowerCase();
```

Next step is to create an adjusted alphabet. This is done by taking a string containing the letters of the alphabet and splicing it based on the key the user selects:

```
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	String shiftedAlphabet = shiftedAlpha(key);
```

The for loop goes through the lowerMsg string created earlier taking one character at a time. For each character the function finds that character's index in the alphabet string (a = 0, b = 1, c = 2, etc). If the number is a negative 1, that means it wasn't in the alphabet string, then the selected character is added to the encr string. For now this means anything other than the 26 letters in the alphabet (yes, I know this doesn't make much sense for an encryption program and that is something I plan to address in further versions of the code).

If the number is not negative 1 that means the character was found so the function finds the character at that index in the shifted alphabet string and add that to the encr string. This continues for the length of the lowerMsg string. The resulting encr string is returned and the GUI prints it out.

```
	for(int ctr = 0; ctr < lowerMsg.length();ctr++){
		char currChar = lowerMsg.charAt(ctr);
		int idx = alphabet.indexOf(currChar);
		if(idx==-1){
			encr+=currChar;
		}
		if(idx!=-1){
			char newChar = shiftedAlphabet.charAt(idx);
			encr += newChar;
		}
	}
	return encr;
}
```

More coming soon
