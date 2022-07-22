enum class BuildModes {
    EMPTY,
    FILL_RANDOM,
    FILL_DEFAULT,
}

object TreeBuilder {
    fun build(mode: BuildModes = BuildModes.FILL_DEFAULT): Node = when(mode) {
        BuildModes.FILL_RANDOM -> NodeYes(
            (0..100).random(),
            NodeYes(
                (0..100).random(),
                NodeNo(),
                NodeNo()
            ),
            NodeYes(
                (0..100).random(),
                NodeNo(),
                NodeNo()
            )
        )
        BuildModes.FILL_DEFAULT -> NodeYes(
            1,
            NodeYes(
                2,
                NodeNo(),
                NodeNo()
            ),
            NodeYes(
                3,
                NodeNo(),
                NodeNo()
            )
        )
        BuildModes.EMPTY -> NodeNo()
    }

    private fun recurrentBuild(depth: Int, mode: BuildModes): Node = NodeNo()
}