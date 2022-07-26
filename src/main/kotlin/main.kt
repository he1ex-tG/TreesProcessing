import kotlin.system.measureTimeMillis

fun main() {
    var treeAutoConcurrency: Node
    val timeConcurrency = measureTimeMillis {
        treeAutoConcurrency = TreeBuilder.buildAuto(5, BuildMode.FILL_HARD, Concurrency.WITH_CONCURRENCY)
    }
    println("Build tree with concurrency in $timeConcurrency ms")
    val timeNoConcurrency = measureTimeMillis {
        TreeBuilder.buildAuto(5, BuildMode.FILL_HARD, Concurrency.WITHOUT_CONCURRENCY)
    }
    println("Build tree with concurrency in $timeNoConcurrency ms")
    println()

    println("Auto tree max depth is " + TreeProcessor(treeAutoConcurrency).maxDepth)
    println("Nodes sum of auto tree is " + TreeProcessor(treeAutoConcurrency).nodesSum)

    println("Tree structure:")
    TreeProcessor(treeAutoConcurrency).printTree()
}