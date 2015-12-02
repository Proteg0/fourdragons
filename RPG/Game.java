import java.io.*;
/**
 * This class holds the functionality of four dragons rpg.
 * All calls from the GUI will pass through this class.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
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
        player = new Player("Player 1",1);

    }

    /**
     * Creates a new custom player.
     */
    public void newPlayer(String s, int lvl)
    {
        player = new Player(s,lvl);

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

    //--------------------------------------------SAVE----------------------------------------------
    /**
     * @return Boolean attempts to save the game and returns if successful. 
     */
    public Boolean saveGame()
    {
        boolean saved;
        try{
            FileWriter writer = new FileWriter(player.getName()+".txt");
            writer.write(player.getName()+","+player.getLevel()+","+player.getSkills());
            writer.close();
            saved = true;
        }
        catch(IOException e){
            saved = false;
        }
        return saved;
    }
    
    /**
     * @return String attempts to load the game and returns if player info if successful. 
     * @param String the name of the file.
     */
    public String loadGame(String s)
    {
        String load;
        try{
            BufferedReader read = new BufferedReader(new FileReader(s+".txt"));
            String line = read.readLine();
            read.close();
            load = line;
        }
        catch(FileNotFoundException e){
            load = null;
        }
        catch(IOException e){
            load = null;
        }
        return load;
    }
    
    /**
     * Sets the skills of the players, primarily after a load of saved data.
     * @param String the name of the first skill.
     * @param String the name of the second skill.
     * @param String the name of the third skill.
     * @param String the name of the fourth skill.
     * @return boolean true if all skills were set successfully.
     */
    public boolean setPlayerSkills(String one, String two, String fire, String frost)
    {
        boolean set,oh,th,fi,fr;
        set = false;
        oh= player.setOneSkill(one);
        th=player.setTwoSkill(two);
        fi=player.setFireSkill(fire);
        fr=player.setFrostSkill(frost);
        if(oh&&th&&fi&&fr)
        {set = true;}
        return set;
    }
}
