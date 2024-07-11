package de.jafe2211.mobbattle;

import de.jafe2211.mobbattle.Commands.*;
import de.jafe2211.mobbattle.Listeners.*;
import de.jafe2211.mobbattle.Utility.Menu.MenuListener;
import de.jafe2211.mobbattle.menu.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class Main extends JavaPlugin {


    public static int gameStarted = 0;
    private static Main Main;
    private de.jafe2211.mobbattle.Utility.Timer.Timer timer;

    @Override
    public void onEnable() {
        System.out.println("");
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║         Mob Battle        ║");
        System.out.println("╠═══════════════════════════╣");
        System.out.println("║  Plugin made by Jafe2211  ║");
        System.out.println("║        Version: 1.0       ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println("");
        Main = this;

        loadEvents();
        loadCommands();

        initialize();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static String prefix(){
        return ChatColor.GRAY + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "MobBattle" + ChatColor.GRAY + "]";
    }

    public void loadEvents(){
        Bukkit.getPluginManager().registerEvents(new JoinLeve(), this);
        Bukkit.getPluginManager().registerEvents(new Chat(), this);
        Bukkit.getPluginManager().registerEvents(new onInteract(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
       // Bukkit.getPluginManager().registerEvents(new Advantsments(), this);
        Bukkit.getPluginManager().registerEvents(new KillEvent(), this);
    }
    public void loadCommands(){
        this.getCommand("1234").setExecutor(new test());
        this.getCommand("getTeam").setExecutor(new getTeam());
        this.getCommand("Inventory").setExecutor(new TestCommand());
        this.getCommand("config").setExecutor(new JoinTeam());
        this.getCommand("Timer").setExecutor(new Timer());
        this.getCommand("MobBattleDebug").setExecutor(new MobBattleDebug());
        this.getCommand("publicChat").setExecutor(new publicChat());
    }
    public static Team team1;
    public static Team team2;
    public void initialize(){
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();

        Boolean team1Exists = false;
        Boolean team2Exists = false;

        for (Team team : sb.getTeams()){
            if(team.getName().equals("team1")) {
                team1Exists = true;
                team1 = team;
            }
            if(team.getName().equals("team2")){
                team2Exists = true;
                team2 = team;
            }
        }

        if(!team1Exists){
            Team team1T =  sb.registerNewTeam("team1");
            team1T.setColor(ChatColor.DARK_BLUE);
            team1T.setDisplayName("BlueTeam");

            team1 = team1T;
        }
        if(!team2Exists){
            Team team2T =  sb.registerNewTeam("team2");
            team2T.setColor(ChatColor.DARK_RED);
            team2T.setDisplayName("RedTeam");

            team2 = team2T;
        }


        timer = new de.jafe2211.mobbattle.Utility.Timer.Timer(false, 3600 );
    }

    public static int getGamestate(){
        return gameStarted;
    }
    public static void setGamestate(int GameState){
        gameStarted = GameState;
    }

    public static Main getInstance(){
        return Main;
    }
    public de.jafe2211.mobbattle.Utility.Timer.Timer getTimer() {
        return timer;
    }

    public static int getPlayerTeam(Player p){
        if(team1.hasEntry(p.getName())){
            return 1;
        }
        if(team2.hasEntry(p.getName())){
            return 0;
        }
        else return -1;
    }

}
