import java.io.File

fun main(args: Array<String>) {

    /**
    var menuFile = File("menu-file.txt")
    menuFile.setReadable(true)
    menuFile.setWritable(true)
    menuFile.setExecutable(false)
     */

    /**
     * apply
     */
    var menuFile = File("menu-file.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }

    /**
    val firstElement = listOf(1, 2, 3).first()
    val firstItemSquared = firstElement * firstElement
     */

    /**
     * let
     */
    val firstItemSquared = listOf(1, 2, 3).first().let {
        it * it
    }


    /**
    println(createMessageToPlayer(isLongName("Polarcubis, Supreme Master of NyetHack")))
     */

    /**
     * run
     */
    "Polarcubis, Supreme Master of NyetHack"
        .run(::isLongName)
        .run(::createMessageToPlayer)
        .run(::println)

    /**
     * with: Recommend to use `run` instead of` with`.
     * Different functions and invocation methods are inconsistent.
     */
    val tooLongName = with("Polarcubis, Supreme Master of NyetHack") {
        length >= 20
    }

    /**
     * also: It returns a recipient object instead of a lambda result,
     * so you can chain a function to the original recipient object.
     */
    var fileContents1: List<String>
    File("menu-file.txt")
        .also {
            println(it.exists())
        }
        .also {
            println(it.name)
        }.also {
            fileContents1 = it.readLines()
        }

    /**
    val file = File("menu-file.txt")
    val fileContents2 = if (file.canRead() && file.canWrite()) {
        file.readText()
    } else {
        null
    }
     */
    
    /**
     * takeIf
     */
    var fileContents2 = File("menu-file.txt")
        .takeIf { it.canRead() && it.canWrite() }
        ?.readText()

    println(fileContents2)
}

fun isLongName(name: String) = name.length >= 20

fun createMessageToPlayer(tooLongName: Boolean): String {
    return if (tooLongName) {
        "Name is too long. Please choose another name"
    } else {
        "Welcome, adventurer"
    }
}
