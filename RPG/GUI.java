import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class hold all of the current GUI elements for four dragons rpg.
 * 
 * @author Christopher Easton 
 * @version Alpha 0.1 // 12/01/2015
 */
public class GUI extends JFrame
{
    private Game game;
    private JFrame frame;
    private JTextArea text;
    private JTextArea playerText;
    private JTextArea enemyText;

    private Container contentPane;
    private JPanel south;
    private JPanel south1;
    private JPanel south2;
    private JPanel north;
    private JPanel east;
    private JPanel west;
    /**
     * Class to hold the GUI
     */
    public GUI()
    {
        game = new Game();
        makeFrame();
    }

    /**
     * Initializes the JFrame
     */
    private void makeFrame()
    {
        frame = new JFrame("4 Dragons");
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        makeMenu();
        //-------------------------------------------NORTH-----------------------------------------
        north = new JPanel(new GridLayout(1,2));
        playerText = new JTextArea(5,10);
        playerStats();
        enemyText = new JTextArea(5,10);
        north.add(playerText);
        north.add(enemyText);

        contentPane.add(north, BorderLayout.NORTH);        
        //-------------------------------------------SOUTH-----------------------------------------
        south = new JPanel(new CardLayout());
        makeSouthCombat();
        makeSouthMove();
        contentPane.add(south, BorderLayout.SOUTH);
        nextCard("move");

        //-------------------------------------------EAST------------------------------------------
        east = new JPanel(new GridLayout(2,1));

        JButton search = new JButton("Search");
        search.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){search();}});
        JButton attack = new JButton("Attack");
        attack.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){attack();}});
        east.add(search);
        east.add(attack);

        contentPane.add(east, BorderLayout.EAST);
        //-------------------------------------------WEST------------------------------------------
        //         west = new JPanel();
        //         
        //         contentPane.add(west, BorderLayout.WEST);        
        //-------------------------------------------CENTER----------------------------------------
        text = new JTextArea(20,50);
        JScrollPane scroll = new JScrollPane(text);
        contentPane.add(scroll, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Creates the menu bar for the JFrame
     */
    private void makeMenu()
    {
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);

        JMenu filemenu = new JMenu ("File");
        menu.add(filemenu);

        JMenuItem helpItem = new JMenuItem ("Help");
        helpItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){help();} });
        filemenu.add(helpItem);

        JMenuItem saveItem = new JMenuItem ("Save");
        saveItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){save();} });
        filemenu.add(saveItem);
        
        JMenuItem loadItem = new JMenuItem ("Load");
        loadItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){loadGame();} });
        filemenu.add(loadItem);

        JMenuItem newPlayer = new JMenuItem ("New Game");
        newPlayer.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){newGame();} });
        filemenu.add(newPlayer);
        
        JMenuItem quitItem = new JMenuItem ("Quit");
        quitItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){quit();} });
        filemenu.add(quitItem);


        JMenu diffmenu = new JMenu ("Difficulty");
        menu.add(diffmenu);

        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem easyMode = new JRadioButtonMenuItem("Easy");
        easyMode.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){game.setEasy();playerStats();} });

        JRadioButtonMenuItem normalMode = new JRadioButtonMenuItem("Normal",true);
        normalMode.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){game.setNormal();playerStats();} });        

        JRadioButtonMenuItem hardMode = new JRadioButtonMenuItem("Hard");
        hardMode.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){game.setHard();playerStats();} });

        ButtonGroup diffButtons = new ButtonGroup();
        diffButtons.add(easyMode);
        diffButtons.add(normalMode);
        diffButtons.add(hardMode);
        diffmenu.add(easyMode);
        diffmenu.add(normalMode);
        diffmenu.add(hardMode);
    }

    /**
     * Creates the South field with the movement buttons.
     */
    private void makeSouthMove()
    {
        JButton moveWest = new JButton("West");
        moveWest.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){println(game.moveWest());playerStats();}});
        JButton moveEast = new JButton("East");
        moveEast.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){println(game.moveEast());playerStats();}});
        JButton moveNorth = new JButton("North");
        moveNorth.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){println(game.moveNorth());playerStats();}});
        JButton moveSouth = new JButton("South");
        moveSouth.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){println(game.moveSouth());playerStats();}});
        south1 = new JPanel(new FlowLayout());

        south1.add(moveWest);
        south1.add(moveEast);
        south1.add(moveNorth);
        south1.add(moveSouth);

        south.add(south1, "move");
        //contentPane.add(south, BorderLayout.SOUTH);
    }

    /**
     * Creates the South field with the combat buttons.
     */
    private void makeSouthCombat()
    {
        south.removeAll();
        south.updateUI();
        JButton attackOne = new JButton("One-Hand Attack");
        attackOne.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){attackOne();}});
        JButton attackTwo = new JButton("Two-Hand Attack"); 
        attackTwo.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){attackTwo();}});
        JButton spellFire = new JButton("Fire Spell");
        spellFire.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){spellFire();}});
        JButton spellFrost = new JButton("Frost Spell");
        spellFrost.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){spellFrost();}});
        south2 = new JPanel(new FlowLayout());

        south2.add(attackOne);
        south2.add(attackTwo);
        south2.add(spellFire);
        south2.add(spellFrost);

        south.add(south2,"combat");
        //contentPane.add(south, BorderLayout.SOUTH);
    }

    /**
     * Changes the south panel.
     * @param String the panel to be shown
     */
    public void nextCard(String s)
    {
        CardLayout cl = (CardLayout) south.getLayout();
        cl.show(south, s);
        south.revalidate();

    }

    //------------------------------------------COMBAT-----------------------------------------
    /**
     * Attacks using OneHand Skill.
     */
    public void attackOne()
    {
        int dmg = game.attackOne();
        playerStats();
        enemyStats();
        println("You dealt "+dmg+" damage!");
        if(!game.isAlive())
        {
            newGame();
        }
        if(game.endCombat())
        {
            nextCard("move");
            enemyText.setText("");
            println("You have slain your enemy.");
        }
    }

    /**
     * Attacks using TwoHand Skill.
     */
    public void attackTwo()
    {
        int dmg = game.attackTwo();
        playerStats();
        enemyStats();
        println("You dealt "+dmg+" damage!");
        if(!game.isAlive())
        {
            newGame();
        }
        if(game.endCombat())
        {
            nextCard("move");
            enemyText.setText("");
            println("You have slain your enemy.");
        }
    }

    /**
     * Attacks using Fire Skill.
     */
    public void spellFire()
    {
        int dmg = game.spellFire();
        playerStats();
        enemyStats();
        println("You dealt "+dmg+" damage!");
        if(!game.isAlive())
        {
            newGame();
        }
        if(game.endCombat())
        {
            nextCard("move");
            enemyText.setText("");
            println("You have slain your enemy.");
        }
    }

    /**
     * Attacks using Frost Skill.
     */
    public void spellFrost()
    {
        int dmg = game.spellFrost();
        playerStats();
        enemyStats();
        println("You dealt "+dmg+" damage!");
        if(!game.isAlive())
        {
            newGame();
        }
        if(game.endCombat())
        {
            nextCard("move");
            enemyText.setText("");
            println("You have slain your enemy.");
        }
    }

    //---------------------------------NORTH FUNCTIONS--------------------------------------
    /**
     * Searches the field and returns information on what is present.
     */
    public void playerStats()
    {
        playerText.setText("");
        playerText.append(game.playerName());
        playerText.append("\n");
        if(game.getDifficulty() == 1)
        {
            playerText.append("Hard Mode Enabled.");
            playerText.append("\n");
        }
        else if(game.getDifficulty() == -1)
        {
            playerText.append("Easy Mode Enabled.");
            playerText.append("\n");
        }
        playerText.append("HP: "+game.playerCurrentHP()+"/"+game.playerMaxHP());
        playerText.append("\n");
        playerText.append("Location: "+game.getCoord());
        playerText.append("\n");

    }

    /**
     * Searches the field and returns information on what is present.
     */
    public void enemyStats()
    {
        enemyText.setText("");
        enemyText.append(game.enemyName());
        enemyText.append("\n");

        enemyText.append("HP: "+game.enemyCurrentHP()+"/"+game.enemyMaxHP());
        enemyText.append("\n");

    }
    //---------------------------------EAST FUNCTIONS--------------------------------------
    /**
     * Searches the field and returns information on what is present.
     */
    public void search()
    {
        println(game.getInfo());

    }

    /**
     * If there is a monster to attack initiates attack sequence.
     */
    public void attack()
    {
        if(game.hasMonster())
        {
            nextCard("combat");
            frame.repaint();
        }
        else{println("There is nothing to attack.");}
    }

    //---------------------------------MENU FUNCTIONS--------------------------------------
    /**
     * Prints out the help text.
     */
    public void help(){
        println("Welcome to Four Dragons!\n");
        println("The point to this game is to slay the four dragons \nlocated somewhere on the map.\n");
        println("Use the directional buttons below to move in that direction\n");
        println("If you look at the top of your screen you will see \na box that shows your current location and health\n");
        println("When you find an enemy you can ckick the attack button to the right.\n");
        println("When in combat the buttons below will change from movement to attack buttons\n");
        println("BEWARE: Once in combat it is a fight to the death, no running away!\n");
        println("We hope you enjoy Four Dragons!\n");
    }

    /**
     * Prints out the about text.
     */
    public void save(){
        if(game.saveGame())
        {println("Your game has been saved");}
        else
        {println("There was an error in saving your game, oops.");}
    }

    /**
     * Exits the Program.
     */
    public void quit(){System.exit(0);}

    /**
     * Creates a new game.
     */
    public void newGame()
    {
        game = new Game();

        game.newPlayer(getNewName(),1);
        frame.dispose();
        makeFrame();
    }

    /**
     * Creates a new game.
     */
    public void loadGame()
    {

        String load = game.loadGame(getNewName());
        if(load!=null)
        {
            game = new Game();
            String[] stats = load.split(",");
            game.newPlayer(stats[0],Integer.parseInt(stats[1]));
            boolean comp = game.setPlayerSkills(stats[2],stats[3],stats[4],stats[5]);
            frame.dispose();
            makeFrame();
            if(!comp){println("Not all skills loaded correctly.");}
        }
        else
        {
            println("There was an error in loading that game file.");
        }
    }

    /**
     * @return String gets a new name from the user.
     * Will force the user to enter a non null string.
     */
    public String getNewName()
    {
        String s = JOptionPane.showInputDialog(frame,"What is your name?", null);
        if(s==null)
        {getNewName();}
        return s;
    }

    //-------------------------------TEXT ADDING COMMANDS----------------------------------
    /**
     * Replacement for print line.
     * @param String What is to be printed.
     */
    public void print(String s)
    {text.append(s);}

    /**
     * Replacement for print line.
     */
    public void println()
    {text.append("\n");}

    /**
     * Replacement for print line.
     * @param String What is to be printed.
     */
    public void println(String s)
    {
        text.append(s);
        text.append("\n");
    }
}
