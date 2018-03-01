using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BestCafe
{

    public interface ICoffee
    {
            double getCost();
            String getIngredients();
    }


    public class SimpleCoffee : ICoffee
    {
        public double getCost(){
            return 1;
        }

        public String getIngredients()
        {
            return "Coffee";
        }
    }

    // note impletments ICoffe
    public abstract class CoffeeDecorator : ICoffee
    {
        protected ICoffee decoratedCoffee;

        public CoffeeDecorator(ICoffee c)
        {
            this.decoratedCoffee = c;
        }

        public virtual double getCost()
        {
            //need this since it must implement ICoffee
            return decoratedCoffee.getCost();
        }

        //need virtual here otherwise just returns baseComponent (SimpleCofee)
        public virtual  String getIngredients()
        {
            return decoratedCoffee.getIngredients();
        }
    }

    public class WithMilk : CoffeeDecorator{
        public WithMilk(ICoffee c)
            : base(c)
        {

        }

        public override double getCost()
        {
            return base.getCost() + 0.5;
        }

        public override  String getIngredients()
        {
            return base.getIngredients() + ", Milk";
        }

    }

    public class WithWhippedCream : CoffeeDecorator
    {
        public WithWhippedCream(ICoffee c)
            : base(c)
        {

        }

        public override double getCost()
        {
            return base.getCost() + 1.0;
        }

        public override String getIngredients()
        {
            return base.getIngredients() + ", Whipped Cream";
        }

    }


    class Program
    {
        public static void printCoffeeInfo(ICoffee c){
            Console.WriteLine("Current Coffe: " + c.getCost() + ". Ingredients: " + c.getIngredients());
        }

        static void Main(string[] args)
        {
            ICoffee c = new SimpleCoffee();
            printCoffeeInfo(c);

            var coffeeMilk = new WithMilk(c);
            printCoffeeInfo(coffeeMilk);

            var coffeeCreamMilk = new WithWhippedCream(coffeeMilk);
            printCoffeeInfo(coffeeCreamMilk);

            Console.ReadKey();


        }
    }
}
