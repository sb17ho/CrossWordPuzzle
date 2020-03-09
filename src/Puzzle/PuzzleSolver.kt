package Puzzle

import java.util.*
import kotlin.system.exitProcess

//TODO: ALso tell the player how many words are there in the puzzle
//TODO: ALso check when the user has found all the words

class puzzleSolver {
    val scanner: Scanner = Scanner(System.`in`);
    var matched: Array<String> = arrayOf()
    var count: Int = 0

    //User will be displayed "Found a Word?", if yes where, else loop
    fun found(puzzle: Array<Array<Char>>, inpuzzle: Array<String>) {
        var found: Boolean = false
        var quite: String = ""

        //TODO: When user writes quite then print the words found by him and what were in list
        println("_________Game Started________\n\nWrite Quit Anytime to Exit the Game and see the answers\n\nFound a word?")
        while (!found) {
            val state: String = scanner.next()
            if (state == "yes") {
                where(puzzle, inpuzzle)
                println("Found a Word?")
            } else if (state == "quit") {
                println("Player quite the game!")
                //TODO( Error here)
                if (matched.size == 0) {
                    println("Zero Words Found")
                } else {
                    println("Words Found so far")
                    for (i in matched.indices)
                        println(matched[i])
                    System.exit(0);
                }
            } else {
                continue
            }
        }
    }

    fun where(puzzle: Array<Array<Char>>, inpuzzle: Array<String>) {
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
        verify(x1, x2, y1, y2, direction, wordFound, puzzle, inpuzzle)

        //TODO: Take input as string and remove the white spaces and pick the coordinate from them
        //TODO: Check for invalid input
        //TODO: Try doing with length (word find)
    }

    //TODO: Reverse Diagonal check not working
    fun verify(
        x1: Int,
        x2: Int,
        y1: Int,
        y2: Int,
        direction: Int,
        wordFound: String,
        puzzle: Array<Array<Char>>,
        inpuzzle: Array<String>
    ) {
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
            count++
        } else {
            println("Wrong Answer\nTry Again")
        }

        if (check == result) {
            println("Words Found so far\n")
            print("( ")

            for (i in matched.indices) {
                print(matched[i])
            }
            print(" )")
            println("\n")
        }

        if (isEnd(inpuzzle)) {
            println("End of Game\nFound all $count words")
            System.exit(0);
        }
    }//Verify

    //TODO: check if end
    fun isEnd(inpuzzle: Array<String>): Boolean {
        return count == inpuzzle.size
    }
}