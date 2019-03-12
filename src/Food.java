import java.util.Comparator;


/**
 * Food class to store the food name and the frequency of food.
 * Class implements Comparable to compare food names and frequency of food
 * in order to sort the list in alphabetical order and ascending order.
 */
public class Food implements Comparable<Food>{

    private String foodName;
    private int foodFreq;

    public int compareTo(Food f) {
        if (this.foodFreq > f.foodFreq) {
            return 1;
        }
        else {
            return foodName.compareTo(f.foodName);
        }
    }


    /**
     * Default constructor, which sets foodName to "" and foodFreq to 0
     *
     */
    public Food()
    {
        foodName = "";
        foodFreq = 0;
    }

    /**
     *
     * Constructor is used to load the basic food list and to add new
     * ingredients to the ArrayList
     *
     * @param fdName gets input from file and set foodName
     * @param fdFreq gets input from file and set foodFreq
     */
    public Food(String fdName, int fdFreq)
    {
        foodName = fdName;
        foodFreq = fdFreq;
    }

    /**
     * Compare names in the foodList in alphabetical order
     */
    public static Comparator<Food> NameComparator  = new Comparator<Food>(){
        @Override
        public int compare(Food f1, Food f2) {

            return f1.getFoodName().compareTo(f2.getFoodName());
        }
    };

    /**
     * compare foodFreq between two foods and return appropriate integer
     * based on the results. (ex. -1, 1, 0)
     */
    public static Comparator<Food> FreqComparator = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {

            if (f1.getFoodFreq() < f2.getFoodFreq()) return -1;
            if (f1.getFoodFreq() > f2.getFoodFreq()) return 1;
            else return 0;
        }
    };

    public static Comparator<Food> lengthComparator = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            if (f1.getFoodName().length() < f2.getFoodName().length()) return -1;
            if (f1.getFoodName().length() > f2.getFoodName().length()) return 1;
            else return 0;
        }
    };

    public boolean equals (Food f) {
        if (f == this) {
            return true;
        }
        if (!(f instanceof Food)) {
            return false;
        }

        Food fdName = f;

        return f.equals(fdName);
    }

    //getters
    public int getFoodFreq(){
        return foodFreq;
    }

    public String getFoodName() {
        return foodName;
    }

    //setter
    public void setFoodFreq(int foodFreq) {
        this.foodFreq = foodFreq;
    }

    public String toString()
    {
        return "("+getFoodName()+ ", " +getFoodFreq()+ ")";
    }
}
