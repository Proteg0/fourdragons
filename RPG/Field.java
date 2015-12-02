import java.util.ArrayList;
/**
 * Abstract class Field - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Field
{
    // COORDINATE VARIABLES
    private int xCo;
    private int yCo;
    // ITEM VARIABLES
    private int itemCount;
    private boolean hasItem;
    private ArrayList<Item> items;
    // MONSTER VARIABLS
    private Monster monster;
    private boolean hasMonster;
    // SPAWN VARIABLES
    private int spawnTimer;

    public Field (int x, int y)
    {
        xCo = x;
        yCo = y;
        itemCount=0;
        ArrayList<Item> items = new ArrayList<Item>();
        hasItem=false;
        hasMonster=false;
        spawnTimer=0;
        addTime();
    }

    //-----------------------------------------Co-ordinate Information-------------------------------

    /**
     * @return int the xCo.
     */
    public int getX()
    {
        return xCo;
    }

    /**
     * @return int the yCo.
     */
    public int getY()
    {
        return yCo;
    }

    //-----------------------------------------ITEM DETAILS-------------------------------

    /**
     * @return int the itemCount.
     */
    public int getItemCount()
    {
        return itemCount;
    }

    /**
     * @return boolean if there are items.
     */
    public boolean hasItems()
    {
        return hasItem;
    }

    /**
     * Checks if the area has items and sets hasItem to the correct value.
     */
    public void itemCheck()
    {
        if(itemCount<1)
        {hasItem=false;}
        else
        {hasItem=true;}
    }

    /**
     * Adds items to the location.
     * @param String Takes in the string 'name' of an item.
     */
    public void addItem(Item item)
    {
        items.add(item);
        itemCount++;
        itemCheck();
    }

    /**
     * Removes specific items to the location.
     * @param String Takes in the string 'name' of an item.
     */
    public void removeItem(Item item)
    {
        items.remove(item);
        itemCount--;
        itemCheck();
    }

    /**
     * Adds items to the location.
     * @param String Takes in the string 'name' of an item.
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }

    //-----------------------------------------MONSTER SPAWNING-------------------------------

    //Need to improve this later!

    /**
     * Gives an int value based on distance from center of map.
     * @return int An incrimental value determined by distance from center.
     */
    public int spawnRate()
    {
        int rate =1;
        int x= xCo;
        if (x<0){x*=-1;}
        int y= yCo;
        if (y<0){y*=-1;}
        if((x+y)>3)
        {rate++;}
        if((x+y)>7)
        {rate++;}
        if((x+y)>10)
        {rate++;}
        if((x+y)>15)
        {rate++;}
        if((x+y)>20)
        {rate++;}
        if((x+y)>25)
        {rate++;}
        if((x+y)>30)
        {rate++;}
        return rate;
    }

    /**
     * Spawns an apropriate monster for the area of the map.
     */
    public void spawnMob()
    {

        if(xCo>0&&yCo>=0){monster = new Skelly(spawnRate());}
        if(xCo<0&&yCo>=0){monster = new Wolf(spawnRate());}
        if(xCo<=0&&yCo<0){monster = new Orc(spawnRate());}
        if(xCo>=0&&yCo<0){monster = new Raider(spawnRate());}

        hasMonster=true;
        resetTime();
    }

    /**
     * Checks if the field has a monster.
     */
    public boolean hasMonster()
    {

        return hasMonster;
    }

    //-----------------------------------------SPAWN TIMER-------------------------------

    /**
     * Incriments the spwanTimer and spawns monsters accordingly.
     */
    public void addTime()
    {
        int x= xCo;
        if (x<0){x*=-1;}
        int y= yCo;
        if (y<0){y*=-1;}
        if((x+y)>1){
            if(hasMonster==false)
            {
                if(spawnTimer>spawnRate())
                {spawnMob();}
                else
                {spawnTimer++;}
            }
        }
    }

    /**
     * Resets spawnTimer to 0;
     */
    public void resetTime()
    {
        spawnTimer=0;

    }

    //-----------------------------------------MONSTER COMBAT-------------------------------

    /**
     * @return int The current health of the monster located in this field.
     */
    public int getMobHealth()
    {
        return monster.getCurrentHealth();

    }

    /**
     * @return int The max health of the monster located in this field.
     */
    public int getMobMaxHealth()
    {
        return monster.getMaxHealth();

    }

    /**
     * @return int The current health of the monster located in this field.
     */
    public int getMobDmg()
    {
        return monster.getDmg();

    }

    /**
     * @return int The current health of the monster located in this field.
     */
    public int getMobLevel()
    {
        return monster.getLevel();

    }

    /**
     * @return String The name of the monster located in this field.
     */
    public String getMobName()
    {
        return monster.getName();

    }

    /**
     * @param int The damage to be dealt to the monster.
     */
    public void dealDamage(int dmg)
    {
        monster.takeDamage(dmg);
        if(getMobHealth()<=0)
        {
            hasMonster = false;
        }
    }

    public String toString()
    {
        String s="";
        if(hasMonster){
            s=s+"There is one enemy here.\n"+monster.toString();
        }
        else{s=s+"There are no enemies here.\n";}

        if(hasItem)
        {
            s=s+"There are "+itemCount+" items here.\n";
            for(Item it:items)
            {
                s=s+it.toString();
            }
        }

        return s;
    }
}
