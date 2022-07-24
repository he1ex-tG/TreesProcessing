import kotlin.math.max

class TreeProcessor(
    private val baseNode: Node
) {
    val maxDepth
        get() = recurrentDepthCalc(baseNode)
    val nodesSum
        get() = recurrentCalcSumOfNodes(baseNode)

    private fun recurrentDepthCalc(node: Node): Int = when(node) {
        is NodeNo -> 0
        is NodeYes -> 1 + max(recurrentDepthCalc(node.leftNode), recurrentDepthCalc(node.rightNode))
    }

    private fun recurrentCalcSumOfNodes(node: Node): Int = when(node) {
        is NodeNo -> 0
        is NodeYes -> node.value + recurrentCalcSumOfNodes(node.leftNode) + recurrentCalcSumOfNodes(node.rightNode)
    }

    fun printTree() {
        val treeString = treeToString(baseNode).trim().split(" ")
        recurrentPrintTree(maxDepth, listOf(treeString))
    }

    private fun recurrentPrintTree(depth: Int, list: List<List<String>>) {
        if (depth > 0) {
            val nextIterationList = mutableListOf<List<String>>()
            for (curCase in list) {
                val index = curCase.size / 2
                print(" ".repeat(index) + curCase[index] + " ".repeat(index + 1))
                nextIterationList.add(curCase.subList(0, index))
                nextIterationList.add(curCase.subList(index + 1, curCase.size))
            }
            println()
            recurrentPrintTree(depth - 1, nextIterationList)
        }
    }

    private fun treeToString(node: Node): String = when(node) {
        is NodeNo -> " "
        is NodeYes -> "${treeToString(node.leftNode)}${node.value}${treeToString(node.rightNode)}"
    }
}