using System;
using System.Text.RegularExpressions;

namespace variable_numero
{
    class Program
    {
        static void Main()
        {
            try
            {
                //Read a word
                Console.Write("\nInput a word: ");
                string word = Console.ReadLine();

                //Send word to the method VariableOrNumber
                VariableOrNumber(word);

                //New input?
                Console.Write("\nNew input?[y/n]: ");
                char answer = Convert.ToChar(Console.ReadLine());
                if (answer == 'n')
                {
                    Environment.Exit(0);
                }
                else
                {
                    Main();
                }
            }
            catch (Exception)
            {
                Console.Write("\n\nINPUT ERROR\nPress a key...");
                Console.ReadKey();
                Main();
            }
        }

        /// <summary>
        /// Method who determines if a word is a variable or a number
        /// </summary>
        /// <param name="word">Word to evaluate</param>
        /// <returns></returns>
        static void VariableOrNumber(string word)
        {
            //Result
            string result = "";

            //Valid symbol sets
            string minus = "a-z";
            string mayus = "A-Z";
            string digits = "0-9";

            //Regular expression for variables
            //Regex variable_regex = new Regex(@"^[a-zA-Z][a-zA-Z0-9]*$");
            Regex variable_regex = new Regex(@"^[" + minus + mayus + "][" + minus + mayus + digits + "]*$");

            //Regular expression for natural numbers
            string natural = "[" + digits + "]+";
            //Regular expression for rational numbers
            string fraction = "([,|.]" + natural + ")?";
            //Regular expression for scientific notation
            string scientific_not = "([e]([+|-])?" + natural + ")?";

            //Regular expression for numbers
            Regex number_regex = new Regex(@"^" + natural + fraction + scientific_not + "$");

            //Check if the 'match' matches the original word
            if (variable_regex.IsMatch(word))
            {
                result = "variable";
            }
            else if (number_regex.IsMatch(word))
            {
                result = "number";
            }
            else
            {
                result = "no coincidence";
            }

            //Print result
            Console.WriteLine("The word " + word + " is a " + result + ".");
        }
    }
}
