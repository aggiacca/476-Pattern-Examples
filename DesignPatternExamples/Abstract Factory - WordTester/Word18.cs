using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordTester
{

    class Word18Factory : IGUIfactory
    {


        private static List<Word18Factory> instances;

        private Word18Factory(){}

        public static Word18Factory getInstance(){
            if (instances == null)
            {
                
                instances = new List<Word18Factory>();

                Word18Factory instance1 = new Word18Factory();
                instances.Add(instance1);

                return instance1;
            }else if(instances.Count < 2 ){
                Word18Factory instance2 = new Word18Factory();
                instances.Add(instance2);

                return instance2;
            }
            else
            {
                Console.WriteLine("Warning: Already two instances of Word18. Returning first instance.");
                return instances[0];
            }
        }

        public IButton createButton()
        {
            return new Word18Button();
        }
        public IPanel createPanel()
        {
            return new Word18Panel();
        }
        public ITextbox createTextbox()
        {
            return new Word18Textbox();
        }

    }

    class Word18Button : IButton
    {
        public String getDescription()
        {
            return ("Word18 Button");
        }
    }

    class Word18Panel : IPanel
    {
        public String getDescription()
        {
            return ("Word18 Panel");
        }
    }

    class Word18Textbox : ITextbox
    {
        public String getDescription()
        {
            return ("Word18 Textbox");
        }
    }
}
