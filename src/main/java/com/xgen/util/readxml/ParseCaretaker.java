package com.xgen.util.readxml;

public class ParseCaretaker {
    private static ParseCaretaker caretaker = new ParseCaretaker();
    private ParseMemento memento = null;

    private ParseCaretaker() {
        
    }

    public static ParseCaretaker getInstance(){
        return caretaker;
    }

    public void saveMemento(ParseMemento memento){
        this.memento = memento;
    }

    public ParseMemento retriveMemnto(){
        return this.memento;
    }
}
