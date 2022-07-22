class treeProcessing(
    private val baseNode: Node
) {
    fun calcSumOfNodes() = recurrentCalcSumOfNodes(baseNode)

    private fun recurrentCalcSumOfNodes(node: Node): Int = when(node) {
        is NodeNo -> 0
        is NodeYes -> node.value + recurrentCalcSumOfNodes(node.leftNode) + recurrentCalcSumOfNodes(node.rightNode)
    }
}