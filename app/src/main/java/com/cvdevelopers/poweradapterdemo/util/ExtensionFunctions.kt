package com.cvdevelopers.poweradapterdemo.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(res: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(this.getContext()).inflate(res, this, attachToRoot)