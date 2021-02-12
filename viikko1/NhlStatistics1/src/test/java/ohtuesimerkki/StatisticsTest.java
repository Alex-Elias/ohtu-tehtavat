/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author alex
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void searchTest() {
        Player player = stats.search("Gretzky");
        
        assertEquals("Gretzky", player.getName());
    }
    
    @Test
    public void searchWrongNameTest() {
        Player player = stats.search(" ");
        
        assertNull(player);
    }
    
    @Test
    public void teamTest() {
        List<Player> list = stats.team("EDM");
        assertEquals("Semenko", list.get(0).getName());
        assertEquals("Kurri", list.get(1).getName());
        assertEquals("Gretzky", list.get(2).getName());
    }
    
    @Test
    public void topScorersTest() {
        List<Player> list = stats.topScorers(2);
        assertEquals("Gretzky", list.get(0).getName());
        assertEquals("Lemieux", list.get(1).getName());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
