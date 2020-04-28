class Player(val name: String, val game: Game) {

    var hand = game.getHandTiles()

    // The playing logic.
    public fun play() {
        if (!hand.isEmpty()) {
            var tileWasPlayed = false
            for (tile in hand) {
                if (game.board.tiles.first().x == tile.x) {
                    tileWasPlayed = true
                    var playedTile = Tile(tile.y, tile.x)
                    println("$name plays $playedTile to connect to <" + game.board.tiles.first().x + ":" + game.board.tiles.first().y + "> on the board")

                    game.board.tiles.add(0, playedTile)

                    hand.remove(tile)

                    break
                }
                else if (game.board.tiles.first().x == tile.y) {
                    tileWasPlayed = true
                    var playedTile = tile
                    println("$name plays $playedTile to connect to <" + game.board.tiles.first().x + ":" + game.board.tiles.first().y + "> on the board")

                    game.board.tiles.add(0, playedTile)

                    hand.remove(tile)

                    break
                }
                else if (game.board.tiles.last().y == tile.x) {
                    tileWasPlayed = true
                    var playedTile = tile
                    println("$name plays $playedTile to connect to <" + game.board.tiles.last().x + ":" + game.board.tiles.last().y + "> on the board")

                    game.board.tiles.add(playedTile)

                    hand.remove(tile)

                    break
                }
                else if (game.board.tiles.last().y == tile.y) {
                    tileWasPlayed = true
                    var playedTile = Tile(tile.y, tile.x)
                    println("$name plays $playedTile to connect to <" + game.board.tiles.last().x + ":" + game.board.tiles.last().y + "> on the board")

                    game.board.tiles.add(playedTile)

                    hand.remove(tile)

                    break
                }
            }
            if (!tileWasPlayed && game.hasAvailableTiles()) {
                var grabbedTile = game.grabNewTile()
                hand.add(grabbedTile)
                println("$name can't play, drawing tile $grabbedTile")
                play()
            }
        }
    }

    override fun toString(): String {
        return name
    }

}