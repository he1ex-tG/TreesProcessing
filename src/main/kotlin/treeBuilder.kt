import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
        override fun method(): Int = runBlocking {
            var result = 0
            val maxVal = Int.MAX_VALUE

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

            delay(100)

            result
        }
    };

    abstract fun method(): Int
}

object TreeBuilder {
    fun buildAuto(depth: Int = 0, mode: BuildMode = BuildMode.EMPTY): Node =
        recurrentBuild(depth) { mode.method() }


    private fun recurrentBuild(depth: Int, method: () -> Int): Node = runBlocking {
        if (depth > 0) {
            val leftNode = Channel<Node>()
            val rightNode = Channel<Node>()
            launch {
                leftNode.send(recurrentBuild(depth - 1, method))
            }
            launch {
                rightNode.send(recurrentBuild(depth - 1, method))
            }
            NodeYes(
                method(),
                leftNode.receive(),
                rightNode.receive()
            )
        } else {
            NodeNo()
        }
    }
}