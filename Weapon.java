public class Weapon {
    private String weaponName;
    private int weaponDex;
    private int weaponHp;
    private int weaponEnd;
    private int weaponStr;
    private int weaponInt;
    private int weaponFth;

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

    public int getWeaponDex() {
        return weaponDex;
    }

    public int getWeaponEnd() {
        return weaponEnd;
    }

    public int getWeaponFth() {
        return weaponFth;
    }

    public int getWeaponHp() {
        return weaponHp;
    }
    
    public int getWeaponInt() {
        return weaponInt;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getWeaponStr() {
        return weaponStr;
    }
    

}

