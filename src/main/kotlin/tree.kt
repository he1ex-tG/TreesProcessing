sealed interface Node

object NodeNo : Node

class NodeYes(
    val value: Int,
    val leftNode: Node,
    val rightNode: Node,
) : Node