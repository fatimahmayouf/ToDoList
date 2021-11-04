package com.example.todoapplication.views.body

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator


abstract class SwipeItem(context: Context) : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {


    val deleteColor = ContextCompat.getColor(context, R.color.red)
    val deleteIcon = R.drawable.ic_baseline_delete_sweep_24

    val completeColor = ContextCompat.getColor(context, R.color.green)
    val completeIcon = R.drawable.ic_baseline_done_24

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

            .addSwipeRightBackgroundColor(deleteColor)
            .addSwipeRightActionIcon(deleteIcon)


            .addSwipeLeftBackgroundColor(completeColor)
            .addSwipeLeftActionIcon(completeIcon)
            .create()
            .decorate()
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}