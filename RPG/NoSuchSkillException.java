
/**
 * This Exception is to be called anytime a skill not loaded into the SkillList is called.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public class NoSuchSkillException extends Exception
{
    // The key with no match.
    private String key;

    /**
     * Store the details in error.
     * @param key The key with no match.
     */
    public NoSuchSkillException(String key)
    {
        this.key = key;
    }

    /**
     * @return The key in error.
     */
    public String getKey()
    {
        return key;
    }
    
    /**
     * @return A diagnostic string containing the key in error.
     */
    public String toString()
    {
        return "No skill named: "+key+" was found.";
    }
}