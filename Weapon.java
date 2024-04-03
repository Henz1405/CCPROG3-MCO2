/**
 * Represents a weapon in the game, with various stats.
 */
public class Weapon {
    /** The name of the weapon. */
    private String weaponName;

    /** The dexterity required to wield the weapon. */
    private int weaponDex;

    /** The health points bonus provided by the weapon. */
    private int weaponHp;

    /** The endurance points bonus provided by the weapon. */
    private int weaponEnd;

    /** The strength bonus provided by the weapon. */
    private int weaponStr;

    /** The intelligence bonus provided by the weapon. */
    private int weaponInt;

    /** The faith bonus provided by the weapon. */
    private int weaponFth;

    /**
     * Initializes the weapon with the given attributes.
     * @param weaponName the name of the weapon
     * @param weaponDex the dexterity required to wield the weapon
     * @param weaponHp the health points bonus provided by the weapon
     * @param weaponEnd the endurance points bonus provided by the weapon
     * @param weaponStr the strength bonus provided by the weapon
     * @param weaponInt the intelligence bonus provided by the weapon
     * @param weaponFth the faith bonus provided by the weapon
     */
    public void initializeWeapon(String weaponName, int weaponDex, int weaponHp, int weaponEnd, int weaponStr, int weaponInt, int weaponFth)
    {
        this.weaponName=weaponName;
        this.weaponDex=weaponDex;
        this.weaponHp=weaponHp;
        this.weaponEnd=weaponEnd;
        this.weaponStr=weaponStr;
        this.weaponInt=weaponInt;
        this.weaponFth=weaponFth;
    }

    /**
     * Returns the dexterity required to wield the weapon.
     * @return the dexterity required
     */
    public int getWeaponDex() {
        return weaponDex;
    }

    /**
     * Returns the endurance points bonus provided by the weapon.
     * @return the endurance points bonus
     */
    public int getWeaponEnd() {
        return weaponEnd;
    }

    /**
     * Returns the faith bonus provided by the weapon.
     * @return the faith bonus
     */
    public int getWeaponFth() {
        return weaponFth;
    }

    /**
     * Returns the health points bonus provided by the weapon.
     * @return the health points bonus
     */
    public int getWeaponHp() {
        return weaponHp;
    }

    /**
     * Returns the intelligence bonus provided by the weapon.
     * @return the intelligence bonus
     */
    public int getWeaponInt() {
        return weaponInt;
    }

    /**
     * Returns the name of the weapon.
     * @return the weapon name
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     * Returns the strength bonus provided by the weapon.
     * @return the strength bonus
     */
    public int getWeaponStr() {
        return weaponStr;
    }
}
