using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordTester
{

    class Word00Factory : IGUIfactory
    {
        private static List<Word00Factory> instances;

        private Word00Factory(){}

        public static Word00Factory getInstance(){
            if (instances == null)
            {
                
                instances = new List<Word00Factory>();

                Word00Factory instance1 = new Word00Factory();
                instances.Add(instance1);

                return instance1;
            }else if(instances.Count < 2 ){
                Word00Factory instance2 = new Word00Factory();
                instances.Add(instance2);

                return instance2;
            }
            else
            {
                Console.WriteLine("Warning: Already two instances of Word00. Returning first instance.");
                return instances[0];
            }
        }
        
        public IButton createButton()
        {
            return new Word00Button();
        }
        public IPanel createPanel()
        {
            return new Word00Panel();
        }
        public ITextbox createTextbox()
        {
            return new Word00Textbox();
        }

    }

    class Word00Button : IButton
    {
        public String getDescription()
        {
            return ("Word00 Button");
        }
    }

    class Word00Panel : IPanel
    {
        public String getDescription()
        {
            return ("Word00 Panel");
        }
    }

    class Word00Textbox : ITextbox
    {
        public String getDescription()
        {
            return ("Word00 Textbox");
        }
    }
}
