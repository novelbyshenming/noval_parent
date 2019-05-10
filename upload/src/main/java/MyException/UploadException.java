package MyException;

/**
 * @author LX
 * @date 2019/5/1 - 19:21
 */
public class UploadException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UploadException() {
        super();
    }

    public UploadException(String message) {
        super(message);
    }
}
