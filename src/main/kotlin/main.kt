import kotlin.system.measureTimeMillis

fun main() {
    var treeAuto: Node
    val time = measureTimeMillis {
        treeAuto = TreeBuilder.buildAuto(5, BuildMode.FILL_HARD)
    }
    println(time)
    println()

    println("Auto tree max depth is " + TreeProcessor(treeAuto).maxDepth)
    println("Nodes sum of auto tree is " + TreeProcessor(treeAuto).nodesSum)

    println("Tree structure:")
    TreeProcessor(treeAuto).printTree()
}