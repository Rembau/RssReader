package exception;

public class VersionNonsupperException extends Exception {
	private static final long serialVersionUID = 1L;
	public VersionNonsupperException(String message){
		super("��ǰֻ֧��2.0�汾."+message);
	}
	public VersionNonsupperException(){
		super("��ǰֻ֧��2.0�汾.");
	}
}
