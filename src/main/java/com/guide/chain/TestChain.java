package com.guide.chain;

public class TestChain {
    public static void main(String[] args) {
        Handler printHandler = new PrintHandler();
        Handler formatHandler = new FormatHandler();
        printHandler.setSuccessor(formatHandler);
        printHandler.handleRequest("print");
    }
}
