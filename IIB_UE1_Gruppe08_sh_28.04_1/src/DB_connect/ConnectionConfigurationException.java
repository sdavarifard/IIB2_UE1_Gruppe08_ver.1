
package DB_connect;

/**
 *
 * @author LENANGUELO
 */
public class ConnectionConfigurationException extends RuntimeException{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
* Constructeurs
*/
    public ConnectionConfigurationException( String message ) {
        super( message );
    }
    public ConnectionConfigurationException( String message, Throwable cause ) {
        super( message, cause );
    }
    public ConnectionConfigurationException( Throwable cause ) {
        super( cause );
    }
}
