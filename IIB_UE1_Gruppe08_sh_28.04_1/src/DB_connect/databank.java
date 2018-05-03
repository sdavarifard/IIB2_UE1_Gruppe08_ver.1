package DB_connect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class databank {
	private static final String FICHIER_PROPERTIES = "./DB_connect/DB.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";
    public static Connection getInstance() throws SQLException  {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
        if ( fichierProperties == null ) {
               throw new ConnectionConfigurationException( "The properties file " + FICHIER_PROPERTIES + " is unavailable." );
        }
        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE );
        } catch ( FileNotFoundException e ) {
            throw new ConnectionConfigurationException( "The properties file " + FICHIER_PROPERTIES + " is unavailable.", e );
        } catch ( IOException e ) {
            throw new ConnectionConfigurationException( "Could not load properties file " + FICHIER_PROPERTIES, e );
         }
        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new ConnectionConfigurationException( "LLe driver est introuvable dans le classpath.", e );
        }
        Connection instance = DriverManager.getConnection( url, nomUtilisateur, motDePasse );
        return instance;
    }
    
    
}
