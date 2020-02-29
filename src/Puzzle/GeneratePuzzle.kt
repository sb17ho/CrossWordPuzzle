package Puzzle

class PuzzleCreate {
    var puzzle: Array<Array<Char>> = arrayOf()
    var puzzlefill: Array<Char> = arrayOf()
    var inpuzzle: Array<String> = arrayOf()

    fun initializePuzzle(r: Int, c: Int) {
        for (i in 0 until r) {
            for (j in 0 until c) {
                puzzlefill += '.'
            }
            puzzle += puzzlefill
        }
    }

    fun fillwords(word: String, orint: Int) {
        val RC: Array<Int> = selectRC(orint, word)
        var s: String = ""

        if (orint == 0 && horizontalCheck(word, RC[0], RC[1])) {
            for (i in word.indices) {
                s += word[i]
                puzzle[RC[0]][RC[1] + i] = word[i]
            }
            inpuzzle += s
        } else if (orint == 1 && verticalcheck(word, RC[0], RC[1])) {
            for (i in word.indices) {
                s += word[i]
                puzzle[RC[0] + i][RC[1]] = word[i]
            }
            inpuzzle += s
        } else if (orint == 2 && diagonalcheck(word, RC[0], RC[1])) {
            for (i in word.indices) {
                s += word[i]
                puzzle[RC[0] + i][RC[1] + i] = word[i]
            }
            inpuzzle += s
        } else if (orint == 3 && reverseDiagonalCheck(word, RC[0], RC[1])) {
            for (i in word.indices) {
                s += word[i]
                puzzle[RC[0] + i][RC[1] - i] = word[i]
            }
            inpuzzle += s
        }
    }

    fun fillSpaces() {
        for (i in puzzle.indices) {
            for (j in puzzle[0].indices) {
                if (puzzle[i][j] == '.') {
                    puzzle[i][j] = ('a'..'z').random()
                }
            }
        }
    }

    //0: row,  1:column
    fun selectRC(orint: Int, word: String): Array<Int> {
        val RC: Array<Int> = arrayOf(0, 0)

        if (orint == 0) {
            RC[0] = (0..puzzle.size - 1).random()
            RC[1] = (0..puzzle[0].size - word.length).random()
        } else if (orint == 1) {
            RC[0] = (0..puzzle.size - word.length).random()
            RC[1] = (0..puzzle[0].size - 1).random()
        } else if (orint == 2) {
            RC[0] = (0..puzzle.size - word.length).random()
            RC[1] = (0..puzzle[0].size - word.length).random()
        } else if (orint == 3) {
            RC[0] = (0..puzzle.size - word.length).random()
            RC[1] = ((0 + word.length) until puzzle[0].size).random()
        }

        return RC
    }

    fun horizontalCheck(s: String, i: Int, j: Int): Boolean {
        var count: Int = 0
        var valid: Boolean = false
        for (k in s.indices) {
            if (isEmpty(i, j + k)) {
                count++
            }
        }
        if (count == s.length) {
            valid = true
        }
        return valid
    }


    fun verticalcheck(s: String, i: Int, j: Int): Boolean {
        var count: Int = 0
        var valid: Boolean = false

        for (k in s.indices) {
            if (isEmpty(i + k, j)) {
                count++
            }
        }
        if (count == s.length) {
            valid = true
        }
        return valid
    }

    fun diagonalcheck(s: String, i: Int, j: Int): Boolean {
        var count: Int = 0
        var valid: Boolean = false

        for (k in s.indices) {
            if (isEmpty(i + k, j + k)) {
                count++
            }
        }

        if (count == s.length) {
            valid = true
        }
        return valid
    }

    fun reverseDiagonalCheck(s: String, i: Int, j: Int): Boolean {
        var count: Int = 0
        var valid: Boolean = false

        for (k in s.indices) {
            if (isEmpty(i + k, j - k)) {
                count++
            }
        }

        if (count == s.length) {
            valid = true
        }

        return valid
    }

    fun isEmpty(i: Int, j: Int): Boolean {
        return puzzle[i][j] == '.'
    }

    fun printPuzzle() {
        for (i in 0 until puzzle.size) {
            print("${i+1}\t")
            for (j in 0 until puzzle.size) {
                print(puzzle[i][j] + " ")
            }
            println()
        }
        print("\t")
        for (j in 0 until puzzle.size) {
            print("${j+1} ")
        }
    }

    fun inpuzzle() {
        print("(")
        for (i in inpuzzle.indices) {
            print(" ${inpuzzle[i]} ")
        }
        println(")")
    }
}
