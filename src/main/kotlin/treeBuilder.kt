enum class BuildMode {
    EMPTY,
    FILL_RANDOM,
    FILL_DEFAULT;
}

object TreeBuilder {
    private var defaultCounter = 1
    fun buildAuto(depth: Int = 0, mode: BuildMode = BuildMode.EMPTY): Node = when(mode) {
        BuildMode.EMPTY -> NodeNo()
        BuildMode.FILL_RANDOM -> recurrentBuild(depth, mode)
        BuildMode.FILL_DEFAULT -> recurrentBuild(depth, mode).also { defaultCounter = 1 }
    }

    private fun recurrentBuild(depth: Int, mode: BuildMode): Node =
        if (depth > 0) {
            NodeYes(
                when(mode) {
                    BuildMode.EMPTY -> 0
                    BuildMode.FILL_RANDOM -> (0..9).random()
                    BuildMode.FILL_DEFAULT -> defaultCounter++
                },
                recurrentBuild(depth - 1, mode),
                recurrentBuild(depth - 1, mode)
            )
        } else {
            NodeNo()
        }
}