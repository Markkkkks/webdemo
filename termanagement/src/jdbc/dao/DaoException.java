package jdbc.dao;

public class DaoException extends  RuntimeException {
    public DaoException(){
        super();
    }
    public DaoException(String message){
        super(message);
    }
    public DaoException(String message,Throwable t){
        super(message,t);
    }
}
