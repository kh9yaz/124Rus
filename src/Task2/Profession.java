package Task2;

public class Profession {
    private String name;
    private double averageSalary;
    private int averageAge;
    private int countPeople;
    private String category;


    public Profession(String name, double averageSalary, int averageAge, int countPeople, String category) {
        setName(name);
        setCategory(category);
        setCountPeople(countPeople);
        setAverageSalary(averageSalary);
        setAverageAge(averageAge);
    }

    public Profession() {
    }

    public double calcTotalSalary() {
        return averageSalary * countPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        if (averageSalary > 0)
            this.averageSalary = averageSalary;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        if (averageAge > 0 && averageAge < 100)
            this.averageAge = averageAge;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        if (countPeople > 0)
            this.countPeople = countPeople;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
