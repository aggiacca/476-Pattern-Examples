﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Factory__Documents
{

    abstract class Document
    {
        public List<IPage> pages = new List<IPage>();

        public Document()
        {
            this.createPages();
        }

        public abstract void createPages();
        public abstract string getDocName();

    }


    interface IPage
    {
        String getDescription();
    }


    class Resume: Document{

        public override void createPages()
        {
            pages.Add(new SkillsPage());
            pages.Add(new EducationPage());
            pages.Add(new ExperiencePage());
        }

        public override string getDocName()
        {
            return "Resume";
        }
    }

    class Report : Document
    {

        public override void createPages()
        {
            pages.Add(new SummaryPage());
            pages.Add(new IntroductionPage());
            pages.Add(new ResultsPage());
            pages.Add(new ConclusionPage());
        }

        public override string getDocName()
        {
            return "Report";
        }
    }




    class Program
    {
        static void Main(string[] args)
        {

            Document resume1 = new Resume();
            Console.WriteLine(resume1.getDocName());
            foreach(IPage page in resume1.pages){
                Console.WriteLine(page.getDescription());
            }

            Console.ReadKey();
        }
    }
}
