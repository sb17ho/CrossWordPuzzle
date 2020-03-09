package Puzzle

import java.util.*

class puzzleSolver {
    val scanner: Scanner = Scanner(System.`in`);
    var matched: Array<String> = arrayOf()
    var totalCount: Int = 0

    //User will be displayed "Found a Word?", if yes where, else loop
    fun found(puzzle: Array<Array<Char>>, inpuzzle: Array<String>) {
        val found: Boolean = false

        println("_________Game Started________\n\nWrite Quit Anytime to Exit the Game and see the answers\n\nFound a word? Yes to continue")
        while (!found) {
            val state: String = scanner.next()
            if (state == "yes") {
                where(puzzle, inpuzzle)
                println("Found a Word?")
            } else if (state == "quit") {
                println("Player quite the game!")

                if (matched.size == 0) {
                    println("Zero Words Found!!")
                    print("Words in the puzzle\n( ")

                    for (i in inpuzzle.indices) {
                        print("${inpuzzle[i]} ")
                    }

                    print(" )\n")
                } else {
                    print("Words in the puzzle\n( ")

                    for (i in inpuzzle.indices)
                        print("${inpuzzle[i]} ")
                    print(" )\n")

                    print("Words Found so far\n( ")
                    for (i in matched.indices)
                        print("${matched[i]} ")
                    print(" )\n")
                }

                System.exit(0);
            } else {
                continue
            }
        }
    }

    fun where(puzzle: Array<Array<Char>>, inpuzzle: Array<String>) {
        println("Please specify the direction\n1) Vertical\n2) Horizontal\n3) Diagonal\n4) Reverse Diagonal\n")
        val direction: Int = scanner.nextInt()

        var x: Int = 0
        var y: Int = 0
        var length: Int = 0

        if (direction == 1) { //vertical
            println("Please specify the x (i) and y (j) coordinate")
            x = scanner.nextInt()
            y = scanner.nextInt()

            println("Specify the length of the word")
            length = scanner.nextInt()

        } else if (direction == 2) { //horizontal
            println("Please specify the x (i) and y (j) coordinate")
            x = scanner.nextInt()
            y = scanner.nextInt()

            println("Specify the length of the word")
            length = scanner.nextInt()

        } else { //diagonal
            println("Please specify the x (i) and y (j) coordinate")
            x = scanner.nextInt()
            y = scanner.nextInt()

            println("Specify the length of the word")
            length = scanner.nextInt()

        }

        println("Please write the word found\n")
        val wordFound: String = scanner.next()
        verify(x - 1, y - 1, length, direction, wordFound, puzzle, inpuzzle)

        //TODO: Take input as string and remove the white spaces and pick the coordinate from them
    }

    fun verify(
        x: Int,
        y: Int,
        length: Int,
        direction: Int,
        wordFound: String,
        puzzle: Array<Array<Char>>,
        inpuzzle: Array<String>
    ) {

        val check: String = wordFound
        var result: String = ""
        var count: Int = 0

        if (direction == 1) {
            val j: Int = y
            var i: Int = x
            while (count < length) {
                result += puzzle[i++][j]
                count++
            }
        }// Vertical
        else if (direction == 2) {
            val i: Int = x
            var j: Int = y
            while (count < length) {
                result += puzzle[i][j++]
                count++
            }
        }//Horizontal
        else if (direction == 3) {
            var i: Int = x
            var j: Int = y
            while (count < length) {
                result += puzzle[i++][j++]
                count++
            }
        }// diagonal
        else if (direction == 4) {
            var i: Int = x
            var j: Int = y
            while (count < length) {
                result += puzzle[i++][j--]
                count++
            }
        }// reverse diagonal

        if (check == result) {
            println("Correct \b")
            matched += check
            totalCount++
        } else {
            println("Wrong Answer\nTry Again")
        }

        if (check == result) {
            println("Words Found so far\n")
            print("( ")

            for (i in matched.indices) {
                print("${matched[i]} ")
            }
            print(" )")
            println("\n")
        }

        if (isEnd(inpuzzle)) {
            println("End of Game\nFound all $totalCount words")
            print("\n( ")

            for (i in inpuzzle.indices) {
                print("${inpuzzle[i]} ")
            }

            print(" )\n")

            System.exit(0);
        }
    }//Verify

    fun isEnd(inpuzzle: Array<String>): Boolean {
        return totalCount == inpuzzle.size
    }
}