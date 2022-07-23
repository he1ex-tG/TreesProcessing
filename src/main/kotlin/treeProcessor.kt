import kotlin.math.max

class TreeProcessor(
    private val baseNode: Node
) {
    fun maxDepth() = recurrentDepthCalc(baseNode)

    private fun recurrentDepthCalc(node: Node): Int = when(node) {
        is NodeNo -> 0
        is NodeYes -> 1 + max(recurrentDepthCalc(node.leftNode), recurrentDepthCalc(node.rightNode))
    }

    fun calcSumOfNodes() = recurrentCalcSumOfNodes(baseNode)

    private fun recurrentCalcSumOfNodes(node: Node): Int = when(node) {
        is NodeNo -> 0
        is NodeYes -> node.value + recurrentCalcSumOfNodes(node.leftNode) + recurrentCalcSumOfNodes(node.rightNode)
    }
}