
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    private MapCase globalMap;
    private ItemList allItems;

    private Player player;
    private int difficulty;

    public Game()
    {
        globalMap = new MapCase();
        allItems = new ItemList();
        newPlayer();
        difficulty = 0;
    }

    //-----------------------------------------MOVEMENT-------------------------------  
    /**
     * Moves the player to the east.
     * @return String the description of the new location.
     */
    public String moveEast()
    {
        globalMap.east();
        moveHeal();
        return getInfo();
    }

    /**
     * Moves the player to the west.
     * @return String the description of the new location.
     */
    public String moveWest()
    {
        globalMap.west();
        moveHeal();
        return getInfo();
    }

    /**
     * Moves the player to the north.
     * @return String the description of the new location.
     */
    public String moveNorth()
    {
        globalMap.north();
        moveHeal();
        return getInfo();
    }

    /**
     * Moves the player to the south.
     * @return String the description of the new location.
     */
    public String moveSouth()
    {
        globalMap.south();
        moveHeal();
        return getInfo();
    }

    /**
     * Gets the current position.
     * @return String the coordinates of current location.
     */
    public String getCoord()
    {
        return globalMap.getX()+","+globalMap.getY();
    }

    /**
     * Heals the player over time.
     */
    public void moveHeal()
    {
        player.healDamage(player.getLevel());
    }

    //-----------------------------------------COMBAT-------------------------------  

    /**
     * Attacks the enemy with selected ability.
     * @param int the damage inflicted on the enemy.
     */
    public int attackOne()
    {
        int dmg = player.getOneDmg();
        globalMap.currentLocation.dealDamage(dmg);
        if(globalMap.currentLocation.hasMonster())
        {
            endTurn();
        }
        return dmg;
    }

    /**
     * Attacks the enemy with selected ability.
     * @param int the damage inflicted on the enemy.
     */
    public int attackTwo()
    {
        int dmg = player.getTwoDmg();
        globalMap.currentLocation.dealDamage(dmg);
        if(globalMap.currentLocation.hasMonster())
        {
            endTurn();
        }
        return dmg;
    }

    /**
     * Attacks the enemy with selected ability.
     * @param int the damage inflicted on the enemy.
     */
    public int spellFire()
    {
        int dmg = player.getFireDmg();
        globalMap.currentLocation.dealDamage(dmg);
        if(globalMap.currentLocation.hasMonster())
        {
            endTurn();
        }
        return dmg;
    }

    /**
     * Attacks the enemy with selected ability.
     * @param int the damage inflicted on the enemy.
     */
    public int spellFrost()
    {
        int dmg = player.getFrostDmg();
        globalMap.currentLocation.dealDamage(dmg);
        if(globalMap.currentLocation.hasMonster())
        {
            endTurn();
        }
        return dmg;
    }

    /**
     * Signals the npc to take its turn.
     */
    public void endTurn()
    {
        //Player has made a turn choice and now the computer reacts.
        int dmgRec = globalMap.currentLocation.getMobDmg();
        player.takeDamage(dmgRec);
    }

    /**
     * Checks to see if the combat is over.
     */
    public boolean endCombat()
    {
        boolean end = false;
        if(!globalMap.currentLocation.hasMonster())
        {end = true;}
        return end; 
    }
    
    /**
     * Checks to see if the player is alive.
     */
    public boolean isAlive()
    {
        boolean alive = true;
        if(player.getCurrentHealth()<=0)
        {alive = false;}
        return alive; 
    }

    //-----------------------------------------EAST FUNCTIONS-------------------------------  
    /**
     * Returns the info on the room.
     */
    public String getInfo()
    {

        return globalMap.getInfo();
    }

    /**
     * Returns if there is a monster in the current room.
     */
    public boolean hasMonster()
    {
        return globalMap.hasMonster();

    }

    //-----------------------------------------PLAYER LEVELING-------------------------------
    /**
     * Creates a new default player.
     */
    public void newPlayer()
    {
        player = new Player("Player 1",20,1);

    }

    /**
     * Creates a new custom player.
     */
    public void newPlayer(String s, int hp, int lvl)
    {
        player = new Player(s,hp,lvl);

    }

    //-----------------------------------------PLAYER STATS-------------------------------
    
    /**
     * @return String the player name.
     */
    public String playerName()
    {return player.getName();}

    /**
     * @return int the player level.
     */
    public int playerLevel()
    {return player.getLevel();}

    /**
     * @return int the player current hitpoints.
     */
    public int playerCurrentHP()
    {return player.getCurrentHealth();}

    /**
     * @return int the player maximum hitpoints.
     */
    public int playerMaxHP()
    {return player.getMaxHealth();}
    
    
    //-----------------------------------------ENEMY STATS-------------------------------
    
    /**
     * @return String the player name.
     */
    public String enemyName()
    {return globalMap.currentLocation.getMobName();}

    /**
     * @return int the player level.
     */
    public int enemyLevel()
    {return globalMap.currentLocation.getMobLevel();}

    /**
     * @return int the player current hitpoints.
     */
    public int enemyCurrentHP()
    {return globalMap.currentLocation.getMobHealth();}

    /**
     * @return int the player maximum hitpoints.
     */
    public int enemyMaxHP()
    {return globalMap.currentLocation.getMobMaxHealth();}


    //-----------------------------------------HARD MODE------------------------------------
    /**
     * @return int the difficulty level.
     */
    public int getDifficulty()
    {
        return difficulty;
    }

    /**
     * Sets the difficulty to 1.
     */
    public void setHard()
    {
        difficulty = 1;
    }

    /**
     * Sets the difficulty to 0.
     */
    public void setNormal()
    {
        difficulty = 0;
    }

    /**
     * Sets the difficulty to -1.
     */
    public void setEasy()
    {
        difficulty = -1;
    }

}
