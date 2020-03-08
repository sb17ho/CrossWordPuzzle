package Puzzle

fun main(args: Array<String>) {
    val create: PuzzleCreate = PuzzleCreate()
    create.initializePuzzle(15, 15)
    create.fillwords("simar", 0)
    create.fillwords("param", 1)
    create.fillwords("shruti", 2)
    create.fillwords("fahad", 3)
//    create.fillSpaces()
    create.printPuzzle()
//    create.inpuzzle()

    println()
    val solver: puzzleSolver = puzzleSolver()
    solver.found(create.puzzle, create.inpuzzle)
}
