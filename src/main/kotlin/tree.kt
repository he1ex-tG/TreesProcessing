sealed interface Node

class NodeNo : Node

class NodeYes(
    val value: Int,
    val leftNode: Node,
    val rightNode: Node,
) : Node