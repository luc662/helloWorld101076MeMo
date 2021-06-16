package health;

import exceptions.NoHealthException;

public class Health {

    private int maxHealth;
    private int actualHealth;

    public Health(int actual, int max){
        this.actualHealth = actual;
        this.maxHealth = max;
    }

    public void addHealth(int addition){
        this.actualHealth = Math.min(this.maxHealth, this.actualHealth + addition);
    }

    public int getActualHealth(){
        return this.actualHealth;
    }

    public void receiveDamage(int damage){
        actualHealth = Math.max(this.actualHealth - damage, 0);
        if (actualHealth <= 0){
            throw new NoHealthException("la salud es 0");
        }
    }
}
