package encapsulation.assigment_problems;

public class HealthBar {

    private int health;
    private final int maxHealth;

    public HealthBar(int maxHealth) {
        if (maxHealth < 1) {
            this.maxHealth = 1;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;

            if (health < 0) {
                health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += amount;

            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        HealthBar player = new HealthBar(100);

        System.out.println("Initial Health: " + player.getHealth());

        player.takeDamage(30);
        System.out.println("After Damage: " + player.getHealth());

        player.heal(20);
        System.out.println("After Healing: " + player.getHealth());

        player.takeDamage(200);
        System.out.println("After Heavy Damage: " + player.getHealth());

        player.heal(50);
        System.out.println("After Healing from Zero: " + player.getHealth());
    }
}