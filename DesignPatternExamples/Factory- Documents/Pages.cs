using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Factory__Documents
{
    class SkillsPage : IPage
    {
        public String getDescription()
        {
            return "Skills page";
        }
    }

    class EducationPage : IPage
    {
        public String getDescription()
        {
            return "Education page";
        }
    }

    class ExperiencePage : IPage
    {
        public String getDescription()
        {
            return "Experience page";
        }
    }

    class SummaryPage : IPage
    {
        public String getDescription()
        {
            return "Summary page";
        }
    }
    class IntroductionPage : IPage
    {
        public String getDescription()
        {
            return "Introduction page";
        }
    }
    class ResultsPage : IPage
    {
        public String getDescription()
        {
            return "Result page";
        }
    }
    class ConclusionPage : IPage
    {
        public String getDescription()
        {
            return "Conclusion page";
        }
    }
}
