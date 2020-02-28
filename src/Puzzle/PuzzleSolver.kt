package Puzzle

import java.util.*

class puzzleSolver{
    val scanner: Scanner = Scanner(System.`in`);

    //User will be displayed "Found a Word?", if yes where, else loop
    fun found(){
        var found: Boolean = false

        println("_________Game Started________\n\nFound a Word!")
        while (!found){
            if(scanner.next() == "yes"){
                where()
//                break
            }else{
                continue
            }
        }
    }

    fun where(){
        println("In where")
    }
}