class Barrel<out T>(/*var*/val item: T)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("A normal fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    lootBarrel = fedoraBarrel
    val myFedora: Fedora = /*fedoraBarrel.item*/lootBarrel.item // Smart cast to Barrel<Fedora>
}
