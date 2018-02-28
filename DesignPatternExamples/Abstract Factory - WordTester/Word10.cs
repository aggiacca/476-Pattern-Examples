using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordTester
{

    class Word10Factory : IGUIfactory
    {

        private static List<Word10Factory> instances;

        private Word10Factory(){}

        public static Word10Factory getInstance(){
            if (instances == null)
            {
                
                instances = new List<Word10Factory>();

                Word10Factory instance1 = new Word10Factory();
                instances.Add(instance1);

                return instance1;
            }else if(instances.Count < 2 ){
                Word10Factory instance2 = new Word10Factory();
                instances.Add(instance2);

                return instance2;
            }
            else
            {
                Console.WriteLine("Warning: Already two instances of Word10. Returning first instance.");
                return instances[0];
            }
        }

        public IButton createButton()
        {
            return new Word10Button();
        }
        public IPanel createPanel()
        {
            return new Word10Panel();
        }
        public ITextbox createTextbox()
        {
            return new Word10Textbox();
        }

    }

    class Word10Button : IButton
    {
        public String getDescription()
        {
            return ("Word10 Button");
        }
    }

    class Word10Panel : IPanel
    {
        public String getDescription()
        {
            return ("Word10 Panel");
        }
    }

    class Word10Textbox : ITextbox
    {
        public String getDescription()
        {
            return ("Word10 Textbox");
        }
    }
}
