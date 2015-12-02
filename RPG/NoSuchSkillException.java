
/**
 * Write a description of class NoSuchSkillException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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