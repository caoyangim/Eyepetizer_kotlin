package com.cy.eyepetizer.ui.home.recycle

import com.cy.eyepetizer.logic.model.Item
import java.util.*

enum class ItemTypeEnum(val typeId:Int,val type:String?=null,val dataType:String? = null) {

    UNKNOWN(-1,"UNKNOWN"),

    TEXTCARD_HEADER4(1,"TextCard","header4"),

    TEXTCARD_HEADER5(2,"TextCard","header5"),

    HORIZONTALSCROLLCARD_HORIZONTALSCROLLCARD(3,"horizontalScrollCard","HorizontalScrollCard"),

    SPECIALSQUARECARDCOLLECTION_ITEMCOLLECTION(4,"",""),

    COLUMNCARDLIST_ITEMCOLLECTION(5),

    TEXTCARD_TEXTCARDWITHRIGHTANDLEFTTITLE(6),

    BANNER_BANNER(7),

    VIDEOSMALLCARD_VIDEOBEANFORCLIENT(8),

    BRIEFCARD_TAGBRIEFCARD(9);


    companion object{
        fun findType(item:Item):Int = try {
           valueOf("${item.type}_${item.data.dataType}".toUpperCase(Locale.ROOT)).typeId
        }catch (e:Exception){
            -1
        }

        fun getTypeEnum(typeId: Int):ItemTypeEnum{
            for (e in values()){
                if (e.typeId == typeId) return e
            }
            return UNKNOWN
        }
    }



}