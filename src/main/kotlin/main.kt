fun main() {
    val treeAuto = TreeBuilder.buildAuto(3, BuildMode.FILL_RANDOM)
    println("Auto tree max depth is " + TreeProcessor(treeAuto).maxDepth)
    println("Nodes sum of auto tree is " + TreeProcessor(treeAuto).nodesSum)

    println("Tree structure:")
    TreeProcessor(treeAuto).printTree()
}