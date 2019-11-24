package esgi.kataRPG.Core.classes;

import java.util.Objects;

public class EntitieRPG {
    private String name;
    private int health;
    private boolean alive;

    public EntitieRPG(String name) {
        this.name = name;
        this.health = 100;
        this.alive = true;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if(health <= 0){
            this.alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitieRPG that = (EntitieRPG) o;
        return health == that.health &&
                alive == that.alive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, alive);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", health=" + health;
    }
}
