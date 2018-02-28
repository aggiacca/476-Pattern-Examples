using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordTester
{
   interface IPanel
    {
        String getDescription();
    }

    interface IButton
    {
        String getDescription();
    }

    interface ITextbox
    {
        String getDescription();
    }
}
