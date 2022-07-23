fun main() {
    val treeEmpty = TreeBuilder.build(BuildMode.EMPTY)
    val treeDefault = TreeBuilder.build()
    val treeRandom = TreeBuilder.build(BuildMode.FILL_RANDOM)

    println("Nodes sum of empty tree is " + TreeProcessor(treeEmpty).calcSumOfNodes())
    println("Default nodes sum of tree is " + TreeProcessor(treeDefault).calcSumOfNodes())
    println("Random nodes sum of tree is " + TreeProcessor(treeRandom).calcSumOfNodes())

    println("Empty tree max depth is " + TreeProcessor(treeEmpty).maxDepth())
    println("Default tree max depth is " + TreeProcessor(treeDefault).maxDepth())
    println("Default tree max depth is " + TreeProcessor(treeRandom).maxDepth())

    val treeAuto = TreeBuilder.buildAuto(2, BuildMode.FILL_DEFAULT)
    println("Auto tree max depth is " + TreeProcessor(treeAuto).maxDepth())
    println("Nodes sum of auto tree is " + TreeProcessor(treeAuto).calcSumOfNodes())
}