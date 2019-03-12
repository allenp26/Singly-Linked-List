import java.util.*;

public class A2 {
    private SLL <Food> foodSLL;

    /**
     * main class for the program which create
     * instances of the class and call the run method
     *
     * @param args
     */
    public static void main(String[] args){
        A2 aTwo = new A2();
        aTwo.run();
    }

    /**
     * method to call three main methods in order
     * for the program to run
     */
    private void run(){
        LoadBasicFood();
        foodProcessor();
        resultPrinter();
    }

    /**
     * main processing method to handle inputs and call
     * different methods to handle tasks
     *
     */
    private void foodProcessor(){
        Scanner in = new Scanner(System.in);
        boolean foodInRecipe;

        while (in.hasNext()){
            String ingredient;
            String goodIngredient;

            if (in.nextLine().equals("---")) {
                foodInRecipe = true;
                while (foodInRecipe) {

                    ingredient = in.nextLine().toLowerCase().trim();
                    if (!ingdtInList(ingredient)) {
                        goodIngredient = pluralChecker(ingredient.substring(ingredient.lastIndexOf(' ') + 1));
                        addIngredient(goodIngredient);
                    }
                    if (ingredient.equals("---")) {
                        foodInRecipe = false;
                    }
                }

            }
        }


    }


    /**
     * find the name of ingredient from the list
     *
     * @param fName string of ingredient name
     * @return true if found in the list
     */
    private boolean ingdtInList (String fName) {
        for (int i = 0; i < foodSLL.size(); i++) {
            if (fName.substring(fName.lastIndexOf(' ') +1).equals("mangosteen")) {
                if (fName.equals(foodSLL.get(i).getFoodName())) {
                    findIngredient(foodSLL.get(i).getFoodName());

                    return true;
                }
            }
            else  {
                if (fName.contains(foodSLL.get(i).getFoodName())) {
                    findIngredient(foodSLL.get(i).getFoodName());

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * checks the name of the ingredient to see if it is plural
     * if it is, remove es or s from the name
     *
     * @param name string of the ingredient name
     * @return modified name of ingredient
     */
    private String pluralChecker(String name) {
        String foodName = "";
        if (!name.equals("---") && !name.equals("")) {
            if (name.endsWith("s") && !name.endsWith("ss")) {
                if (name.endsWith("es") ) {
                    foodName = name.substring(0, name.length()-2);

                    return foodName;
                }
                foodName = name.replaceAll("s$","");
            }
            else {
                foodName = name;
            }
        }
        return foodName;
    }


    /**
     * find the existing ingredient in the list
     * if it is existent, add one to the frequency
     *
     * @param ingdt string of ingredient name
     * @return true if name exists in the list
     */
    private boolean findIngredient(String ingdt) {

        boolean found = false;
        int i = 0;

        while (i < foodSLL.size() && !found) {
            if (foodSLL.get(i).getFoodName().equals(ingdt)) {
                foodSLL.get(i).setFoodFreq(foodSLL.get(i).getFoodFreq()+1);

                found = true;
            }
            i++;
        }

        return found;
    }

    /**
     * add ingredient to the list if it is not already in the list
     *
     * @param fdName string of the name of the ingredient
     */
    private void addIngredient(String fdName) {
        if (!(fdName.equals(""))) {
            if (!findIngredient(fdName)) {
                foodSLL.add(new Food(fdName, 1));

            }
        }
    }


    /**
     * prints the number of ingredients in the recipe book
     * creates two local lists to store the newly sorted ingredients
     * by name and frequency
     */
    private void resultPrinter() {
        int TOP_TEN = 10;
        int numOfIngdt = 0;
        int ingdtPrinted = 0;

        SLL<Food> foodListFreq = new SLL<>();
        for (int i = 0; i < foodSLL.size(); i++) {
            if (foodSLL.get(i).getFoodFreq() != 0) {
            	Food ingdt = foodSLL.get(i);
                foodListFreq.sortFoodFreq(ingdt, Comparator.comparing(Food::getFoodFreq).reversed().thenComparing(Food::getFoodName));
            }
        }

        SLL<Food> foodListName = new SLL<>();
        for (int i = 0; i < foodSLL.size(); i++) {
            if (foodSLL.get(i).getFoodFreq() != 0) {
                Food food = foodSLL.get(i);
                foodListName.sortFoodFreq(food, Comparator.comparing(Food::getFoodName));
            }
        }



        for (Food food: foodListFreq) {
            if (food.getFoodFreq() != 0) {
                numOfIngdt++;
            }
        }


        System.out.println("The recipe book has " +numOfIngdt+ " different ingredients");
        System.out.println
        ("---------------------------------------");

        if (numOfIngdt < 10) {
            System.out.println("Top " +numOfIngdt+ " ingredients, from most common to least common");
            for (Food food : foodListFreq) {
            	System.out.println(food.toString());
            }

        }
        else {
            System.out.println("Top 10 ingredients, from most common to least common");
            for (int i = 0; i < TOP_TEN; i++) {
            	System.out.println(foodListFreq.get(i).toString());
            }

        }



        System.out.println("---------------------------------------");
        System.out.println("The complete list of foods in the recipe book, in alphabetical order");

        for (Food food : foodListName) {
            System.out.println(food.toString());
        }

    }

    /**
     * add the basic ingredients to the SLL
     *
     */
    private void LoadBasicFood() {
        foodSLL = new SLL<>();

        foodSLL.add(new Food("baking powder", 0));
        foodSLL.add(new Food("baking powder", 0));
        foodSLL.add(new Food("baking soda", 0));
        foodSLL.add(new Food("cheese", 0));
        foodSLL.add(new Food("broth", 0));
        foodSLL.add(new Food("tomatopaste", 0));
        foodSLL.add(new Food("tomatosauce", 0));
        foodSLL.add(new Food("tomato", 0));
        foodSLL.add(new Food("flour", 0));
        foodSLL.add(new Food("egg", 0));
        foodSLL.add(new Food("garlic", 0));
        foodSLL.add(new Food("rice", 0));
        foodSLL.add(new Food("onion", 0));
        foodSLL.add(new Food("salt", 0));
        foodSLL.add(new Food("pepper", 0));
        foodSLL.add(new Food("vinegar", 0));
        foodSLL.add(new Food("carrot", 0));
        foodSLL.add(new Food("sweetpotato", 0));
        foodSLL.add(new Food("potato", 0));
        foodSLL.add(new Food("cream", 0));
        foodSLL.add(new Food("milk", 0));
        foodSLL.add(new Food("bean", 0));
        foodSLL.add(new Food("greenbean", 0));
        foodSLL.add(new Food("beef", 0));
        foodSLL.add(new Food("chicken", 0));
        foodSLL.add(new Food("cumin", 0));
        foodSLL.add(new Food("basil", 0));
        foodSLL.add(new Food("oregano", 0));
        foodSLL.add(new Food("oil", 0));
        foodSLL.add(new Food("fish", 0));
    }
}
