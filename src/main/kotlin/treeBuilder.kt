import kotlin.math.sqrt

enum class BuildMode {
    EMPTY {
        override fun method() = 0
    },
    FILL_RANDOM {
        override fun method() = (0..9).random()
    },
    FILL_DEFAULT {
        private var x = 1
        override fun method() = x++
    },
    FILL_HARD {
        override fun method(): Int {
            var result = 0
            for (maxVal in Int.MAX_VALUE / 2..Int.MAX_VALUE / 2 + 99000) {
                var n = (maxVal / 2..maxVal).random()

                while (n % 2 == 0) {
                    result += 2
                    n /= 2
                }

                var i = 3
                while (i <= sqrt(n.toDouble())) {
                    while (n % i == 0) {
                        result += i
                        n /= i
                    }
                    i += 2
                }

                if (n > 2)
                    result += n

                result %= 9
            }

            return result
        }
    };

    abstract fun method(): Int
}

object TreeBuilder {
    fun buildAuto(depth: Int = 0, mode: BuildMode = BuildMode.EMPTY): Node =
        recurrentBuild(depth) { mode.method() }

    private fun recurrentBuild(depth: Int, method: () -> Int): Node =
        if (depth > 0) {
            NodeYes(
                method(),
                recurrentBuild(depth - 1, method),
                recurrentBuild(depth - 1, method)
            )
        } else {
            NodeNo()
        }
}