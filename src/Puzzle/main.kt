package Puzzle

import java.io.File

fun main(args: Array<String>) {
    val create: PuzzleCreate = PuzzleCreate()
    var list: Array<String> = arrayOf()
    create.initializePuzzle(15, 15)
    val stream = File("D:\\Winter\\Puzzle\\Words.txt").readLines()
    for (i in stream.indices) {
        val rand = (0..3).random()
        create.fillwords(stream[i], rand)
    }

    for (i in list.indices) {
        println(list[i])
    }
    create.fillSpaces()
    create.printPuzzle()
    create.inpuzzle()

    println()
    val solver: puzzleSolver = puzzleSolver()
    solver.found(create.puzzle, create.inpuzzle, create)
}
