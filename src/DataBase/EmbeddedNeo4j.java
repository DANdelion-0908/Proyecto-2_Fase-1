package DataBase;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;
import static org.neo4j.driver.Values.parameters;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class EmbeddedNeo4j implements AutoCloseable{

    private final Driver driver;
    

    public EmbeddedNeo4j( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (a:Greeting) " +
                                                     "SET a.message = $message " +
                                                     "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }
    
    public LinkedList<String> getMcBurgers()
    {
    	 try ( Session session = driver.session() )
         {	 
    		 LinkedList<String> mcBurgers = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (mc:McBurger) RETURN mc.name");
                     LinkedList<String> myBurgers = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                    	 
                    	 myBurgers.add(registros.get(i).get("mc.name").asString());
                     }
                     
                     return myBurgers;
                 }
             } );
             
             return mcBurgers;
         }
    }

    public LinkedList<String> getDpBurgers()
    {
    	 try ( Session session = driver.session() )
         {	 
    		 LinkedList<String> dpBurgers = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (dp:DpBurger) RETURN dp.name");
                     LinkedList<String> myBurgers = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                    	 
                    	 myBurgers.add(registros.get(i).get("dp.name").asString());
                     }
                     
                     return myBurgers;
                 }
             } );
             
             return dpBurgers;
         }
    }

    public LinkedList<String> getWdBurgers()
    {
    	 try ( Session session = driver.session() )
         {	 
    		 LinkedList<String> wdBurgers = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (wd:WdBurger) RETURN wd.name");
                     LinkedList<String> myBurgers = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                    	 
                    	 myBurgers.add(registros.get(i).get("wd.name").asString());
                     }
                     
                     return myBurgers;
                 }
             } );
             
             return wdBurgers;
         }
    }
    
    public ArrayList<String> getIngredients(String label, String name) {
    	
    	try ( Session session = driver.session() ) {
    		ArrayList<String> ingredients = session.readTransaction (new TransactionWork<ArrayList<String>>( ) {

				@Override
				public ArrayList<String> execute(Transaction tx) {
					Result result = tx.run( "MATCH p = (b: " + label + "{name: " + '"' + name + '"' + "})-[r:Lleva]->(i:Ingredient) RETURN i.name");
					ArrayList<String> mcBurgersIngredients = new ArrayList<String>();
					List<Record> registros = result.list();
					for (int i = 0; i < registros.size(); i++) {
						
						mcBurgersIngredients.add(registros.get(i).get("i.name").asString());
					}	
					return mcBurgersIngredients;
				}
    		} );
    		return ingredients;
    	}
    }
}
