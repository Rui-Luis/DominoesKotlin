fun main() {

    val dominoes = Game()
    dominoes.generateTiles()
    dominoes.playFirstTile()

    val playerOne = Player("Rui", dominoes)
    val playerTwo = Player("Rita", dominoes)

    var nobodyWins = true

    while (nobodyWins) {
        assert(!playerOne.hand.isEmpty())
        assert(!playerTwo.hand.isEmpty())

        playerOne.play()
        dominoes.printBoard()
        if (playerOne.hand.isEmpty()) {
            println("Player $playerOne has won!")
            break
        }

        playerTwo.play()
        dominoes.printBoard()
        if (playerTwo.hand.isEmpty()) {
            println("Player $playerTwo has won!")
            break
        }

    }
}