using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordTester
{
    class Program
    {
        static void Main(string[] args)
        {

            String projDir = Directory.GetParent(Directory.GetCurrentDirectory()).Parent.FullName;
            String path = projDir + "\\testing-config.txt";

            System.IO.StreamReader file = new System.IO.StreamReader(path);

            String line;
            List<String> testingInputs = new List<String>();

            while ((line = file.ReadLine()) != null)
            {
                testingInputs.Add(line.Trim());
            }
            file.Close();  
            
            foreach(String test in testingInputs){
                
                IGUIfactory factory = null;
                
                switch(test){
                    case "Word00":
                        factory = Word00Factory.getInstance();
                        break;
                    case "Word10":
                        factory = Word10Factory.getInstance();
                        break;
                    case "Word18":
                        factory = Word18Factory.getInstance();
                        break;
                    case "Word90":
                        factory = Word90Factory.getInstance();
                        break;
                    default:
                        Console.WriteLine("line not recognized");
                        break;
                }

                if (factory != null){
                    IButton button = factory.createButton();
                    IPanel panel = factory.createPanel();
                    ITextbox textbox = factory.createTextbox();

                    Console.WriteLine("Testing " + test + ":" + button.getDescription() + ", " + panel.getDescription() + ", " + textbox.getDescription());
                }
                else { 
                }


            }


            // pause
            Console.ReadKey();
        }
    }
}
