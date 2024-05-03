package com.privatedev.recetaApp.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.privatedev.recetaApp.R


class AdapterGripMenu : BaseAdapter {

    var context: Context? = null;
    var name: List<String>;
    var background: List<Int>;
    var icon: List<Int>;
    var colortransparent: List<Int>;


    constructor(context: Context?, name: List<String>, background: List<Int>, icon: List<Int>,colortransparent: List<Int>) : super() {
        this.context = context
        this.icon = (icon as List<Int>?)!!
        this.background = (background as List<Int>?)!!;
        this.name = (name as List<String>?)!!;
        this.colortransparent = (colortransparent as List<Int>?)!!;
    }


    override fun getCount(): Int {
        return name.size;
    }

    override fun getItem(position: Int): Any {
        return name[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
        var row = inflater.inflate(R.layout.item_menu, null);

        var backimage: ImageView = row.findViewById(R.id.back_image)
        var iconimage: ImageView = row.findViewById(R.id.icon_image)
        var name: TextView = row.findViewById(R.id.name_menuItem)
        var transparent: LinearLayout = row.findViewById(R.id.transparent_color)


        backimage.setBackgroundResource(background[position])
        iconimage.setImageResource(icon[position])
        name.text = this.name[position]
        transparent.setBackgroundResource(colortransparent[position])

        return row
    }

}