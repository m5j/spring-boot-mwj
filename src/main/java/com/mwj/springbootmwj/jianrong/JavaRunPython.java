package com.mwj.springbootmwj.jianrong;

import org.python.util.PythonInterpreter;

/**
 * Created by minwujun on 2022/7/29
 */
public class JavaRunPython {


    public static void main(String[] args) {
        func2();
    }


    //直接执行代码
    private void func1() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a='hello world'; ");
        interpreter.exec("print a;");
    }

    //执行py脚本
    private static void func2() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("D:\\code\\py.py");
    }

}
