using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordTester
{

    class Word90Factory : IGUIfactory
    {
        private static List<Word90Factory> instances;

        private Word90Factory(){}

        public static Word90Factory getInstance(){
            if (instances == null)
            {
                
                instances = new List<Word90Factory>();

                Word90Factory instance1 = new Word90Factory();
                instances.Add(instance1);

                return instance1;
            }else if(instances.Count < 2 ){
                Word90Factory instance2 = new Word90Factory();
                instances.Add(instance2);

                return instance2;
            }
            else
            {
                Console.WriteLine("Warning: Already two instances of Word90. Returning first instance.");
                return instances[0];
            }
        }


        public IButton createButton()
        {
            return new Word90Button();
        }
        public IPanel createPanel()
        {
            return new Word90Panel();
        }
        public ITextbox createTextbox()
        {
            return new Word90Textbox();
        }

    }

    class Word90Button : IButton
    {
        public String getDescription()
        {
            return ("Word90 Button");
        }
    }

    class Word90Panel : IPanel
    {
        public String getDescription()
        {
            return ("Word90 Panel");
        }
    }

    class Word90Textbox : ITextbox
    {
        public String getDescription()
        {
            return ("Word90 Textbox");
        }
    }
}
