fun main() {
    println("Nodes sum of empty tree is " + TreeProcessor(TreeBuilder.build(BuildModes.EMPTY)).calcSumOfNodes())
    println("Default nodes sum of tree is " + TreeProcessor(TreeBuilder.build()).calcSumOfNodes())
    println("Random nodes sum of tree is " + TreeProcessor(TreeBuilder.build(BuildModes.FILL_RANDOM)).calcSumOfNodes())
}