package com.example.myapplication2;

public class Modelclass4 {

    public static String question[] = {
            "Which of the following is the default file extension of PHP files?",
            " Which is the right way of declaring a variable in PHP?",
            "If $a = 12 what will be returned when ($a == 12) ? 5 : 1 is executed?",
            " Which variable is used to collect form data sent with both the GET and POST methods?"



    };
    public static String choices[][] = {
            { ".php", ".ph","xml",".html"},
            {"$3hello","$_hello","$this", "$5_Hello"},
            { "1", "5", "12", "Error"},
            { "$_BOTH","$REQUEST","$_REQUEST", "$BOTH"}

    };
    public static String correctAnswer[] = {
            ".php",
            "$_hello",
            "5",
            "$_REQUEST"

    };
}

