package cz.muni.fi.pb162.project.exception;

/**
 * @author Matus Jakab
 */
public class TransparentColorException extends Exception {

    /**
     *
     * @param s message
     */
    public TransparentColorException(String s){
        super(s);
    }

    /**
     *
     * @param c cause
     */
    public TransparentColorException(Throwable c){
        super(c);
    }

    /**
     *
     * @param s message
     * @param c cause
     */
    public TransparentColorException(String s, Throwable c){
        super(s, c);
    }


}
