import java.util.HashMap;
import java.util.Map.Entry;
/**
 * All skills should be predefined in this class and held as a list for other classes to access.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public class SkillList
{
    private HashMap<String, OneHandSkill> oneList;
    private HashMap<String, TwoHandSkill> twoList;
    private HashMap<String, FireSkill> fireList;
    private HashMap<String, FrostSkill> frostList;
    
    

    /**
     * Constructor for objects of class SkillList
     */
    public SkillList()
    {
        oneList=new HashMap<String, OneHandSkill>();
        twoList=new HashMap<String, TwoHandSkill>();
        fireList=new HashMap<String, FireSkill>();
        frostList=new HashMap<String, FrostSkill>();
        fillList();
    }

    /**
     * Fills the list with all skills currently in the game.
     */
    public void fillList()
    {
        //-------ONE-HAND-SKILLS--------------
        oneList.put("Punch", new OneHandSkill(2,3,"Punch",10,"Thrust"));
        oneList.put("Thrust", new OneHandSkill(4,7,"Thrust",10,"Thrust"));
        
        //-------TWO-HAND-SKILLS--------------
        twoList.put("Shove", new TwoHandSkill(1,4,"Shove",10,"Cleave"));
        twoList.put("Cleave", new TwoHandSkill(2,9,"Cleave",10,"Cleave"));
        
        //-------FROST-SKILLS--------------
        frostList.put("Chill", new FrostSkill(1,2,"Chill",10,"Iceicle"));
        frostList.put("Iceicle", new FrostSkill(3,6,"Iceicle",10,"Iceicle"));
        
        //-------FIRE-SKILLS--------------
        fireList.put("Burn", new FireSkill(2,3,"Burn",10,"Flame"));
        fireList.put("Flame", new FireSkill(4,6,"Flame",10,"Flame"));
    
    }
    
    
    /**
     * Returns the skill with the associated name.
     * @return OneHandSkill the skill named.
     * @param String the name of the skill.
     */
    public OneHandSkill getOneSkill(String name) throws NoSuchSkillException
    {
         Boolean found = false;
        for(Entry<String,OneHandSkill> entry: oneList.entrySet())
        {
            if(name.equals(entry.getKey()))
            {
                found = true;
                return oneList.get(name);
            }
        }
        if(!found){throw new NoSuchSkillException(name);}
        return oneList.get(name); 
    }
    
    /**
     * Returns the skill with the associated name.
     * @return OneHandSkill the skill named.
     * @param String the name of the skill.
     */
    public TwoHandSkill getTwoSkill(String name) throws NoSuchSkillException
    {
         Boolean found = false;
        for(Entry<String,TwoHandSkill> entry: twoList.entrySet())
        {
            if(name.equals(entry.getKey()))
            {
                found = true;
                return twoList.get(name);
            }
        }
        if(!found){throw new NoSuchSkillException(name);}
        return twoList.get(name); 
    }
    
    /**
     * Returns the skill with the associated name.
     * @return OneHandSkill the skill named.
     * @param String the name of the skill.
     */
    public FireSkill getFireSkill(String name) throws NoSuchSkillException
    {
         Boolean found = false;
        for(Entry<String,FireSkill> entry: fireList.entrySet())
        {
            if(name.equals(entry.getKey()))
            {
                found = true;
                return fireList.get(name);
            }
        }
        if(!found){throw new NoSuchSkillException(name);}
        return fireList.get(name); 
    }
    
    /**
     * Returns the skill with the associated name.
     * @return OneHandSkill the skill named.
     * @param String the name of the skill.
     */
    public FrostSkill getFrostSkill(String name) throws NoSuchSkillException
    {
         Boolean found = false;
        for(Entry<String,FrostSkill> entry: frostList.entrySet())
        {
            if(name.equals(entry.getKey()))
            {
                found = true;
                return frostList.get(name);
            }
        }
        if(!found){throw new NoSuchSkillException(name);}
        return frostList.get(name); 
    }
    
    
}
