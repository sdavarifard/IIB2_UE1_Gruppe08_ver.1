package DB_connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Connection_and_ResultSet_close {

    private Connection_and_ResultSet_close() {
    }

    /* Silent closure resultset */
    public static void silentClosing( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "failed to close ResultSet: " + e.getMessage() );
            }
        }
    }

    /* Silent closure statement */
    public static void silentClosing( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "failed to close  Statement : " + e.getMessage() );
            }
        }
    }

    /* Silent closing of the connection */
    public static void silentClosing( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "failed to close connexion : " + e.getMessage() );
            }
        }
    }

    /*Silent closures of statement and connection*/
    public static void silentClosing( Statement statement, Connection connexion ) {
    	silentClosing( statement );
    	silentClosing( connexion );
    }

    /* Silent resultset, statement, and connection closures*/
    public static void silentClosing( ResultSet resultSet, Statement statement, Connection connexion ) {
    	silentClosing( resultSet );
    	silentClosing( statement );
    	silentClosing( connexion );
    }
  /*The main feature of a PreparedStatement object is that, unlike a Statement object,
   *  it is given a SQL statement when it is created. The advantage to this is that in
   *   most cases, this SQL statement is sent to the DBMS right away, where it is compi
   *   led. As a result, the PreparedStatement object contains not just a SQL statement,
   *    but a SQL statement that has been precompiled. This means that when the PreparedStatement 
   *    is executed, the DBMS can just run the PreparedStatement SQL statement without having to compile it first.
   *    */
   
    
    public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
}
