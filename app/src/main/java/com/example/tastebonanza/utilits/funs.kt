package com.example.tastebonanza.utilits

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tastebonanza.business.model.Recipe
import android.R
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tastebonanza.presentation.adapter.IngredientsAdapter

fun replaceFragmentMain(fagmnt: Fragment, aStack: Boolean = true) {
    if (aStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                com.example.tastebonanza.R.id.main_layout,
                fagmnt
            ).commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(
                com.example.tastebonanza.R.id.main_layout,
                fagmnt
            ).commit()
    }
}

@SuppressLint("ObsoleteSdkInt")
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun setStatusBarGradiantMain(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window: Window = activity.window
        //val background = ContextCompat.getDrawable(activity, R.color.background)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        window.statusBarColor = ContextCompat.getColor(activity,android.R.color.transparent)
        //window.setBackgroundDrawable(background)
    }
}

@SuppressLint("CutPasteId")
fun getDialogDetails(
    recipe: Recipe,
    requireContext: Context,
    adapter: IngredientsAdapter
) {
    val dialog = Dialog(requireContext, R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen)

    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)


    dialog.setContentView(com.example.tastebonanza.R.layout.full_screen_details_recipe)
    dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    dialog.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    dialog.window?.statusBarColor = ContextCompat.getColor(requireContext, android.R.color.transparent)

    val name : TextView = dialog.findViewById(com.example.tastebonanza.R.id.tv_name_recipe_details)
    val tag : TextView = dialog.findViewById(com.example.tastebonanza.R.id.tv_tag_details)
    val servings : TextView = dialog.findViewById(com.example.tastebonanza.R.id.tv_servings_details)
    val time : TextView = dialog.findViewById(com.example.tastebonanza.R.id.tv_time_details)
    val calories : TextView = dialog.findViewById(com.example.tastebonanza.R.id.tv_calories_details)
    val icon : ImageView = dialog.findViewById(com.example.tastebonanza.R.id.icon_details)

    val btRecipe : ConstraintLayout = dialog.findViewById(com.example.tastebonanza.R.id.bt_details)
    val blockIngredients : ConstraintLayout = dialog.findViewById(com.example.tastebonanza.R.id.block_ingredients)
    val blockRecipe : ConstraintLayout = dialog.findViewById(com.example.tastebonanza.R.id.block_cooking)
    val btIngredients : ConstraintLayout = dialog.findViewById(com.example.tastebonanza.R.id.bt_ingredients)
    val textRecipe : TextView = dialog.findViewById(com.example.tastebonanza.R.id.tv_text_recipe)

    val rvIngredients : RecyclerView = dialog.findViewById(com.example.tastebonanza.R.id.rv_ingredients)
    val btArrow : ImageView = dialog.findViewById(com.example.tastebonanza.R.id.ic_arrow)

    btArrow.setOnClickListener { dialog.cancel() }

    btRecipe.setOnClickListener {
        blockIngredients.visibility = View.GONE
        blockRecipe.visibility = View.VISIBLE
    }

    btIngredients.setOnClickListener {
        blockRecipe.visibility = View.GONE
        blockIngredients.visibility = View.VISIBLE
    }

    textRecipe.setText(recipe.recipe)
    name.setText(recipe.name)
    tag.setText(recipe.tag)
    servings.text = recipe.servings
    time.text = recipe.time
    calories.text = recipe.calories.toString()

    Glide.with(requireContext).load(recipe.icon).into(icon)

    rvIngredients.layoutManager = LinearLayoutManager(requireContext, LinearLayoutManager.VERTICAL, false)
    rvIngredients.adapter = adapter

    adapter.setItem(recipe.ingredients)



    dialog.show()
}

