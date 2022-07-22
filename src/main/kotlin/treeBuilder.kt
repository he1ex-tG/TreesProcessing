enum class buildModes {
    EMPTY,
    FILL_RANDOM,
}

object TreeBuilder {
    fun build(mode: buildModes): Node = when(mode) {
        buildModes.FILL_RANDOM -> NodeNo()
        buildModes.EMPTY -> NodeNo()
    }
}