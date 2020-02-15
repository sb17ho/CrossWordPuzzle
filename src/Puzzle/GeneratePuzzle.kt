package Puzzle

var puzzle: Array<Array<Char>> = arrayOf()
var puzzlefill: Array<Char> = arrayOf()

fun initializePuzzle(r: Int, c: Int) {
    for (i in 0 until r) {
        for (j in 0 until c) {
            puzzlefill += '.'
        }
        puzzle += puzzlefill
    }
}

fun fillwords(word: String, orint: Int) {
    val row: Int = (0..puzzle.size - word.length).random()
    val col: Int = (0..puzzle[0].size - word.length).random()

    if (orint == 0 && horizontalCheck(word, row, col)) {
        for (i in word.indices) {
            puzzle[row][col + i] = word[i]
        }
    } else if (orint == 1 && verticalcheck(word, row, col)) {
        for (i in word.indices) {
            puzzle[row + i][col] = word[i]
        }
    } else if (orint == 2 && diagonalcheck(word, row, col)) {
        for (i in word.indices) {
            puzzle[row + i][col + i] = word[i]
        }
    } else if (orint == 3 && verticalcheck(word, row, col)) {
        for (i in word.indices) {
            puzzle[row + i][col - i] = word[i]
        }
    }
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
        for (j in 0 until puzzle.size) {
            print(puzzle[i][j] + " ")
        }
        println()
    }
}
