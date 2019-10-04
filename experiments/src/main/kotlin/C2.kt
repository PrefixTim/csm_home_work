class C2: C1 {
    constructor(): super()

    override val a: Int
        get() = 3
}

fun main(){
    var d :Uniq = C2()
    print(d.a)
}