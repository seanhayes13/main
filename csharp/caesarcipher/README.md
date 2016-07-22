[C# Main](https://github.com/seanhayes13/csharp)

#Caesar Cipher

This is one of those programs that I'm working on writing in multiple languages so you will likely see
it in my other repositories (if not there yet it should be soon).

For those not familiar with what a Caesar Cipher is, check out this [Wikipedia page](https://en.wikipedia.org/wiki/Caesar_cipher).
Simply put, it is a very old, simple encryption cipher that creates a new message by shifting each letter down the alphabet
a certain amount. 

With a shift of 2, anytime there is an 'a', it is now a 'c'; apple becomes crrng.

# The Code

## Main

Nothing too big going on here, just setting up the start of the code and the global alphabet
string used later on, and a simple menu.

```
namespace caesarcipher
{
    class CaesarCipher
    {
        static string alpha = "abcdefghijklmnopqrstuvwxyz ";
        static void Main(string[] args)
        {
            string choice = "0";
            while (choice != "99")
            {
                Console.WriteLine("1) One key encryption\n2) Two key encryption\n99) Quit");
                choice = Console.ReadLine();
```

This next bit of code might be a bit ugly but it works. Depending on whether the user wants to use a 
one key or two key encryption, it runs one of the two sections of code below, getting the message from
the user, the key or keys, then passes those keys into the respective method. The program exits if the
user enters 99.

The variables ikey, ikey1, and ikey2 are used for encryption while ikeyd, ikey1d, and ikey2d are used
for decryption. At this point, the decryption takes place right after encryption so I can check that 
everything works. I will be updating this code to make those seperate actions.

```
                if (choice == "1")
                {
                    Console.WriteLine("Enter a message to encrypt: ");
                    string message = Console.ReadLine();
                    Console.WriteLine("Enter a shift value: ");
                    string key = Console.ReadLine();
                    Console.WriteLine(message + " " + key);
                    int ikey = int.Parse(key);
                    string newMessage = encrypt1K(message, ikey);
                    Console.WriteLine("Encrypted message: " + newMessage);
                    Console.WriteLine("Now to try decrypting...");
                    int ikeyd = alpha.Length - ikey;
                    string decryptedMessage = encrypt1K(newMessage, ikeyd);
                    Console.WriteLine("Decrypted message: " + decryptedMessage);
                }
                else if (choice == "2")
                {
                    Console.WriteLine("Enter a message to encrypt: ");
                    string message = Console.ReadLine();
                    Console.WriteLine("Enter the first shift value: ");
                    string key1 = Console.ReadLine();
                    Console.WriteLine("Enter the second shift value: ");
                    string key2 = Console.ReadLine();
                    int ikey1 = int.Parse(key1);
                    int ikey2 = int.Parse(key2);
                    string newMessage = encrypt2K(message, ikey1, ikey2);
                    Console.WriteLine("Encrypted message: " + newMessage);
                    Console.WriteLine("Now to try decrypting...");
                    int ikey1d = alpha.Length - ikey1;
                    int ikey2d = alpha.Length - ikey2;
                    string decryptedMessage = encrypt2K(newMessage, ikey1d, ikey2d);
                    Console.WriteLine("Decrypted message: " + decryptedMessage);
                }
                else if (choice == "99")
                {
                    continue;
                }
                else
                {
                    Console.WriteLine("RTFD!");
                }
            }
        }
```

## The Moving Parts

Now for the methods that make this all work. First off, the one key encryption takes in the message
and the key for encryption. It them creates a new alphabet string by spliting the existing alphabet
string based on the key. A shift of 3 splits the alphabet at d so the shifted alphabet becomes
"defghijklmnopqrstuvwxyz abc". 

```
        static string encrypt1K(string m, int k)
        {
            string shiftedAlpha = alpha.Substring(k) + alpha.Substring(0, k);
```

Next we take the message that was passed in and convert it from a string to an array of characters, 
and creates a second array as long as the new array we just created:

```
            char[] decr = m.ToArray();
            char[] encr = new char[m.Length];
```

Now we have something to work with. A for loop goes through each entry in the decr array we created above, 
finds where that entry is in the alpha string declared back in the beginning, then gets the letter from the
shifted alphabet that is at that particular index, and sets the corresponding spot in the encr array to that
value.

Continuing to work with a shift value of 3, if the first letter is 'a', the check variable is set to 0. The 0 index
value in shiftedAlpha is 'd', so the 0 index of encr becomes 'd'.

```
            for (int ctr = 0; ctr < m.Length; ctr++)
            {
                int check = alpha.IndexOf(decr[ctr]);
                encr[ctr] = shiftedAlpha[alpha.IndexOf(decr[ctr])];
            }
            string newM = new string(encr);
            return newM;
        }
```

The method ends by converting the array back to a string and returning the string.

The two key encryption method works almost the same with the following differences:
- two keys are passed in instead of one
- during the for loop, if the ctr variable is even (0,2,4,6...) then shiftedAlpha1 is
referenced, and shiftedAlpha2 is used for odd indices

```
        static string encrypt2K(string m, int k1, int k2)
        {
            string shiftedAlpha1 = alpha.Substring(k1) + alpha.Substring(0, k1);
            string shiftedAlpha2 = alpha.Substring(k2) + alpha.Substring(0, k2);
            char[] decr = m.ToArray();
            char[] encr = new char[m.Length];
            for (int ctr = 0; ctr < m.Length; ctr++)
            {
                int check = alpha.IndexOf(decr[ctr]);
                if (ctr % 2 == 0)
                {
                    encr[ctr] = shiftedAlpha1[alpha.IndexOf(decr[ctr])];
                }
                if (ctr % 2 == 1)
                {
                    encr[ctr] = shiftedAlpha2[alpha.IndexOf(decr[ctr])];
                }
            }
            string newM = new string(encr);
            return newM;
        }
    }
}
```

Like I said above, I have a similar program written in Java, JavaScript, and Python that I had written previously.
I will add links to those when I get them loaded.
