fun main() {
    val treeEmpty = TreeBuilder.build(BuildModes.EMPTY)
    val treeDefault = TreeBuilder.build()
    val treeRandom = TreeBuilder.build(BuildModes.FILL_RANDOM)

    println("Nodes sum of empty tree is " + TreeProcessor(treeEmpty).calcSumOfNodes())
    println("Default nodes sum of tree is " + TreeProcessor(treeDefault).calcSumOfNodes())
    println("Random nodes sum of tree is " + TreeProcessor(treeRandom).calcSumOfNodes())

    println("Empty tree max depth is " + TreeProcessor(treeEmpty).maxDepth())
    println("Default tree max depth is " + TreeProcessor(treeDefault).maxDepth())
}