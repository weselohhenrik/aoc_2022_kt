import java.io.File

fun runDay8() {
    val input = File("./inputs/day8.txt").readText()

    val tmp = input.replace("\r\n", "")

    val grid = tmp.map {
        it.code - '0'.code
    }

    val width = 99
    val height = 99

    //val pos = Position(x = 3, y = 2)
    //println(grid)
    //println(grid[pos.x + (width*pos.y)])

    var result = 0
    for (i in 1..98) {
        for (j in 1..98) {
            val pos = Position(x = j, y = i)
            result += checkVisibility(grid, pos)
        }
    }

    println(result)
}

data class Position(val x: Int, val y: Int)

fun checkVisibility(grid: List<Int>, position: Position): Int {
    var result = 0
    if (checkTop(position, grid) || checkBottom(position, grid) || checkLeft(position, grid) || checkRight(position, grid)) {
        result += grid[position.x + 99*position.y]
    }

    return result
}

fun checkRight(position: Position, grid: List<Int>): Boolean {

    val toCheck = grid[position.x + 99*position.y]
    var tallest = 0
    for (i in position.x..99) {
        val a = grid[position.x + 98*i]
        if (a >= tallest) {
            tallest = a
        }
    }

    return toCheck > tallest
}

fun checkLeft(position: Position, grid: List<Int>): Boolean {

    val toCheck = grid[position.x + 99*position.y]
    var tallest = 0
    for (i in position.x ..0) {
        val a = grid[position.x + 99*i]
        if (a >= tallest) {
            tallest = a
        }
    }

    return toCheck > tallest
}

fun checkBottom(position: Position, grid: List<Int>): Boolean {

    val toCheck = grid[position.x + 99*position.y]
    var tallest = 0
    for (i in position.y..99) {
        val a = grid[position.x + 98*i]
        if (a >= tallest) {
            tallest = a
        }
    }

    return toCheck > tallest
}

fun checkTop(position: Position, grid: List<Int>): Boolean {
    val toCheck = grid[position.x + 99*position.y]
    var tallest = 0
    for (i in position.y..0) {
        val a = grid[position.x + 99*i]
        if (a >= tallest) {
            tallest = a
        }
    }

    return toCheck > tallest
}
