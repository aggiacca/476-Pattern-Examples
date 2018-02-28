using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordTester
{
    interface IGUIfactory
    {
        IPanel createPanel();
        IButton createButton();
        ITextbox createTextbox();
        
    }
}
