package aravind.assignment.main;

import aravind.assignment.data.DefaultInitialization;
import aravind.assignment.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        DefaultInitialization defaultInitialization = new DefaultInitialization();
    /*
        it will prints the default values but we have an error in that class so it won't  be invoked
        defaultInitialization.displayInstanceVariables();


        it will be compilation error since we're not intializing values to the variables
        defaultInitialization.displayLocalVariables();

        Singleton singleton = new Singleton();
        singleton.display();  it won't be invoked since we had an error in that class which is we are trying to accessing non static member inside a static function

     */
    }
}
