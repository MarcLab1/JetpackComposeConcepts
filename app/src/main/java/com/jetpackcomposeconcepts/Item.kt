package com.jetpackcomposeconcepts

class Item {
    lateinit var name: String
    var number: Int = 0
    var selected : Boolean = false

    constructor( number: Int, selected: Boolean) {
        this.name = "Item " + number.toString()
        this.number = number
        this.selected = selected
    }

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