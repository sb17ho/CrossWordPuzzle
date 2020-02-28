package Puzzle

import java.util.*

class puzzleSolver {
    val scanner: Scanner = Scanner(System.`in`);

    //User will be displayed "Found a Word?", if yes where, else loop
    fun found() {
        var found: Boolean = false
        var quite: String = ""

        //TODO: See how to provide quite option
        println("_________Game Started________\n\nWrite Quite Anytime to Exit the Game and see the answers\n\nFound a word?")
        while (!found || quite == "quite") {
            if (scanner.next() == "yes") {
                where()
                println("Found a Word?")
//                found = true
            } else {
                continue
            }
        }
    }

    fun where() {
        println("In where")
    }
}