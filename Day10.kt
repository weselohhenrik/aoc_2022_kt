import java.io.File
import kotlin.properties.Delegates

fun runDay10() {
    val input = File("./inputs/day10.txt").readLines()

    val cycleCounts = listOf(20, 60, 100, 140, 180, 220)
    val map: MutableMap<Int, Int> = mutableMapOf()
    var registerCount = 1
    var cycleCount: Int by Delegates.observable(0) { property, oldValue, newValue ->
        if (cycleCounts.contains(newValue)) {
            map[newValue] = registerCount
        }
    }

    for (line in input) {
        when (line) {
            "noop" -> { cycleCount += 1 }
            else -> {
                val split = line.split(" ")
                cycleCount +=1
                cycleCount +=1
                registerCount += split[1].toInt()
            }
        }
    }

    var result = 0
    map.forEach {
        println("CycleCount: ${it.key}, RegisterCount: ${it.value}")
        result += (it.key * it.value)
    }

    println(result)
}