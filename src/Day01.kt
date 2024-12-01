import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val lefts = mutableListOf<Int>()
        val rights = mutableListOf<Int>()

        for (line in input) {
            val pair = line.substringBefore(' ') to line.substringAfterLast(' ')

            lefts.add(pair.first.toInt())
            rights.add(pair.second.toInt())
        }

        lefts.sort().also { rights.sort() }
        val sortedList = lefts.zip(rights)
        return sortedList.sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val lefts = mutableListOf<Int>()
        val rights = mutableListOf<Int>()

        for (line in input) {
            val pair = line.substringBefore(' ') to line.substringAfterLast(' ')

            lefts.add(pair.first.toInt())
            rights.add(pair.second.toInt())
        }

        val sum = lefts.sumOf { left ->
            val amount = rights.withIndex().filter { it.value == left }.map { it.index }.count()
            left * amount
        }

        return sum
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11) { "Test input result was: ${part1(testInput)}" }
    check(part2(testInput) == 31) { "Test input result was: ${part2(testInput)}" }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
