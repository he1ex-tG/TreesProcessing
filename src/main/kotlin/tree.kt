sealed class Node

class NoneNo : Node()

class NodeYes(
    val value: Int,
    val leftNode: Node,
    val rightNode: Node
) : Node ()