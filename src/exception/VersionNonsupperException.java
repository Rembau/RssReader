package exception;

public class VersionNonsupperException extends Exception {
	private static final long serialVersionUID = 1L;
	public VersionNonsupperException(String message){
		super("当前只支持2.0版本."+message);
	}
	public VersionNonsupperException(){
		super("当前只支持2.0版本.");
	}
}
