package marvin.demo.bundle.zombie.model;

public class Survivor {
    
    private String name;
    
    private int strength;
    private int hp;
    
    private double hunger;
    private double madness;
    private double stress;

    public Survivor() {
    }

    public Survivor(String name, int strength, int hp, double hunger, double madness, double stress) {
        this.name = name;
        this.strength = strength;
        this.hp = hp;
        this.hunger = hunger;
        this.madness = madness;
        this.stress = stress;
    }

    public int getHp() {
        return hp;
    }

    public double getHunger() {
        return hunger;
    }

    public double getMadness() {
        return madness;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public double getStress() {
        return stress;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public void setMadness(double madness) {
        this.madness = madness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setStress(double stress) {
        this.stress = stress;
    }
}
