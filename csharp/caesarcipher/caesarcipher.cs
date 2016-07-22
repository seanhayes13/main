using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

        static string encrypt1K(string m, int k)
        {
            string shiftedAlpha = alpha.Substring(k) + alpha.Substring(0, k);
            Console.WriteLine(shiftedAlpha);
            char[] decr = m.ToArray();
            char[] encr = new char[m.Length];
            for (int ctr = 0; ctr < m.Length; ctr++)
            {
                int check = alpha.IndexOf(decr[ctr]);
                encr[ctr] = shiftedAlpha[alpha.IndexOf(decr[ctr])];
                //Console.WriteLine("original: " + decr[ctr] + " shifted: " + shiftedAlpha[alpha.IndexOf(decr[ctr])]);
            }
            string newM = new string(encr);
            return newM;
        }

        static string encrypt2K(string m, int k1, int k2)
        {
            string shiftedAlpha1 = alpha.Substring(k1) + alpha.Substring(0, k1);
            //Console.WriteLine(shiftedAlpha1);
            string shiftedAlpha2 = alpha.Substring(k2) + alpha.Substring(0, k2);
            //Console.WriteLine(shiftedAlpha2);
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
