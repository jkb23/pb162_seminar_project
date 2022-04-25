package cz.muni.fi.pb162.project.exception;

/**
 * @author Matus Jakab
 */
public class EmptyDrawableException extends Exception{

    /**
     *
     * @param s message
     */
    public EmptyDrawableException(String s){
        super(s);
    }

    /**
     *
     * @param c cause
     */
    public EmptyDrawableException(Throwable c){
        super(c);
    }

    /**
     *
     * @param s message
     * @param c cause
     */
    public EmptyDrawableException(String s, Throwable c){
        super(s, c);
    }
}
