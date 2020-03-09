package Puzzle

import java.io.File

fun main(args: Array<String>) {
    val create: PuzzleCreate = PuzzleCreate()
    var list: Array<String> = arrayOf()
    create.initializePuzzle(15, 15)
    val stream = File("D:\\Winter\\Puzzle\\Words.txt").readLines()
    for (i in stream.indices){
        list += stream[i]
    }

    for (i in list.indices){
        println(list[i])
    }
//    create.fillwords("simar", 0)
//    create.fillwords("param", 1)
//    create.fillwords("shruti", 2)
//    create.fillwords("fahad", 3)
//    create.fillSpaces()
//    create.printPuzzle()
//    create.inpuzzle()
//
//    println()
//    val solver: puzzleSolver = puzzleSolver()
//    solver.found(create.puzzle, create.inpuzzle)
}
