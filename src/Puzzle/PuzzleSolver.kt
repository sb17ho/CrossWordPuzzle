package Puzzle

import java.util.*

//TODO: ALso tell the player how many words are there in the puzzle
//TODO: ALso check when the user has found all the words

class puzzleSolver {
    val scanner: Scanner = Scanner(System.`in`);
    var matched: Array<String> = arrayOf()

    //User will be displayed "Found a Word?", if yes where, else loop
    fun found(puzzle: Array<Array<Char>>) {
        var found: Boolean = false
        var quite: String = ""

        //TODO: See how to provide quite option
        println("_________Game Started________\n\nWrite Quite Anytime to Exit the Game and see the answers\n\nFound a word?")
        while (!found) {
            val state: String = scanner.next()
            if (state == "yes") {
                where(puzzle)
                println("Found a Word?")
            } else if (state == "quite") {
                println("Player quite the game!")
                System.exit(1);
            } else {
                continue
            }
        }
    }

    fun where(puzzle: Array<Array<Char>>) {
        println("Please specify the direction\n1) Vertical\n2) Horizontal\n3) Diagonal\n4) Reverse Diagonal\n")
        val direction: Int = scanner.nextInt()

        println("Please specify the X1 (i) and Y1 (j)\n")
        val x1: Int = scanner.nextInt() - 1
        val y1: Int = scanner.nextInt() - 1

        println("Please specify the X2 (i)  and Y2 (j)\n")
        val x2: Int = scanner.nextInt() - 1
        val y2: Int = scanner.nextInt() - 1

        println("Please write the word found\n")
        val wordFound: String = scanner.next()
        verify(x1, x2, y1, y2, direction, wordFound, puzzle)

        //TODO: Take input as string and remove the white spaces and pick the coordinate from them
        //TODO: Check for invalid input
    }

    //TODO: Reverse Diagonal check not working
    fun verify(x1: Int, x2: Int, y1: Int, y2: Int, direction: Int, wordFound: String, puzzle: Array<Array<Char>>) {
        val check: String = wordFound
        var result: String = ""

        if (direction == 1) {
            val j: Int = y1
            for (i in x1..x2) {
                result += puzzle[i][j]
            }
        } else if (direction == 2) {
            val i: Int = x1
            for (j in y1..y2) {
                result += puzzle[i][j]
            }
        } else if (direction == 3) {
            var i: Int = x1
            for (j in y1..y2) {
                result += puzzle[i++][j]
            }
        } else if (direction == 4) {
            for (i in x1..x2) {
                for (j in y2 downTo y1) {
                    result += puzzle[i][j]
                }
            }
        }

        if (check == result) {
            println("Correct \b")
            matched += check
        }
    }//Verify
}