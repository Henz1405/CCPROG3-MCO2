import java.util.Random;

import javax.swing.*;

public class battleManager {
    private char[][][]map;
    private int playerX;
    private int playerY;
    private int areaIndex;
    private String areaName;
    private Character C;
    private Enemy E;
    Random random = new Random();

    private int calculateDamage(Enemy enemy)
    {
        
        if (enemy.getEnemyType()==1)
        {
            int ENEMY_ATTACK=random.nextInt(11) + 70;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if (enemy.getEnemyType()==2)
        {
            int ENEMY_ATTACK=random.nextInt(11) + 110;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if (enemy.getEnemyType()==3)
        {
            int ENEMY_ATTACK=random.nextInt(11) + 120;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if(enemy.getEnemyType()==4)
        {
            int ENEMY_ATTACK=random.nextInt(151) + 150;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if(enemy.getEnemyType()==5)
        {
            int ENEMY_ATTACK=random.nextInt(101) + 200;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if(enemy.getEnemyType()==6)
        {
            int ENEMY_ATTACK=random.nextInt(251) + 250;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }

        return 0;
    }

    private int checkHealth(Enemy enemy, Character C)
    {
        if (C.getPLAYER_MAX_HEALTH()>0&&enemy.getENEMY_HEALTH()>0)
        {
            return 1;//continue battle
        }
        else if(enemy.getENEMY_HEALTH()<=0||C.getPLAYER_MAX_HEALTH()<=0)
        {
            if (enemy.getENEMY_HEALTH()<=0){
                return 2;// enemy died
            }
            else if(C.getPLAYER_MAX_HEALTH()<=0){
                return 3;// player died
            }
        }
        return 0;
    }

    battleManager(Character C, char[][][]map, int playerX, int playerY, int areaIndex, Enemy E){
        this.C=C;
        this.map=map;
        this.playerX=playerX;
        this.playerY=playerY;
        this.areaIndex=areaIndex;
        this.areaName=areaName;
        this.E=E;
        boolean playerTurn;
        boolean battleStart=true;
        long DODGE_RATE=0;
        int ENEMY_DAMAGE;

        while (battleStart){
            playerTurn=true;
            ENEMY_DAMAGE=calculateDamage(E);
            String choice=JOptionPane.showInputDialog("PLAYER HP: "+this.C.getPLAYER_MAX_HEALTH()+
                                    
                                        
                                "\n\n\nEnemy name: "+this.E.getENEMY_NAME()+
                                "\nEnemy Health: "+this.E.getENEMY_HEALTH()+
                                "\nEnemy PHYS_DEF: "+this.E.getPHYS_DEF()+
                                "\nEnemy SOR_DEF: "+this.E.getSOR_DEF()+
                                "\nEnemy INC_DEF: "+this.E.getINC_DEF()+
                                "\n\n\n(1) Attack\n(2) Dodge"+
                                "\nIncoming enemy attack: "+ENEMY_DAMAGE);  
            switch (choice) {
                case "1":
                    String choice2=JOptionPane.showInputDialog("(1) Physical Attack\n(2) Sorcery Attack\n(3) Incantation Attack");
                    switch (choice2){
                        case "1":
                            long PHYSICAL_DAMAGE=Math.round((this.C.getEquippedWeapon().getWeaponStr()+this.C.getPLAYER_STR())*(1-this.E.getPHYS_DEF()));
                            this.E.setENEMY_HEALTH(this.E.getENEMY_HEALTH()-PHYSICAL_DAMAGE);
                            playerTurn=false;
                            break;
                        case "2":
                            long SORCERY_DAMAGE=Math.round((this.C.getEquippedWeapon().getWeaponInt()+this.C.getPLAYER_INT())*(1-this.E.getSOR_DEF()));
                            this.E.setENEMY_HEALTH(this.E.getENEMY_HEALTH()-SORCERY_DAMAGE);
                            playerTurn=false;
                            break;
                        case "3":
                            long INCANTATION_DAMAGE=Math.round((this.C.getEquippedWeapon().getWeaponFth()+this.C.getPLAYER_FTH())*(1-this.E.getINC_DEF()));
                            this.E.setENEMY_HEALTH(this.E.getENEMY_HEALTH()-INCANTATION_DAMAGE);
                            playerTurn=false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
                    }
                    break;
                case "2":
                    DODGE_RATE=(20+((this.C.getPLAYER_END()+this.C.getEquippedWeapon().getWeaponEnd())/2)/100);
                    playerTurn=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
                    break;
            } 

            if (checkHealth(this.E, this.C)==1){
                int randomNumber = random.nextInt(100) + 1;
                if (randomNumber<=DODGE_RATE)
                {
                    System.out.println("PLAYER DODGE SUCESSFUL");
                }
                else{
                    C.setPLAYER_MAX_HEALTH(C.getPLAYER_MAX_HEALTH()-ENEMY_DAMAGE);
                    if(checkHealth(this.E, this.C)==3)
                    {
                        battleStart=false;
                        JOptionPane.showMessageDialog(null, "YOU DIED!!");
                        gameLobby gameLobby=new gameLobby(this.C);
                    }
                }
            }
            else if(checkHealth(this.E, this.C)==2){
                battleStart=false;
                int min = 50;
                int max = 150;
                int randomNumber = random.nextInt(max - min + 1) + min;
                int RUNES_GAINED=areaIndex*randomNumber;
                JOptionPane.showMessageDialog(null, "ENEMY FELLED");
                JOptionPane.showMessageDialog(null, "RUNES GAINED: "+RUNES_GAINED);
                this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+RUNES_GAINED);
                levelMovement levelMovement=new levelMovement(this.C, this.map, this.areaName, this.playerX, this.playerY, this.areaIndex);
                levelMovement.setVisible(true);
            }             
        }

    }
}
