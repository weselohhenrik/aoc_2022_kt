import java.io.File

fun runDay5() {
    val stack1 = ArrayDeque(listOf('D', 'L', 'J', 'R', 'V', 'G', 'F'))
    val stack2 = ArrayDeque(listOf('T', 'P', 'M', 'B', 'V', 'H', 'J', 'S'))
    val stack3 = ArrayDeque(listOf('V', 'H', 'M', 'F', 'D', 'G', 'P', 'C'))
    val stack4 = ArrayDeque(listOf('M','D','P','N','G', 'Q'))
    val stack5 = ArrayDeque(listOf('J', 'L', 'H', 'N', 'F'))
    val stack6 = ArrayDeque(listOf('N', 'F', 'V', 'Q', 'D', 'G', 'T', 'Z'))
    val stack7 = ArrayDeque(listOf('F', 'D', 'B', 'L'))
    val stack8 = ArrayDeque(listOf('M', 'J', 'B', 'S', 'V', 'D', 'N'))
    val stack9 = ArrayDeque(listOf('G', 'L', 'D'))

    val listOfStacks = mutableListOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9) as ArrayList

    val inputs = File("./inputs/day5.txt").readText()
    val t = inputs.split("\r\n\r\n")
    val instructions = t[1].split("\r\n")

    instructions.forEach { instr ->
        val a = instr.split(" ")
        val howMany = a[1].toInt()
        val from = a[3].toInt()
        val to = a[5].toInt()
        val movedCrates = moveCratesPart2(
            howMany = howMany,
            from = listOfStacks[from-1],
            to = listOfStacks[to-1]
        )
        listOfStacks[from-1] = movedCrates.first
        listOfStacks[to-1] = movedCrates.second

    }
    listOfStacks.forEach {
        print(it.last())
    }
}

fun moveCrates(howMany: Int, from: ArrayDeque<Char>, to: ArrayDeque<Char>): Pair<ArrayDeque<Char>, ArrayDeque<Char>> {

    for (i in 1..howMany) {
        val tmp = from.removeLast()
        to.addLast(tmp)
    }
    return Pair(first = from, second = to)
}

fun moveCratesPart2(howMany: Int, from: ArrayDeque<Char>, to: ArrayDeque<Char>): Pair<ArrayDeque<Char>, ArrayDeque<Char>> {
    val tmp = ArrayList<Char>()
    for (i in 1..howMany) {
        tmp.add(from.removeLast())
    }
    tmp.reverse()
    tmp.forEach {
        to.addLast(it)
    }
    return Pair(first = from, second = to)
}