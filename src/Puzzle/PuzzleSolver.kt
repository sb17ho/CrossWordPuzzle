package Puzzle

import java.util.*

//TODO: ALso tell the player how many words are there in the puzzle
//TODO: ALso check when the user has found all the words

class puzzleSolver {
    val scanner: Scanner = Scanner(System.`in`);
    val create: PuzzleCreate = PuzzleCreate()

    //User will be displayed "Found a Word?", if yes where, else loop
    fun found() {
        var found: Boolean = false
        var quite: String = ""

        //TODO: See how to provide quite option
        println("_________Game Started________\n\nWrite Quite Anytime to Exit the Game and see the answers\n\nFound a word?")
        while (!found) {
            val state: String = scanner.next()
            if (state == "yes") {
                where()
                println("Found a Word?")
            } else if (state == "quite") {
                System.exit(1);
            } else {
                continue
            }
        }
    }

    fun where() {
        println("Please specify the direction\n1) Vertical\n2) Horizontal\n3) Diagonal\n4) Reverse Diagonal\n")
        val direction: Int = scanner.nextInt()

        //TODO: Take input as string and remove the white spaces and pick the coordinate from them
        //TODO: Check for invalid input
        if (direction == 1) {
            println("Please specify the X1 and Y1\n")
            val x1: Int = scanner.nextInt()
            val y1: Int = scanner.nextInt()

            println("Please specify the X2 and Y2\n")
            val x2: Int = scanner.nextInt()
            val y2: Int = scanner.nextInt()

            println("Please write the word found\n")
            val wordFound: String = scanner.next()
            verify(x1, x1, y1, y2, direction, wordFound)

        } else if (direction == 2) {

        } else if (direction == 3) {

        } else if (direction == 4) {

        }
    }

    //TODO: Hmm, decide how to proceed with checking
    fun verify(x1: Int, x2: Int, y1: Int, y2: Int, direction: Int, wordFound: String) {
        val check: String = wordFound
        var result: String = ""

        if (direction == 1) {
            for (i in x1..x2) {
                for (j in y1..y2)
                    result += create.puzzle[i][j]
            }
        }
    }
}