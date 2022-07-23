enum class BuildMode {
    EMPTY,
    FILL_RANDOM,
    FILL_DEFAULT,
}

object TreeBuilder {
    fun build(mode: BuildMode = BuildMode.FILL_DEFAULT): Node = when (mode) {
        BuildMode.FILL_RANDOM -> NodeYes(
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
        BuildMode.FILL_DEFAULT -> NodeYes(
            1,
            NodeYes(
                2,
                NodeNo(),
                NodeNo()
            ),
            NodeYes(
                3,
                NodeNo(),
                NodeYes(
                    4,
                    NodeNo(),
                    NodeNo()
                )
            )
        )
        BuildMode.EMPTY -> NodeNo()
    }

    fun buildAuto(depth: Int = 0, mode: BuildMode = BuildMode.EMPTY): Node = when(mode) {
        BuildMode.EMPTY -> NodeNo()
        else -> recurrentBuild(depth, mode)
    }

    private fun recurrentBuild(depth: Int, mode: BuildMode): Node =
        if (depth > 0) {
            NodeYes(
                1,
                recurrentBuild(depth - 1, mode),
                recurrentBuild(depth - 1, mode)
            )
        } else {
            NodeNo()
        }
}