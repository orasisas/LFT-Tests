package com.orasi;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LeanFtTest.class);
        System.out.println(result.wasSuccessful());
    }
}