package com.jetpackcomposeconcepts

class Item {

    constructor( number: Int, selected: Boolean) {
        this.name = "Item " + number.toString()
        this.number = number
        this.selected = selected
    }

    var name: String = ""
    var number: Int = 0
    var selected: Boolean = false

    override fun toString() : String{
        return name + " is " + selected
    }
}

class ItemRepo {

    lateinit var items: ArrayList<Item>

    constructor() {
        items = ArrayList<Item>()

        for(index in 1..10)
            items.add(Item( index, false))
    }
}