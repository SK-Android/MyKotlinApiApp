package com.androidapp.mcs.mykotlinapiapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import javax.xml.transform.Result

data class pojo(val title : String, val ingredients : String, val href : String, val thumbnail : String)